import java.util.Random;

public class Tablero {
    private Ficha[][] fichas;
    private int filas;
    private int columnas;
    private int paresEmparejados;

    public Tablero(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.fichas = new Ficha[filas][columnas];
        this.paresEmparejados = 0;
        inicializarFichas();
    }

    private void inicializarFichas() {
        String[] valores = generarValoresPareados(filas * columnas);
        Random random = new Random();
        int index = 0;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                int posicion = random.nextInt(valores.length - index) + index;
                String valor = valores[posicion];
                valores[posicion] = valores[index];
                valores[index] = valor;
                fichas[i][j] = new Ficha(valor);
                index++;
            }
        }
    }

    private String[] generarValoresPareados(int total) {
        String[] valores = new String[total];
        char letra = 'A';
        for (int i = 0; i < total; i += 2) {
            valores[i] = String.valueOf(letra);
            valores[i + 1] = String.valueOf(letra);
            letra++;
        }
        return valores;
    }

    public Ficha obtenerFicha(int fila, int columna) {
        return fichas[fila][columna];
    }

    public boolean esEmparejable(int[] f1, int[] f2) {
        Ficha ficha1 = obtenerFicha(f1[0], f1[1]);
        Ficha ficha2 = obtenerFicha(f2[0], f2[1]);
        return ficha1.getValor().equals(ficha2.getValor());
    }

    public boolean todasEmparejadas() {
        return paresEmparejados == (filas * columnas) / 2;
    }

    public String mostrarTablero() {
        StringBuilder sb = new StringBuilder("   ");
        for (int col = 0; col < columnas; col++) {
            sb.append(col).append(" ");
        }
        sb.append("\n");

        for (int i = 0; i < filas; i++) {
            sb.append(i).append("  ");
            for (int j = 0; j < columnas; j++) {
                sb.append(fichas[i][j].toString()).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public Tablero aumentarParesEmparejados() {
        this.paresEmparejados++;
        return this;
    }

    public int getFilas() {
        return this.filas;
    }

    public int getColumnas() {
        return this.columnas;
    }
}

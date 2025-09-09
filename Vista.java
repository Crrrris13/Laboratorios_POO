import java.util.Scanner;

public class Vista {
    private Scanner scanner = new Scanner(System.in);
    private Validador validador = new Validador();

    public String pedirNombreJugador(String jugadorLabel) {
        System.out.print("Ingrese el nombre del " + jugadorLabel + ": ");
        return scanner.nextLine();
    }

    public int[] pedirCoordenada(String nombreJugador, int filas, int columnas) throws ExcepcionEntradaInvalida {
        System.out.println(nombreJugador + ", ingresa coordenadas (fila y columna):");
        String filaStr = scanner.next();
        String colStr = scanner.next();

        if (!validador.esNumeroEntero(filaStr) || !validador.esNumeroEntero(colStr)) {
            throw new ExcepcionEntradaInvalida("Debe ingresar números válidos.");
        }

        int fila = Integer.parseInt(filaStr);
        int columna = Integer.parseInt(colStr);

        if (!validador.coordenadaValida(fila, columna, filas, columnas)) {
            throw new ExcepcionEntradaInvalida("Coordenada fuera de rango.");
        }

        return new int[]{fila, columna};
    }

    public void mostrarTablero(String tablero) {
        System.out.println(tablero);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}

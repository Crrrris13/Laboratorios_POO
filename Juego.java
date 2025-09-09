public class Juego {
    private Tablero tablero;

    public Juego(Tablero tablero) {
        this.tablero = tablero;
    }

    public Tablero getTablero() {
        return this.tablero;
    }

    public Juego setTablero(Tablero tablero) {
        this.tablero = tablero;
        return this;
    }

    public boolean estaFinalizado() {
        return this.tablero.todasEmparejadas();
    }

    public String mostrarTablero() {
        return this.tablero.mostrarTablero();
    }
}

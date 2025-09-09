public class ControladorJuego {
    private Juego juego;
    private Validador validador;
    private Jugador jugador1;
    private Jugador jugador2;
    private boolean turnoJugador1;

    public ControladorJuego(String nombreJugador1, String nombreJugador2, int filas, int columnas) {
        this.jugador1 = new Jugador(nombreJugador1);
        this.jugador2 = new Jugador(nombreJugador2);
        this.turnoJugador1 = true;
        this.juego = new Juego(new Tablero(filas, columnas));
        this.validador = new Validador();
    }

    public String mostrarTablero() {
        return this.juego.mostrarTablero();
    }

    public boolean validarCoordenada(int fila, int columna) {
        return validador.coordenadaValida(fila, columna,
                this.juego.getTablero().getFilas(),
                this.juego.getTablero().getColumnas());
    }

    public boolean fichaYaDescubierta(int fila, int columna) {
        return this.juego.getTablero().obtenerFicha(fila, columna).estaDescubierta();
    }

    public void descubrirFicha(int fila, int columna) {
        this.juego.getTablero().obtenerFicha(fila, columna).descubrir();
    }

    public void ocultarFicha(int fila, int columna) {
        this.juego.getTablero().obtenerFicha(fila, columna).ocultar();
    }

    public boolean comprobarEmparejamiento(int[] f1, int[] f2) {
        return this.juego.getTablero().esEmparejable(f1, f2);
    }

    public void emparejarFichas(int[] f1, int[] f2) {
        this.juego.getTablero().obtenerFicha(f1[0], f1[1]).emparejar();
        this.juego.getTablero().obtenerFicha(f2[0], f2[1]).emparejar();
        this.juego.getTablero().aumentarParesEmparejados();

        getJugadorDelTurno().sumarPunto();
    }

    public boolean juegoFinalizado() {
        return this.juego.estaFinalizado();
    }

    public void cambiarTurno() {
        turnoJugador1 = !turnoJugador1;
    }

    public Jugador getJugadorDelTurno() {
        return turnoJugador1 ? jugador1 : jugador2;
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }
}

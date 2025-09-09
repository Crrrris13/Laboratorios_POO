public class Main {
    public static void main(String[] args) {
        Vista vista = new Vista();
        int filas = 4;
        int columnas = 4;

        String nombre1 = vista.pedirNombreJugador("Jugador 1");
        String nombre2 = vista.pedirNombreJugador("Jugador 2");

        ControladorJuego controlador = new ControladorJuego(nombre1, nombre2, filas, columnas);

        while (!controlador.juegoFinalizado()) {
            vista.mostrarTablero(controlador.mostrarTablero());

            Jugador actual = controlador.getJugadorDelTurno();
            vista.mostrarMensaje("Turno de: " + actual.getNombre());

            int[] coord1 = null;
            int[] coord2 = null;

            try {
                coord1 = vista.pedirCoordenada(actual.getNombre(), filas, columnas);
                while (!controlador.validarCoordenada(coord1[0], coord1[1]) || controlador.fichaYaDescubierta(coord1[0], coord1[1])) {
                    vista.mostrarMensaje("Coordenada inválida o ficha ya descubierta.");
                    coord1 = vista.pedirCoordenada(actual.getNombre(), filas, columnas);
                }

                controlador.descubrirFicha(coord1[0], coord1[1]);
                vista.mostrarTablero(controlador.mostrarTablero());

                coord2 = vista.pedirCoordenada(actual.getNombre(), filas, columnas);
                while (!controlador.validarCoordenada(coord2[0], coord2[1]) ||
                        controlador.fichaYaDescubierta(coord2[0], coord2[1]) ||
                        (coord1[0] == coord2[0] && coord1[1] == coord2[1])) {
                    vista.mostrarMensaje("Coordenada inválida o ficha ya descubierta.");
                    coord2 = vista.pedirCoordenada(actual.getNombre(), filas, columnas);
                }

                controlador.descubrirFicha(coord2[0], coord2[1]);
                vista.mostrarTablero(controlador.mostrarTablero());

                if (controlador.comprobarEmparejamiento(coord1, coord2)) {
                    controlador.emparejarFichas(coord1, coord2);
                    vista.mostrarMensaje("¡Correcto! Ganas un punto.");
                } else {
                    controlador.ocultarFicha(coord1[0], coord1[1]);
                    controlador.ocultarFicha(coord2[0], coord2[1]);
                    vista.mostrarMensaje("Incorrecto. Turno del otro jugador.");
                    controlador.cambiarTurno();
                }

            } catch (ExcepcionEntradaInvalida e) {
                vista.mostrarMensaje("Error: " + e.getMessage());
            }
        }

        vista.mostrarMensaje("¡Juego finalizado!");
        vista.mostrarMensaje("Puntaje Final:");
        vista.mostrarMensaje(controlador.getJugador1().getNombre() + ": " + controlador.getJugador1().getPuntaje());
        vista.mostrarMensaje(controlador.getJugador2().getNombre() + ": " + controlador.getJugador2().getPuntaje());
    }
}

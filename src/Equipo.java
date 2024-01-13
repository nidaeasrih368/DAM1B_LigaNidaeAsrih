public class Equipo {
    private String nombre;
    private String ciudad;
    private final int NUM_MAX_JUGADORES = 22;
    private Jugador[] ListaJugadores;

    public Equipo(String nombre, String ciudad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.ListaJugadores = new Jugador[NUM_MAX_JUGADORES];
    }

    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public int getNumJugadores() {
        int numeroJugadores = 0;
        for (int i = 0; i < ListaJugadores.length; i++) {
            if (ListaJugadores[i] != null) {
                numeroJugadores++;
            }
        }
        return numeroJugadores;
    }

    public void mostrarListaJugadores() {
        StringBuilder sb = new StringBuilder("Listado de Jugadores:\n");
        for (int i = 0; i < ListaJugadores.length; i++) {
            sb.append(ListaJugadores[i].getNombre() + "\n");
        }
    }

    public void adquirirJugador(Jugador jugador) {
        if (puedeAnadirJugadores()) {
            for (int i = 0; i < ListaJugadores.length; i++) {
                if (ListaJugadores[i] == null) {
                    ListaJugadores[i] = jugador;
                    System.out.println("El jugador ha sido añadido.");
                    break;
                }
            }
        } else {
            System.out.println("El equipo está lleno.");
        }
    }

    public void venderJugador(String nombreJugador) {
        if (hayJugadores()) {
            for (int i = 0; i < ListaJugadores.length; i++) {
                if (ListaJugadores[i].getNombre().equals(nombreJugador)) {
                    ListaJugadores[i] = null;
                    System.out.println("Se ha vendido al jugador.");
                    break;
                }
            }
        }
    }

    private boolean puedeAnadirJugadores() {
        for (int i = 0; i < ListaJugadores.length; i++) {
            if (ListaJugadores[i] == null) {
                return true;
            }
        }
        return false;
    }

    private boolean hayJugadores() {
        for (int i = 0; i < ListaJugadores.length; i++) {
            if (ListaJugadores[i] != null) {
                return true;
            }
        }
        return false;
    }
}

public class Liga {

    private String pais;
    private final int NUM_MAX_EQUIPOS = 20;
    private Equipo[] ListadoEquipos;

    public Liga(String pais) {
        this.pais = pais;
        this.ListadoEquipos = new Equipo[NUM_MAX_EQUIPOS];
    }

    public void mostrarListadoEquipos() {
        StringBuilder sb = new StringBuilder("Listado de Equipos:\n");
        for (int i = 0; i < ListadoEquipos.length; i++) {
            sb.append(ListadoEquipos[i].getNombre()).append("\n");
        }
    }

    public int getNumEquipos() {
        int numeroEquipos = 0;
        for (int i = 0; i < ListadoEquipos.length; i++) {
            if (ListadoEquipos[i] != null) {
                numeroEquipos++;
            }
        }
        return numeroEquipos;
    }

    public Equipo getEquipo(String nombreEquipo) {
        for (int i = 0; i < ListadoEquipos.length; i++) {
            if (ListadoEquipos[i].getNombre().equals(nombreEquipo)) {
                return ListadoEquipos[i];
            }
        }
        return null;
    }

    public String getPais() {
        return pais;
    }

    public void anadirEquipo(Equipo equipo) {
        if (puedeAnadirEquipos()) {
            for (int i = 0; i < ListadoEquipos.length; i++) {
                if (ListadoEquipos[i] == null) {
                    ListadoEquipos[i] = equipo;
                    System.out.println("El equipo ha sido añadido.");
                    break;
                }
            }
        } else {
            System.out.println("La liga está llena.");
        }
    }

    private boolean puedeAnadirEquipos() {
        for (int i = 0; i < ListadoEquipos.length; i++) {
            if (ListadoEquipos[i] == null) {
                return true;
            }
        }
        return false;
    }
}

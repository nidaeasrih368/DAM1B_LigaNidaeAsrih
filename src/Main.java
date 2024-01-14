import java.util.Scanner;

public class Main {
    static Scanner teclado = new Scanner(System.in);
    static Liga liga = null;
    static Equipo equipo = null;
    static Jugador jugador = null;
    public static void main(String[] args){
        System.out.println("Empiece creando una liga: ");
        String nombreLiga = teclado.nextLine();
        System.out.println("Inserte el país de la liga: ");
        String paisLiga = teclado.nextLine();
        liga = new Liga(paisLiga);

        int opcion;

        do {
            System.out.println("""
                    MENU DE LA LIGA
                    1- Insertar Equipo
                    2- Insertar Jugador
                    3- Ver equipos de la liga
                    4- Ver jugadores de un equipo
                    5- Vender jugador
                    6- Salir
                    """);

            System.out.print("Selecciona una opción: ");
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    insertarEquipo(liga);
                    break;
                case 2:
                    insertarJugador(liga);
                    break;
                case 3:
                    verLiga(liga);
                    break;
                case 4:
                    verJugadores(liga);
                    break;
                case 5:
                    venderJugador();
                    break;
                case 6:
                    salir();
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 6);
    }
    static void insertarEquipo(Liga liga){
        System.out.println("Inserte el nombre del equipo: ");
        String nombreEquipo = teclado.nextLine();
        System.out.println("Inserte la ciudad del equipo: ");
        String ciudadEquipo = teclado.nextLine();

        System.out.println("Creando equipo...");
        equipo = new Equipo(nombreEquipo, ciudadEquipo);

        System.out.println("Insertando equipo...");
        liga.anadirEquipo(equipo);

        System.out.println("Equipo " + nombreEquipo.toUpperCase() + " insertado.");
    }

    static void insertarJugador(Liga liga){

        /**
         * POR Portero
         * DEF Defensa
         * CTC Centrocampista
         * DEL Delantero
         * */
        String[] posiciones = {"POR", "DEF", "CTC", "DEL"};

        System.out.println("Indique el nombre del equipo donde quiere insertar el jugador: ");
        String nombreEquipo = teclado.nextLine();
        System.out.println("Indique el nombre del jugador: ");
        String nombreJugador = teclado.nextLine();
        System.out.println("Indique la nacionalidad del jugador: ");
        String nacionalidadJugador = teclado.nextLine();
        System.out.println("Indique la edad del jugador: ");
        int edadJugador = teclado.nextInt();
        teclado.nextLine();

        boolean esCorrecto;
        String posicionJugador;

        do {
            System.out.println("Indique la posición del jugador (POR, DEF, CTC, DEL): ");
            posicionJugador = teclado.nextLine();
            esCorrecto = false;

            for (int i = 0; i < posiciones.length; i++) {
                if (posiciones[i].equalsIgnoreCase(posicionJugador)) {
                    esCorrecto = true;
                    break;
                }
            }
            if (!esCorrecto) {
                System.out.println("Posición no válida.");
            }

        } while (!esCorrecto);

        System.out.println("Creando jugador...");
        jugador = new Jugador(nombreJugador, nacionalidadJugador, edadJugador, posicionJugador);

        System.out.println("Insertando jugador...");
        if (liga.getEquipo(nombreEquipo) == null) {
            System.out.println("El equipo indicado no existe");
        } else {
            Equipo eq = liga.getEquipo(nombreEquipo);
            eq.adquirirJugador(jugador);
            System.out.println("Jugador " + nombreJugador.toUpperCase() + " insertado en " + nombreEquipo.toUpperCase());
        }
    }

    static void verLiga(Liga liga){
        System.out.println("**********COMPOSICIÓN DE LA LIGA*************************");
        liga.mostrarListadoEquipos();
        System.out.println("*********************************************************");
    }

    static void verJugadores(Liga liga){
        System.out.println("Indique el equipo que quiere visualizar: ");
        String equipoAmostrar = teclado.nextLine();

        if (liga.getEquipo(equipoAmostrar) == null) {
            System.out.println("El equipo indicado no existe");
        } else {
            System.out.println("*********"+ equipoAmostrar + "****************************");
            if (liga.getEquipo(equipoAmostrar) !=null){
                equipo.mostrarListaJugadores();
            }
            System.out.println("*********************************************");
        }

    }

    static void venderJugador(){
        System.out.println("Inserte el nombre del equipo donde quiere vender el jugador: ");
        String equipoVentaJug = teclado.nextLine();
        System.out.println("Inserte el nombre del jugador: ");
        String jugadorAvender = teclado.nextLine();
        System.out.println("Vendiendo jugador...");

        if (liga.getEquipo(equipoVentaJug) == null){
            System.out.println("El equipo no existe. ");
        } else {
            equipo.venderJugador(jugadorAvender);
        }
    }

    static void salir(){
        System.exit(0);
    }
}

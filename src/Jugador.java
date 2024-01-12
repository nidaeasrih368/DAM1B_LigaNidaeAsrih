public class Jugador {
    private String nombre;
    private String nacionalidad;
    private int edad;
    private String posicion;
    private boolean lesionado;

    public Jugador(String nombre, String nacionalidad, int edad, String posicion) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.edad = edad;
        this.posicion = posicion;
        this.lesionado = false;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public int getEdad() {
        return edad;
    }

    public String getPosicion() {
        return posicion;
    }

    public boolean getLesionado() {
        return lesionado;
    }

    public void lesionarse(){
        lesionado = true;
    }

    public void recuperarse(){
        lesionado = false;
    }
}

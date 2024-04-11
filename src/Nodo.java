class Nodo {
    String nombre;
    String artista;
    String genero;
    int duracion;

    Nodo siguiente;

    // Constructor
    public Nodo(String nombre, String artista, String genero, int duracion) {
        this.nombre = nombre;
        this.artista = artista;
        this.genero = genero;
        this.duracion = duracion;
        this.siguiente = null;
    }
}
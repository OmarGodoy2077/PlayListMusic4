class Playlist {
    Nodo cabeza;

    // Constructor
    public Playlist() {
        this.cabeza = null;
    }

    // Método para agregar una canción al final de la playlist
    public void agregarCancion(String nombre, String artista, String genero, int duracion) {
        Nodo nuevaCancion = new Nodo(nombre, artista, genero, duracion);
        if (cabeza == null) {
            cabeza = nuevaCancion;
        } else {
            Nodo temp = cabeza;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevaCancion;
        }
    }

    // Método para imprimir la playlist completa
    public void imprimirPlaylist() {
        Nodo temp = cabeza;
        System.out.println("Playlist:");
        while (temp != null) {
            System.out.println("Nombre: " + temp.nombre + ", Artista: " + temp.artista + ", Género: " + temp.genero + ", Duración: " + temp.duracion + " segundos");
            temp = temp.siguiente;
        }
    }

    // Método para eliminar una canción por su nombre
    public void eliminarCancion(String nombre) {
        Nodo temp = cabeza;
        if (temp.nombre.equals(nombre)) {
            cabeza = temp.siguiente;
            return;
        }
        while (temp.siguiente != null && !temp.siguiente.nombre.equals(nombre)) {
            temp = temp.siguiente;
        }
        if (temp.siguiente == null) {
            System.out.println("La canción '" + nombre + "' no se encuentra en la playlist.");
        } else {
            temp.siguiente = temp.siguiente.siguiente;
        }
    }

    // Método para insertar una nueva canción en una posición específica
    // Método para insertar una nueva canción en una posición específica
    public void insertarCancion(String nombre, String artista, String genero, int duracion, int posicion) {
        Nodo nuevaCancion = new Nodo(nombre, artista, genero, duracion);
        if (posicion == 0) {
            nuevaCancion.siguiente = cabeza;
            cabeza = nuevaCancion;
        } else {
            Nodo temp = cabeza;
            for (int i = 0; i < posicion - 1 && temp != null; i++) {
                temp = temp.siguiente;
            }
            if (temp == null) {
                System.out.println("La posición especificada está fuera de la playlist.");
            } else {
                nuevaCancion.siguiente = temp.siguiente;
                temp.siguiente = nuevaCancion;
            }
        }
        // Ordenar la playlist por nombre después de insertar la nueva canción
        ordenarPorNombre();
    }


    // Método para buscar una canción por su nombre
    public void buscarCancion(String nombre) {
        Nodo temp = cabeza;
        while (temp != null) {
            if (temp.nombre.equals(nombre)) {
                System.out.println("Nombre: " + temp.nombre + ", Artista: " + temp.artista + ", Género: " + temp.genero + ", Duración: " + temp.duracion + " segundos");
                return;
            }
            temp = temp.siguiente;
        }
        System.out.println("La canción '" + nombre + "' no se encuentra en la playlist.");
    }

    // Método para ordenar la playlist por nombre de canción
    public void ordenarPorNombre() {
        Nodo actual = cabeza, siguiente;
        String tempNombre, tempArtista, tempGenero;
        int tempDuracion;

        while (actual != null) {
            siguiente = actual.siguiente;
            while (siguiente != null) {
                if (actual.nombre.compareTo(siguiente.nombre) > 0) {
                    // Intercambiar valores
                    tempNombre = actual.nombre;
                    tempArtista = actual.artista;
                    tempGenero = actual.genero;
                    tempDuracion = actual.duracion;

                    actual.nombre = siguiente.nombre;
                    actual.artista = siguiente.artista;
                    actual.genero = siguiente.genero;
                    actual.duracion = siguiente.duracion;

                    siguiente.nombre = tempNombre;
                    siguiente.artista = tempArtista;
                    siguiente.genero = tempGenero;
                    siguiente.duracion = tempDuracion;
                }
                siguiente = siguiente.siguiente;
            }
            actual = actual.siguiente;
        }
    }

    // Método para calcular la duración total de la playlist
    public void calcularDuracionTotal() {
        int duracionTotal = 0;
        Nodo temp = cabeza;
        while (temp != null) {
            duracionTotal += temp.duracion;
            temp = temp.siguiente;
        }
        int minutos = duracionTotal / 60;
        int segundos = duracionTotal % 60;
        System.out.println("Duración total de la playlist: " + minutos + " minutos y " + segundos + " segundos");
    }
}
// Path: src/Nodo.java

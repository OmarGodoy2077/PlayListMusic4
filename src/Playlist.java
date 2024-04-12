import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

class Playlist {
    Nodo cabeza;

    // Constructor
    public Playlist() {
        this.cabeza = null;
    }


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


    public void imprimirPlaylist() {
        Nodo temp = cabeza;
        System.out.println("Playlist:");
        while (temp != null) {
            System.out.println("Nombre: " + temp.nombre + ", Artista: " + temp.artista + ", Género: " + temp.genero + ", Duración: " + temp.duracion + " segundos");
            temp = temp.siguiente;
        }
    }
    public void exportarPlaylist(String nombreArchivo) {
        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            Nodo temp = cabeza;
            while (temp != null) {
                // Escribir los detalles de la canción en el archivo
                writer.write(temp.nombre + "," + temp.artista + "," + temp.genero + "," + temp.duracion + "\n");
                temp = temp.siguiente;
            }
            System.out.println("La playlist ha sido exportada exitosamente al archivo: " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al exportar la playlist al archivo: " + nombreArchivo);
            e.printStackTrace();
        }
    }
    public int obtenerLongitud() {
        int longitud = 0;
        Nodo temp = cabeza;
        while (temp != null) {
            longitud++;
            temp = temp.siguiente;
        }
        return longitud;
    }

    // Constructor y otros métodos...

        public void reproducirCancionAleatoria() {
            // Verificar si la playlist está vacía
            if (cabeza == null) {
                System.out.println("La playlist está vacía.");
                return;
            }

            // Generar un índice aleatorio dentro del rango de la longitud de la lista
            Random rand = new Random();
            int index = rand.nextInt(obtenerLongitud());

            // Recorrer la lista hasta alcanzar el índice aleatorio
            Nodo temp = cabeza;
            for (int i = 0; i < index; i++) {
                temp = temp.siguiente;
            }

            // Mostrar los datos de la canción en el nodo actual
            System.out.println("Reproduciendo canción aleatoria:");
            System.out.println("Nombre: " + temp.nombre);
            System.out.println("Artista: " + temp.artista);
            System.out.println("Género: " + temp.genero);
            System.out.println("Duración: " + temp.duracion + " segundos");
        }


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

        ordenarPorNombre();
    }



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

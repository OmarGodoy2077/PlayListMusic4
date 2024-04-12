import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Playlist playlist = new Playlist();

        // Agregar canciones a la playlist
        playlist.agregarCancion("Candy", "Rosalia", "Pop", 180);
        playlist.agregarCancion("No more Parties in LA", "Kanye West", "Rap", 240);
        playlist.agregarCancion("My eyes", "Travis Scott", "Trap", 200);
        playlist.agregarCancion("Summit", "Skrillex", "Electronica", 210);
        playlist.agregarCancion("Burn", "Ty Dolla $ing", "Hip hop", 190);
        playlist.agregarCancion("Praise God 22", "Kanye West", "Hip Hip", 220);
        playlist.agregarCancion("La combi Versace", "Rosalia", "Urbano", 230);
        playlist.agregarCancion("Get Lucky", "Daft Punk", "Electronica", 170);
        playlist.agregarCancion("Runaway", "Kanye West", "Rap", 250);
        playlist.agregarCancion("Modern Jam", "Travis Scott", "Trap", 260);

        int opcion;
        do {
            System.out.println("\nMenú:");
            System.out.println("1. Mostrar playlist");
            System.out.println("2. Eliminar canción por nombre");
            System.out.println("3. Insertar nueva canción");
            System.out.println("4. Buscar canción por nombre");
            System.out.println("5. Ordenar playlist por nombre");
            System.out.println("6. Calcular duración total de la playlist");
            System.out.println("7. Reproducir canción aleatoria");
            System.out.println("0. Salir");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    playlist.imprimirPlaylist();
                    break;
                case 2:
                    System.out.print("Ingrese el nombre de la canción a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    playlist.eliminarCancion(nombreEliminar);
                    break;
                case 3:
                    System.out.print("Ingrese el nombre de la nueva canción : ");
                    String nombreNueva = scanner.nextLine();
                    System.out.print("Ingrese el nombre del artista: ");
                    String artistaNueva = scanner.nextLine();
                    System.out.print("Ingrese el género de la canción: ");
                    String generoNueva = scanner.nextLine();
                    System.out.print("Ingrese la duración de la canción (en segundos): ");
                    int duracionNueva = scanner.nextInt();
                    System.out.print("Ingrese la posición donde desea insertar la canción: ");
                    int posicionInsertar = scanner.nextInt();
                    playlist.insertarCancion(nombreNueva, artistaNueva, generoNueva, duracionNueva, posicionInsertar);
                    break;
                case 4:
                    System.out.print("Ingrese el nombre de la canción a buscar: ");
                    String nombreBuscar = scanner.nextLine();
                    playlist.buscarCancion(nombreBuscar);
                    break;
                case 5:
                    playlist.ordenarPorNombre();
                    System.out.println("Playlist ordenada por nombre.");
                    break;
                case 6:
                    playlist.calcularDuracionTotal();
                    break;
                case 7:
                    playlist.reproducirCancionAleatoria();


                    break;

                case 0:
                    System.out.println("Saliendo  del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                    break;
            }
        } while (opcion != 0);

        scanner.close();
    }
}
package biblioteca.simple.app;

import biblioteca.simple.contratos.Prestable;
import biblioteca.simple.modelo.*;
import biblioteca.simple.servicios.Catalogo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    // crear un objeto de tipo catálogo
    private static final Catalogo catalogo = new Catalogo();
    // crear lista de usuarios
    private static final List<Usuario> usuarios = new ArrayList();

    public static void main(String[] args) {
        cargarDatos();
        menu();
    }

    private static void cargarDatos(){
        // carga de 4 libros + 4 pelis
        catalogo.alta(new Libro( 1, "El nombre del viento", "2007", Formato.FISICO, "9788401352836", "Patrick Rothfuss"));
        catalogo.alta(new Libro( 2, "Clean Code", "2008", Formato.FISICO, "9780132350884", "Robert C. Martin"));
        catalogo.alta(new Libro( 3, "1984", "1949", Formato.DIGITAL, "9780451524935", "George Orwell"));
        catalogo.alta(new Libro( 4, "El Señor de los Anillos", "1954", Formato.DIGITAL, "9780618640157", "J. R. R. Tolkien"));

        catalogo.alta(new Pelicula( 5, "Blade Runner", "1982", Formato.FISICO, "Ridley Scott", 117));
        catalogo.alta(new Pelicula( 6, "The Matrix", "1999", Formato.DIGITAL, "Lana y Lilly Wachowski", 136));
        catalogo.alta(new Pelicula( 7, "El Padrino", "1972", Formato.FISICO, "Francis Ford Coppola", 175));
        catalogo.alta(new Pelicula( 8, "Parásitos", "2019", Formato.DIGITAL, "Bong Joon-ho", 132));

        // carga de 4 usuarios
        usuarios.add(new Usuario(1, "Alba"));
        usuarios.add(new Usuario(2, "Leo"));
        usuarios.add(new Usuario(3, "Neco"));
        usuarios.add(new Usuario(4, "Luna"));
    }

    private static void menu(){
        int op = -1;

        do {
            // MENU
            // 1.listar,
            // 2.buscar por título,
            // 3.buscar por año,
            // 4.prestar (listado, pregunta) ¿producto?, ¿usuario?,
            // 5.devolver (listado pregunta) ¿prestados?
            // 6.salir
            System.out.println("\n=== BIBLIOTECA ===");
            System.out.println("1) Listar productos");
            System.out.println("2) Buscar por título");
            System.out.println("3) Buscar por año");
            System.out.println("4) Prestar");
            System.out.println("5) Devolver");
            System.out.println("0) Salir\n");

            while (!sc.hasNextInt()) sc.next();
            op = sc.nextInt();
            sc.nextLine();

            switch (op){
                case 1 -> listar();
                case 2 -> buscarPorTitulo();
                case 3 -> buscarPorAnho();
                case 4 -> prestar();
                case 5 -> devolver();
                case 0 -> System.out.println("Hasta luego.");
                default -> System.out.println("Opción no válida.");
            }

        } while(op != 0);
    }

    private static void listar() {
        List<Producto> lista = catalogo.listar();
        
        if (lista.isEmpty()) {
            System.out.println("Catálogo vacío");
            return;
        }

        System.out.println("== Lista de productos ==");
        for (Producto p : lista) System.out.println("- " + p);
    }

    private static void buscarPorTitulo() {
        System.out.println("Título (escribe parte del título): ");
        String t = sc.nextLine();

        catalogo.buscar(t).forEach(p -> System.out.println("- " + p));
    }

    private static void buscarPorAnho() {
        System.out.println("Año: ");
        int a = sc.nextInt();
        sc.nextLine();

        catalogo.buscar(a).forEach(p -> System.out.println("- " + p));
    }

    private static void prestar() {
        List<Producto> disponibles = catalogo.listar().stream()
            .filter(p -> p instanceof Prestable pN && !pN.estaPrestado())
            .collect(Collectors.toList());
    }
    
    private static void devolver() {
        
    }
}

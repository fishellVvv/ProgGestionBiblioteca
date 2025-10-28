package biblioteca.simple.app;

import biblioteca.simple.contratos.Prestable;
import biblioteca.simple.modelo.Producto;
import biblioteca.simple.modelo.Usuario;
import biblioteca.simple.servicios.Catalogo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    private Catalogo catalogo;
    private List<Usuario> usuarios;

    // MENU
    // 1.listar,
    // 2.buscar por título,
    // 3.buscar por año,
    // 4.prestar (listado, pregunta) ¿producto?, ¿usuario?,
    // 5.devolver (listado pregunta) ¿prestados?
    // 6.salir

    public Menu(Catalogo catalogo, List<Usuario> usuarios) {
        this.catalogo = catalogo;
        this.usuarios = usuarios;
    }

    public void lanzarMenu() {
        int opcion = -1;
        while (opcion != 6) {
            mostrarMenu();
            opcion = leerEntero(sc, "Elige una opción: ");
            switch (opcion) {
                case 1 -> listar();
                case 2 -> buscarPorTitulo();
                case 3 -> buscarPorAnho();
                case 4 -> prestar();
                case 5 -> devolver();
                case 6 -> System.out.println("Hasta luego.");
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    private void mostrarMenu() {
        System.out.println("\n=== BIBLIOTECA ===");
        System.out.println("1) Listar productos");
        System.out.println("2) Buscar por título");
        System.out.println("3) Buscar por año");
        System.out.println("4) Prestar");
        System.out.println("5) Devolver");
        System.out.println("6) Salir\n");
    }

    private void listar() {
        for (Producto p : catalogo.listar()) {
            System.out.println(p);
        }
    }

    private void buscarPorTitulo() {
        String busqueda = leerTexto(sc, "Indica el título a buscar: ");
        for (Producto p : catalogo.buscar(busqueda)) {
            System.out.println(p);
        }
        System.out.println();
    }

    private void buscarPorAnho() {
        int busqueda = leerEntero(sc, "Indica el año a buscar: ");
        for (Producto p : catalogo.buscar(busqueda)) {
            System.out.println(p);
        }
        System.out.println();
    }

    private void prestar() {
        int i = 0;
        int iProducto = 0;
        for (Producto p : catalogo.listar()) {
            if (!p.isPrestado()) {
                i++;
                System.out.printf("%d. %s%n", i, p);
            }
        }
        iProducto = leerEntero(sc, "\nElige un producto: ") - 1;

        i = 0;
        int iUsuario = 0;
        for (Usuario u : usuarios) {
            i++;
            System.out.printf("%d. %s%n", i, u.getNombre());
        }
        iUsuario= leerEntero(sc, "\nElige un usuario: ") - 1;

        catalogo.listar().get(iProducto).prestar(usuarios.get(iUsuario));
        System.out.printf("El producto '%s' ha sido prestado a %s.%n", catalogo.listar().get(iProducto).getTitulo(), usuarios.get(iUsuario).getNombre());
    }
    
    private void devolver() {
        int i = 0;
        int iProducto = 0;
        for (Producto p : catalogo.listar()) {
            if (p.isPrestado()) {
                i++;
                System.out.printf("%d. %s%n", i, p);
            }
        }
        iProducto = leerEntero(sc, "\nElige un producto: ") - 1;

        catalogo.listar().get(iProducto).devolver();
        System.out.printf("El producto '%s' ha sido devuelto.%n", catalogo.listar().get(iProducto).getTitulo());
    }

    private static int leerEntero(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            try { return Integer.parseInt(s); }
            catch (NumberFormatException e) { System.out.println("Número inválido."); }
        }
    }

    private static String leerTexto(Scanner sc, String prompt) {
        System.out.print(prompt);
        return sc.nextLine().trim();
    }
}

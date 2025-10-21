package biblioteca.simple.app;

import biblioteca.simple.contratos.Prestable;
import biblioteca.simple.modelo.Producto;
import biblioteca.simple.modelo.Usuario;
import biblioteca.simple.servicios.Catalogo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
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
        Scanner sc = new Scanner(System.in);
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

    private void buscarPorTitulo() {}
    private void buscarPorAnho() {}
    private void prestar() {}
    private void devolver() {}

    private static int leerEntero(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            try { return Integer.parseInt(s); }
            catch (NumberFormatException e) { System.out.println("Número inválido."); }
        }
    }
}

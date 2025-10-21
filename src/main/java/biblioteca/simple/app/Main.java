package biblioteca.simple.app;

import biblioteca.simple.modelo.*;
import biblioteca.simple.servicios.Catalogo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // crear un objeto de tipo catálogo
        Catalogo catalogo = new Catalogo();
        // crear lista de usuarios
        List<Usuario> usuarios = new ArrayList<Usuario>();

        // carga de 4 libros + 4 pelis
        catalogo.alta(new Libro( "El nombre del viento", "2007", Formato.FISICO, "9788401352836", "Patrick Rothfuss"));
        catalogo.alta(new Libro( "Clean Code", "2008", Formato.FISICO, "9780132350884", "Robert C. Martin"));
        catalogo.alta(new Libro( "1984", "1949", Formato.DIGITAL, "9780451524935", "George Orwell"));
        catalogo.alta(new Libro( "El Señor de los Anillos", "1954", Formato.DIGITAL, "9780618640157", "J. R. R. Tolkien"));

        catalogo.alta(new Pelicula( "Blade Runner", "1982", Formato.FISICO, "Ridley Scott", 117));
        catalogo.alta(new Pelicula( "The Matrix", "1999", Formato.DIGITAL, "Lana y Lilly Wachowski", 136));
        catalogo.alta(new Pelicula( "El Padrino", "1972", Formato.FISICO, "Francis Ford Coppola", 175));
        catalogo.alta(new Pelicula( "Parásitos", "2019", Formato.DIGITAL, "Bong Joon-ho", 132));

        // carga de 4 usuarios
        usuarios.add(new Usuario(1, "Alba"));
        usuarios.add(new Usuario(2, "Leo"));
        usuarios.add(new Usuario(3, "Neco"));
        usuarios.add(new Usuario(4, "Luna"));

        // MENU
        Menu menu = new Menu(catalogo, usuarios);
        menu.lanzarMenu();
    }
}

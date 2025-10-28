package biblioteca.simple.modelo;

import biblioteca.simple.contratos.Prestable;

public class Libro extends Producto implements Prestable {
    private String ISBN;
    private String autor;
    private boolean prestado;
    private Usuario prestadoA;

    public Libro(int id, String titulo, String anho, Formato formato, String ISBN, String autor) {
        super(id, titulo, anho, formato);
        this.ISBN = ISBN;
        this.autor = autor;
    }

    public Libro(String titulo, String anho, Formato formato, String ISBN, String autor) {
        super(titulo, anho, formato);
        this.ISBN = ISBN;
        this.autor = autor;
    }

    public String getISBN() { return ISBN; }
    public String getAutor() { return autor; }
    public boolean isPrestado() { return prestado; }
    public Usuario getPrestadoA() { return prestadoA; }

    @Override public boolean estaPrestado() { return this.prestado; }
    @Override public void prestar(Usuario u) {
        if (prestado) throw new IllegalStateException("Ya prestado");
        this.prestado = true;
        this.prestadoA = u;
    }
    @Override public void devolver() {
        this.prestado = false;
        this.prestadoA = null;
    }

    @Override
    public String toString() {
        return "Libro #" + id + " " + titulo + " (" + anho + ") - " + formato + " ISBN='" + ISBN + '\'' + " [" + autor + "]";
    }
}

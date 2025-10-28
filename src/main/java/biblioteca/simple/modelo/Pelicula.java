package biblioteca.simple.modelo;

import biblioteca.simple.contratos.Prestable;

public class Pelicula extends Producto implements Prestable {
    private String director;
    private int minutosDuracion;
    private boolean prestado;
    private Usuario prestadoA;

    public Pelicula(int id, String titulo, String anho, Formato formato, String director, int minutosDuracion) {
        super(id, titulo, anho, formato);
        this.director = director;
        this.minutosDuracion = minutosDuracion;
    }

    public Pelicula(String titulo, String anho, Formato formato, String director, int minutosDuracion) {
        super(titulo, anho, formato);
        this.director = director;
        this.minutosDuracion = minutosDuracion;
    }

    public String getDirector() { return director; }
    public int getMinutosDuracion() { return minutosDuracion; }
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
        return "Pelicula #" + id + " " + titulo + " (" + anho + ") - " + formato + " [" + director + "] - " + minutosDuracion + " min.";
    }
}

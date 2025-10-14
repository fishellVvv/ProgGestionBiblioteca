package biblioteca.simple.modelo;

public abstract class Producto {
    protected int id;
    protected String titulo;
    protected String anho;
    protected Formato formato;

    protected Producto(int id, String titulo, String anho, Formato formato) {
        this.id = id;
        this.titulo = titulo;
        this.anho = anho;
        this.formato = formato;
    }

    protected Producto(String titulo, String anho, Formato formato) {
        this.titulo = titulo;
        this.anho = anho;
        this.formato = formato;
    }

    protected int getId() { return id; }
    protected String getTitulo() { return titulo; }
    protected String getAnho() { return anho; }
    protected Formato getFormato() { return formato; }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", anho='" + anho + '\'' +
                ", formato=" + formato +
                '}';
    }
}

package biblioteca.simple.contratos;

import biblioteca.simple.modelo.Usuario;

public interface Prestable {
    boolean estaPrestado();

    void prestar(Usuario u);
    void devolver();
}

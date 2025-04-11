package BibliotecaVirtual;

import java.util.LinkedList;
import java.util.Queue;

public class Livro {
    public String titulo;
    public String autor;
    public int anoPublicacao;
    public Queue<Usuario> filaDeEspera;

    public Livro(String titulo, String autor, int anoPublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.filaDeEspera = null; //Inicialmente nula para ser iniciada caso seja necessário.
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public void adicionarUsuarioNaFila(Usuario usuario) {
        if (filaDeEspera == null){
            filaDeEspera = new LinkedList<>();
        }
        filaDeEspera.add(usuario);
        System.out.println("\n" + usuario.getNome() + " foi adicionado(a) à fila de espera para o livro: " + titulo);
    }

    public void removerUsuarioDaFila() {
        if (filaDeEspera != null && !filaDeEspera.isEmpty()) {
            Usuario usuario = filaDeEspera.poll();
            System.out.println("\n" + usuario.getNome() + " foi removido(a) da fila de espera do livro: " + titulo);

            if (filaDeEspera.isEmpty()) {
                filaDeEspera = null;
            }
        } else {
            System.out.println("\nA fila de espera para " + titulo + " está vazia ou não foi criada.");
        }
    }

    public void exibirFilaDeEspera() {
        if (filaDeEspera != null && !filaDeEspera.isEmpty()) {
            System.out.print("\nFila de espera para o livro " + titulo + ": ");
            for (Usuario usuario : filaDeEspera) {
                System.out.print("\n- " + usuario.getNome());
            }
            System.out.println();
        } else {
            System.out.println("\nNão há fila de espera para o livro " + titulo + ".");
        }
    }

    public String toString() {
        return "Título: " + titulo + ", Autor: " + autor + ", Ano: " + anoPublicacao;
    }
}



package BibliotecaVirtual;

import java.util.LinkedList;

public class ColecaoDeLivros {
    public LinkedList<Livro> colecao;

    public ColecaoDeLivros () {
        this.colecao = new LinkedList<>();
    }

    public void adicionarLivro(Livro... livros) {
        for (Livro livro : livros) {
            colecao.add(livro);
            System.out.println("\nO livro " + livro.getTitulo() + " foi adicionado na biblioteca");
        }
    }

    public  void exibirLivros() {
        int contagem = 1;
        System.out.print("\nExibindo livros da biblioteca:");
        for (Livro livro : colecao) {
            System.out.println("\nLivro n° " + contagem);
            System.out.println(livro);
            contagem++;
        }
    }

    public boolean removerLivro(String titulo) {
        return colecao.removeIf(livro -> livro.getTitulo().equalsIgnoreCase(titulo));
    }
}

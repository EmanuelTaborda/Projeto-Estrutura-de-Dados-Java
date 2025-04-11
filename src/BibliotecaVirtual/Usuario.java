package BibliotecaVirtual;

import java.util.Stack;

public class Usuario {
    public String nome;
    public Stack<Livro> historicoDeVisualizacao;

    public Usuario(String nome) {
        this.nome = nome;
        this.historicoDeVisualizacao = new Stack<>();
    }

    public String getNome() {
        return nome;
    }

    public void visualizarLivro(Livro livro){
        historicoDeVisualizacao.push(livro);
        System.out.println("\n" + nome + " visualizou o livro " + livro.getTitulo());
    }

    public void exibirHistorico() {
        System.out.println("\nHistórico de visualização de " + nome + ":");

        for (int i = historicoDeVisualizacao.size() - 1; i >=0; i--) {
            Livro livro = historicoDeVisualizacao.elementAt(i);
            System.out.println("- " + livro.getTitulo());
        }
    }
}

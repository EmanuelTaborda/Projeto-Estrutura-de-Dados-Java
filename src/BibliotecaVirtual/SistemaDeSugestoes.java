package BibliotecaVirtual;

import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class SistemaDeSugestoes {
    private Map<Livro, Set<Livro>> grafo;

    public SistemaDeSugestoes(Map<Livro, Set<Livro>> grafo) {
        this.grafo = grafo;
    }

    public void recomendarLivros(Usuario usuario) {
        Set<Livro> recomendados = new HashSet<>();

        for (Livro lido : usuario.historicoDeVisualizacao) {
            if (grafo.containsKey(lido)) {
                recomendados.addAll(grafo.get(lido));
            }
        }

        // Removemos os livros que o usuário já leu
        recomendados.removeAll(usuario.historicoDeVisualizacao);

        // Exibindo livros recomendados
        System.out.println("\nRecomendações para " + usuario.getNome() + ":");

        if (recomendados.isEmpty()) {
            System.out.println("Nenhum livro para sugerir no momento.");
        } else {
            for (Livro livro : recomendados) {
                System.out.println("- " + livro.getTitulo());
            }
        }
    }
}

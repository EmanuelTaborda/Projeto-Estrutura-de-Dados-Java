package BibliotecaVirtual;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        ColecaoDeLivros biblioteca = new ColecaoDeLivros();


        //Criando usuários
        Usuario joao = new Usuario("João");
        Usuario maria = new Usuario("Maria");
        Usuario pedro = new Usuario("Pedro");


        //Criando livros
        Livro harryPotter1 = new Livro("Harry Potter e a Pedra Filosofal", "J.K Rowling", 1997);
        Livro harryPotter2 = new Livro("Harry Potter e a Câmara Secreta", "J.K Rowling", 1999);
        Livro cronicasMundoEmerso1 = new Livro("Crônicas do Mundo Emerso - A Garota da Terra do Vento", "Licia Troisi", 2004);
        Livro eragon = new Livro("Eragon", "Christopher Paolini", 2002);
        Livro eldest = new Livro("Eldest", "Christopher Paolini", 2005);
        Livro nomeDoVento = new Livro("O Nome do Vento", "Patrick Rothfuss", 2007);
        Livro aventurasDoCacaFeitico1 = new Livro("As Aventuras do Caça-Feitiço - O Aprendiz", "Joseph Delaney", 2004);
        Livro oPoderDoAgorda = new Livro("O Poder do Agora", "Eckhart Tolle", 1997);
        Livro regrasParaAVida = new Livro("12 Regras para a Vida", "Jordan Peterson", 2018);
        Livro habitosAtomicos = new Livro("Hábitos Atômicos", "James Clear", 2018);

        //Adicionando na biblioteca
        biblioteca.adicionarLivro(harryPotter1, harryPotter2, cronicasMundoEmerso1, eragon, eldest,
                nomeDoVento, aventurasDoCacaFeitico1, oPoderDoAgorda, regrasParaAVida, habitosAtomicos);


        //Criando grafo de recomendações e inserindo os respectivos livros
        HashMap<Livro, Set<Livro>> grafoDeRecomendacoes = new HashMap<>();

        grafoDeRecomendacoes.put(harryPotter1, new HashSet<>(Arrays.asList(harryPotter2, aventurasDoCacaFeitico1)));
        grafoDeRecomendacoes.put(harryPotter2, new HashSet<>(Arrays.asList(harryPotter1, aventurasDoCacaFeitico1)));
        grafoDeRecomendacoes.put(cronicasMundoEmerso1, new HashSet<>(Arrays.asList(nomeDoVento, eragon)));
        grafoDeRecomendacoes.put(eragon, new HashSet<>(Arrays.asList(eldest, cronicasMundoEmerso1)));
        grafoDeRecomendacoes.put(eldest, new HashSet<>(Arrays.asList(eragon, cronicasMundoEmerso1)));
        grafoDeRecomendacoes.put(nomeDoVento, new HashSet<>(Arrays.asList(aventurasDoCacaFeitico1, cronicasMundoEmerso1)));
        grafoDeRecomendacoes.put(aventurasDoCacaFeitico1, new HashSet<>(Arrays.asList(harryPotter1, harryPotter2)));
        grafoDeRecomendacoes.put(oPoderDoAgorda, new HashSet<>(Arrays.asList(regrasParaAVida, habitosAtomicos)));
        grafoDeRecomendacoes.put(regrasParaAVida, new HashSet<>(Arrays.asList(oPoderDoAgorda, habitosAtomicos)));
        grafoDeRecomendacoes.put(habitosAtomicos, new HashSet<>(Arrays.asList(oPoderDoAgorda, regrasParaAVida)));

        //Criando visuzalizações para a partir disto obter sugestões para os usuários
        joao.visualizarLivro(harryPotter1);
        maria.visualizarLivro(habitosAtomicos);
        pedro.visualizarLivro(eragon);
        pedro.visualizarLivro(nomeDoVento);

        //Gerando o sistema de sugestões
        SistemaDeSugestoes sistema = new SistemaDeSugestoes(grafoDeRecomendacoes);

        //Exibindo sugestões para usuários
        sistema.recomendarLivros(joao);
        sistema.recomendarLivros(maria);
        sistema.recomendarLivros(pedro);


    }
}
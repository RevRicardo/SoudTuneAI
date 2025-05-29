package br.com.alura.soudtuneai.principal;

import br.com.alura.soudtuneai.model.Artista;
import br.com.alura.soudtuneai.model.Musica;
import br.com.alura.soudtuneai.model.TipoArtistas;
import br.com.alura.soudtuneai.repository.ArtistasRepository;
import br.com.alura.soudtuneai.service.ConsultaChetGPT;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    private final ArtistasRepository repositorio;

    private Scanner leitura = new Scanner(System.in);

    public Principal(ArtistasRepository repositorio) {
        this.repositorio = repositorio;
    }

    public void exibeMenu() {

        var opcao = -1;
        while (opcao != 0) {
            var menu = """
                    ***************************************
                    *** Biblioteca - Cantores & Músicas ***
                    ***************************************
                    
                    1 - Cadastra artistas
                    2 - Cadastra músicas
                    3 - Lista músicas
                    4 - Busca música por artista
                    5 - Pesquisa dados sobre um artista
                    
                    0 - Encerra o sistema                                 
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarArtista();
                    break;
                case 2:
                    cadastrarMusica();
                    break;
                case 3:
                    listarMusica();
                    break;
                case 4:
                    buscarMusicaPorArtista();
                    break;
                case 5:
                    pesquisarDadosDoArtista();
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }

        }
    }

    private void cadastrarArtista() {
        var cadastrarNovo = "S";

        while (cadastrarNovo.equalsIgnoreCase("S")) {
            System.out.println("Nome do artista: ");
            var nome = leitura.nextLine();
            System.out.println("Tipo: (solo, dupla ou banda) ");
            var tipo = leitura.nextLine();
            TipoArtistas tipoArtistas = TipoArtistas.valueOf(tipo.toUpperCase());
            Artista artista = new Artista(nome, tipoArtistas);
            repositorio.save(artista);
            System.out.println("Cadastrar outro artista? (S/N");
            cadastrarNovo = leitura.nextLine();
        }

    }

    private void cadastrarMusica() {
        System.out.println("Cadastrar música de qual artista? ");
        var nome = leitura.nextLine();
        Optional<Artista> artista = repositorio.findByNomeContainingIgnoreCase(nome);
        if (artista.isPresent()) {
            System.out.println("Qual o título da música");
            var nomeMusica = leitura.nextLine();
            Musica musica = new Musica(nomeMusica);
            musica.setArtista(artista.get());
            artista.get().getMusicas().add(musica);
            repositorio.save(artista.get());
        } else {
            System.out.println("Artista não encontrado");
        }
    }

    private void listarMusica() {
        List<Artista> artistas = repositorio.findAll();
        artistas.forEach(a -> a.getMusicas().forEach(System.out::println));
    }

    private void buscarMusicaPorArtista() {
        System.out.println("Buscar musicas de que artistas");
        var nome = leitura.nextLine();
        List<Musica> musicas = repositorio.buscaMusicaPorArtista(nome);
        musicas.forEach(System.out::println);
    }

    private void pesquisarDadosDoArtista() {
        System.out.println("Pesquisar sobre esse artista: ");
        var nomeArtista = leitura.nextLine();
        var resposta = ConsultaChetGPT.obterInformacao(nomeArtista);
        System.out.println(resposta.trim());
    }


}

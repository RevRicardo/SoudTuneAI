package br.com.alura.soudtuneai.principal;

import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);

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
    }

    private void cadastrarMusica() {
    }

    private void listarMusica() {
    }

    private void buscarMusicaPorArtista() {
    }

    private void pesquisarDadosDoArtista() {
    }


}

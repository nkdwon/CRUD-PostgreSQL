package crud;

import java.util.List;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        DAO dao = new DAO();
        dao.conectar();

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Menu de Opções:");
            System.out.println("1. Listar");
            System.out.println("2. Inserir");
            System.out.println("3. Excluir");
            System.out.println("4. Atualizar");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    List<Jogos> jogos = dao.listar();
                    for (Jogos jogo : jogos) {
                        System.out.println(jogo);
                    }
                    break;
                case 2:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Plataforma: ");
                    String plataforma = scanner.nextLine();
                    System.out.print("Gênero: ");
                    String genero = scanner.nextLine();

                    Jogos novoJogo = new Jogos(-1, nome, plataforma, genero);
                    dao.inserir(novoJogo);
                    break;
                case 3:
                    System.out.print("Digite o ID do jogo para excluir: ");
                    int idExcluir = scanner.nextInt();
                    dao.excluir(idExcluir);
                    break;
                case 4:
                    System.out.print("Digite o ID do jogo para atualizar: ");
                    int idAtualizar = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Novo Nome: ");
                    String novoNome = scanner.nextLine();
                    System.out.print("Nova Plataforma: ");
                    String novaPlataforma = scanner.nextLine();
                    System.out.print("Novo Gênero: ");
                    String novoGenero = scanner.nextLine();

                    Jogos jogoAtualizado = new Jogos(idAtualizar, novoNome, novaPlataforma, novoGenero);
                    dao.atualizar(jogoAtualizado);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);

        scanner.close();
    }
}

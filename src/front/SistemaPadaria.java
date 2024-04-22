package front;

import java.util.List;
import java.util.Scanner;
import catalogo.Produto;
import users.Cliente;
import users.Funcionario;
import users.Adm;

public class SistemaPadaria {
	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    List<Produto> listaProdutos = Produto.GerenciadorProdutos.getListaProdutos();

	    int opcao;
	    do {
	        System.out.println("\n  ╔═══════════════════════════════════╗");
	        System.out.println("  ║      Selecione o tipo de usuário: ║");
	        System.out.println("  ╠═══════════════════════════════════╣");
	        System.out.println("  ║ 1 - Administrador                 ║");
	        System.out.println("  ║ 2 - Funcionário                   ║");
	        System.out.println("  ║ 3 - Cliente                       ║");
	        System.out.println("  ║ 0 - Sair                          ║");
	        System.out.println("  ╚═══════════════════════════════════╝");
	        System.out.print("Opção: ");
	        opcao = scanner.nextInt();

	        switch (opcao) {
	            case 1:
	                menuAdministrador(scanner, listaProdutos);
	                break;
	            case 2:
	                menuFuncionario(scanner, listaProdutos);
	                break;
	            case 3:
	                menuCliente(scanner, listaProdutos);
	                break;
	            case 0:
	                System.out.println("Saindo...");
	                break;
	            default:
	                System.out.println("Opção inválida. Tente novamente.");
	                break;
	        }
	    } while (opcao != 0);

	    scanner.close();
	}

    public static void menuAdministrador(Scanner scanner, List<Produto> listaProdutos) {
        Adm adm = new Adm("Admin", "admin123");

        int opcao;
        do {
            System.out.println("\n  ╔═════════════════════════╗");
            System.out.println("  ║  Menu do Administrador: ║");
            System.out.println("  ╠═════════════════════════╣");
            System.out.println("  ║ 1 - Adicionar Produto   ║");
            System.out.println("  ║ 2 - Remover Produto     ║");
            System.out.println("  ║ 3 - Visualizar Produtos ║");
            System.out.println("  ║ 0 - Voltar              ║");
            System.out.println("  ╚═════════════════════════╝");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    adicionarProduto(scanner, adm, listaProdutos);
                    break;
                case 2:
                    exibirProdutos(listaProdutos);
                    removerProduto(scanner, adm, listaProdutos);
                    break;
                case 3:
                    System.out.println("\n╔═══════════════════════════════════════════════════════════════╗");
                    System.out.println("║                       Lista de Produtos:  ");
                    System.out.println("╠═══════════════════════════════════════════════════════════════╣");
                    exibirProdutos(listaProdutos);
                    System.out.println("╚═══════════════════════════════════════════════════════════════╝");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);
    }
    public static void adicionarProduto(Scanner scanner, Adm adm, List<Produto> listaProdutos) {
        System.out.print("\nNome do Produto: ");
        String nome = scanner.next();
        System.out.print("Preço do Produto: ");
        double preco = scanner.nextDouble();
        System.out.print("Quantidade do Produto: ");
        int value = scanner.nextInt();
        Produto novoProduto = new Produto(nome, preco, value);
        adm.adicionarProduto(novoProduto, listaProdutos);
    }

    public static void removerProduto(Scanner scanner, Adm adm, List<Produto> listaProdutos) {
        System.out.print("\nNome do Produto a ser removido: ");
        String nomeRemover = scanner.next();
        Produto produtoRemover = null;
        for (Produto produto : listaProdutos) {
            if (produto.getNome().equals(nomeRemover)) {
                produtoRemover = produto;
                break;
            }
        }
        if (produtoRemover != null) {
            adm.removerProduto(produtoRemover, listaProdutos);
        } else {
            System.out.println("Produto não encontrado na lista.");
        }
    }

    public static void menuFuncionario(Scanner scanner, List<Produto> listaProdutos) {
        Funcionario funcionario = new Funcionario("Func", "func123");

        int opcao;
        do {
            System.out.println("\n╔═══════════════════════╗");
            System.out.println("║   Menu do Funcionário:║");
            System.out.println("╠═══════════════════════╣");
            System.out.println("║ 1 - Criar Produto     ║");
            System.out.println("║ 2 - Editar Produto    ║");
            System.out.println("║ 0 - Voltar            ║");
            System.out.println("╚═══════════════════════╝");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    criarProduto(scanner, funcionario, listaProdutos);
                    break;
                case 2:
                    editarProduto(scanner, funcionario, listaProdutos);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);
    }

    public static void criarProduto(Scanner scanner, Funcionario funcionario, List<Produto> listaProdutos) {
        System.out.print("\nNome do Produto: ");
        String nome = scanner.next();
        System.out.print("Preço do Produto: ");
        double preco = scanner.nextDouble();
        System.out.print("Valor do Produto: ");
        int value = scanner.nextInt();
        Produto novoProduto = new Produto(nome, preco, value);
        funcionario.criarProduto(nome, preco, value);
        listaProdutos.add(novoProduto);
    }

    public static void editarProduto(Scanner scanner, Funcionario funcionario, List<Produto> listaProdutos) {
        System.out.print("\nNome do Produto a ser editado: ");
        String nomeEditar = scanner.next();
        Produto produtoEditar = null;
        for (Produto produto : listaProdutos) {
            if (produto.getNome().equals(nomeEditar)) {
                produtoEditar = produto;
                break;
            }
        }
        if (produtoEditar != null) {
            System.out.print("Novo Nome do Produto: ");
            String novoNome = scanner.next();
            System.out.print("Novo Preço do Produto: ");
            double novoPreco = scanner.nextDouble();
            System.out.print("Novo Valor do Produto: ");
            int novoValue = scanner.nextInt();
            Produto produtoNovo = new Produto(novoNome, novoPreco, novoValue);
            funcionario.editarProduto(produtoEditar, produtoNovo);
        } else {
            System.out.println("Produto não encontrado na lista.");
        }
    }

    public static void menuCliente(Scanner scanner, List<Produto> listaProdutos) {
        Cliente cliente = new Cliente("Cliente", "cli123");

        int opcao;
        do {
            System.out.println("\n  ╔═══════════════════════════╗");
            System.out.println("  ║       Menu do Cliente:    ║");
            System.out.println("  ╠═══════════════════════════╣");
            System.out.println("  ║ 1 - Adicionar ao Carrinho ║");
            System.out.println("  ║ 2 - Remover do Carrinho   ║");
            System.out.println("  ║ 3 - Visualizar Carrinho   ║");
            System.out.println("  ║ 4 - Realizar Pagamento    ║");
            System.out.println("  ║ 5 - Finalizar Compra      ║");
            System.out.println("  ║ 0 - Voltar                ║");
            System.out.println("  ╚═══════════════════════════╝");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    adicionarAoCarrinho(scanner, cliente, listaProdutos);
                    break;
                case 2:
                    removerDoCarrinho(scanner, cliente, listaProdutos);
                    break;
                case 3:
                    cliente.exibirCarrinho();
                    break;
                case 4:
                    cliente.realizarPagamento();
                    break;
                case 5:
                    cliente.finalizarCompra();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);
    }

    public static void adicionarAoCarrinho(Scanner scanner, Cliente cliente, List<Produto> listaProdutos) {
        System.out.println("\nLista de Produtos Disponíveis:");
        exibirProdutos(listaProdutos);
        System.out.print("Nome do Produto a ser adicionado ao carrinho: ");
        String nomeAdicionar = scanner.next();
        Produto produtoAdicionar = null;
        for (Produto produto : listaProdutos) {
            if (produto.getNome().equals(nomeAdicionar)) {
                produtoAdicionar = produto;
                break;
            }
        }
        if (produtoAdicionar != null) {
            cliente.adicionarAoCarrinho(produtoAdicionar);
        } else {
            System.out.println("Produto não encontrado na lista.");
        }
    }

    public static void removerDoCarrinho(Scanner scanner, Cliente cliente, List<Produto> listaProdutos) {
        System.out.println("\nCarrinho:");
        cliente.exibirCarrinho();
        System.out.print("Nome do Produto a ser removido do carrinho: ");
        String nomeRemover = scanner.next();
        Produto produtoRemover = null;
        for (Produto produto : cliente.getCarrinho()) {
            if (produto.getNome().equals(nomeRemover)) {
                produtoRemover = produto;
                break;
            }
        }
        if (produtoRemover != null) {
            cliente.removerDoCarrinho(produtoRemover);
        } else {
            System.out.println("Produto não encontrado no carrinho.");
        }
    }

    public static void exibirProdutos(List<Produto> listaProdutos) {
        for (Produto produto : listaProdutos) {
            System.out.println(produto);
        }
    }
}

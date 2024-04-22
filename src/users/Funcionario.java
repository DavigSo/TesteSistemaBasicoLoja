package users;

import catalogo.Produto;

public class Funcionario extends Pessoa {
    public Funcionario(String nome, String cpf) {
        super(nome, cpf);
    }

    // Métodos específicos para funcionário (criação e edição de produtos)
    public void criarProduto(String nome, double preco, int value) {
        Produto novoProduto = new Produto(nome, preco, value);
        Produto.GerenciadorProdutos.adicionarProduto(novoProduto);
        System.out.println("Novo produto criado: " + novoProduto);
    }

    public void editarProduto(Produto produtoAntigo, Produto produtoNovo) {
        Produto.GerenciadorProdutos.removerProduto(produtoAntigo);
        Produto.GerenciadorProdutos.adicionarProduto(produtoNovo);
        System.out.println("Produto editado com sucesso.");
    }
}

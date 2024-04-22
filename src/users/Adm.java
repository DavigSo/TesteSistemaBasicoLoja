package users;

import java.util.List;

import catalogo.Produto;

public class Adm extends Funcionario {

    public Adm(String nome, String cpf) {
        super(nome, cpf);
    }

    // Métodos específicos para administrador (CRUD de Produto)
    public void adicionarProduto(Produto produto, List<Produto> listaProdutos) {
        listaProdutos.add(produto);
        System.out.println("Produto adicionado com sucesso: \n" + produto);
    }

    public void removerProduto(Produto produto, List<Produto> listaProdutos) {
        if (listaProdutos.remove(produto)) {
            System.out.println("Produto removido com sucesso: " + produto);
        } else {
            System.out.println("O produto não está na lista.");
        }
    }

    public void visualizarProdutos(List<Produto> listaProdutos) {
        if (listaProdutos.isEmpty()) {
            System.out.println("Lista de produtos vazia.");
        } else {
            System.out.println("Lista de Produtos:");
            for (Produto produto : listaProdutos) {
                System.out.println(produto);
            }
        }
    }

    public void editarProduto(Produto produtoAntigo, Produto produtoNovo, List<Produto> listaProdutos) {
        if (listaProdutos.contains(produtoAntigo)) {
            int index = listaProdutos.indexOf(produtoAntigo);
            listaProdutos.set(index, produtoNovo);
            System.out.println("Produto editado com sucesso.");
        } else {
            System.out.println("O produto a ser editado não existe na lista.");
        }
    }
}


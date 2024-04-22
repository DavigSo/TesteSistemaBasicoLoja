package catalogo;

import java.util.ArrayList;
import java.util.List;

public class Produto {

    private String nome;
    private double preco;
    private Integer quantidade;

    public Produto(String nome, double preco, Integer quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        String format = "| %-20s | %-10s | %-15s |\n";
        StringBuilder sb = new StringBuilder();
        sb.append("+----------------------+------------+-------------------+\n");
        sb.append(String.format(format, "Nome", "Preço", "Quantidade"));
        sb.append("+----------------------+------------+-------------------+\n");
        sb.append(String.format(format, nome, "R$" + preco, quantidade));
        sb.append("+----------------------+------------+-------------------+\n");
        return sb.toString();
    }


    // Classe para gerenciar a lista de produtos
    public static class GerenciadorProdutos {
        private static List<Produto> listaProdutos = new ArrayList<>();

        public static void adicionarProduto(Produto produto) {
            listaProdutos.add(produto);
        }

        public static void removerProduto(Produto produto) {
            listaProdutos.remove(produto);
        }

        public static List<Produto> getListaProdutos() {
            return listaProdutos;
        }
    }
}

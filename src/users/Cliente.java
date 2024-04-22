package users;

import java.util.ArrayList;

import catalogo.Produto;

public class Cliente extends Pessoa {

    private ArrayList<Produto> carrinho = new ArrayList<>();
    private double total = 0;

    public Cliente(String name, String cpf) {
        super(name, cpf);
    }

    public void adicionarAoCarrinho(Produto produto) {
        carrinho.add(produto);
        setTotal(getTotal() + produto.getPreco());
        System.out.println(produto.getNome() + " adicionado ao carrinho.");
    }

    public void removerDoCarrinho(Produto produto) {
        if (carrinho.remove(produto)) {
            setTotal(getTotal() - produto.getPreco());
            System.out.println(produto.getNome() + " removido do carrinho.");
        } else {
            System.out.println("O produto não está no carrinho.");
        }
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void exibirCarrinho() {
        if (carrinho.isEmpty()) {
            System.out.println("Carrinho vazio.");
        } else {
            System.out.println("Carrinho de Compras:");
            String format = "| %-20s | %-10s |\n";
            System.out.format("+----------------------+------------+\n");
            System.out.format(format, "Nome", "Preço");
            System.out.format("+----------------------+------------+\n");
            for (Produto produto : carrinho) {
                System.out.format(format, produto.getNome(), "R$" + produto.getPreco());
            }
            System.out.format("+----------------------+------------+\n");
            System.out.println("Total: R$" + getTotal());
        }
    }


    public void realizarPagamento() {
        if (carrinho.isEmpty()) {
            System.out.println("Carrinho vazio. Não é possível realizar o pagamento.");
        } else {
            // Aqui você pode adicionar a lógica para o cliente realizar o pagamento
        	carrinho.clear();
            System.out.println("Pagamento realizado no valor de R$" + getTotal());
        }
    }

    public void finalizarCompra() {
        if (carrinho.isEmpty()) {
            System.out.println("Carrinho vazio. Não é possível finalizar a compra.");
        } else {
            // Aqui você pode adicionar a lógica para finalizar a compra, por exemplo, atualizando o estoque
            System.out.println("Compra finalizada!");
            carrinho.clear();
            setTotal(0);
        }
    }
    
    public Produto[] getCarrinho() {
        return carrinho.toArray(new Produto[carrinho.size()]);
    }
}

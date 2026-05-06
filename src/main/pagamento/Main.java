package pagamento;

public class Main {

    public static void main(String[] args) {

        PagamentoTemplate cartao = new PagamentoCartao();
        PagamentoTemplate pix = new PagamentoPix();
        PagamentoTemplate boleto = new PagamentoBoleto();

        System.out.println("=== Cartão ===");
        cartao.realizarPagamento(100);

        System.out.println("\n=== PIX ===");
        pix.realizarPagamento(200);

        System.out.println("\n=== Boleto ===");
        boleto.realizarPagamento(300);
    }
}
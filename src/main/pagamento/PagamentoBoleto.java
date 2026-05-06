package pagamento;

public class PagamentoBoleto extends PagamentoTemplate {

    @Override
    protected void validarPagamento(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor inválido para boleto");
        }
        System.out.println("Validando boleto...");
    }

    @Override
    protected void processarPagamento(double valor) {
        System.out.println("Gerando boleto no valor de R$" + valor);
    }
}
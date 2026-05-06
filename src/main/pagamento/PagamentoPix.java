package pagamento;

public class PagamentoPix extends PagamentoTemplate {

    @Override
    protected void validarPagamento(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor inválido para PIX");
        }
        System.out.println("Validando pagamento via PIX...");
    }

    @Override
    protected void processarPagamento(double valor) {
        System.out.println("Processando PIX: R$" + valor);
    }
}
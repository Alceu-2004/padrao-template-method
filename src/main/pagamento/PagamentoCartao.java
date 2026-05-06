package pagamento;

public class PagamentoCartao extends PagamentoTemplate {

    @Override
    protected void validarPagamento(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor inválido para cartão");
        }
        System.out.println("Validando pagamento no cartão...");
    }

    @Override
    protected void processarPagamento(double valor) {
        System.out.println("Processando pagamento no cartão: R$" + valor);
    }
}
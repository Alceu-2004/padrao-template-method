package pagamento;

public abstract class PagamentoTemplate {

    public final void realizarPagamento(double valor) {
        validarPagamento(valor);
        processarPagamento(valor);
        gerarRecibo(valor);
    }

    protected abstract void validarPagamento(double valor);
    protected abstract void processarPagamento(double valor);
    protected void gerarRecibo(double valor) {
        System.out.println("Recibo gerado no valor de R$" + valor);
    }
}
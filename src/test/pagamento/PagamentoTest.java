package pagamento;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PagamentoTest {

    @Test
    void deveExecutarFluxoCompletoCartao() {
        PagamentoTemplate pagamento = new PagamentoCartao();

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        pagamento.realizarPagamento(100);

        String output = out.toString();

        assertTrue(output.contains("Validando pagamento no cartão"));
        assertTrue(output.contains("Processando pagamento no cartão"));
        assertTrue(output.contains("Recibo gerado"));
    }

    @Test
    void deveExecutarFluxoCompletoPix() {
        PagamentoTemplate pagamento = new PagamentoPix();

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        pagamento.realizarPagamento(200);

        String output = out.toString();

        assertTrue(output.contains("PIX"));
    }

    @Test
    void deveExecutarFluxoCompletoBoleto() {
        PagamentoTemplate pagamento = new PagamentoBoleto();

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        pagamento.realizarPagamento(300);

        String output = out.toString();

        assertTrue(output.contains("boleto"));
    }

    @Test
    void deveFalharValorInvalido() {
        PagamentoTemplate pagamento = new PagamentoPix();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            pagamento.realizarPagamento(0);
        });

        assertTrue(exception.getMessage().contains("inválido"));
    }
}
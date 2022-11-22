package businessobject;

import modelo.Servico;

import java.math.BigDecimal;

public class DescontoClienteNovo implements DescontoCliente {
    @Override
    public void aplicarDesconto(Servico servico) {
        System.out.println("Cliente Novo tem 10% de desconto!");
        BigDecimal valorComDesconto = servico.getValor().multiply(new BigDecimal(0.90));
        servico.setValor(valorComDesconto);
    }
}

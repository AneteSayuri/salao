package businessobject;

import modelo.Servico;

import java.math.BigDecimal;

public class DescontoClienteVip implements DescontoCliente {
    @Override
    public void aplicarDesconto(Servico servico) {
        System.out.println("Cliente VIP tem 20% de desconto!");
        BigDecimal valorComDesconto = servico.getValor().multiply(new BigDecimal(0.80));
        servico.setValor(valorComDesconto);
    }
}

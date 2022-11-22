package businessobject;

import modelo.Servico;

import java.math.BigDecimal;

public class DescontoClienteRegular implements DescontoCliente {
    @Override
    public void aplicarDesconto(Servico servico) {
        System.out.println("Cliente Regular tem 5% de desconto!");
        BigDecimal valorComDesconto = servico.getValor().multiply(new BigDecimal(0.95));
        servico.setValor(valorComDesconto);
    }
}

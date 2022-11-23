package businessobject;

import modelo.Servico;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class DescontoClienteRegular implements DescontoCliente {
    @Override
    public void aplicarDesconto(Servico servico) {
        BigDecimal valorComDesconto = servico.getValor().multiply(new BigDecimal(0.95));
        String valorFormatado = NumberFormat
                .getCurrencyInstance(new Locale("pt", "br"))
                .format(valorComDesconto);
        System.out.println(" .Cliente Regular tem 5% de desconto: " + valorFormatado);
    }
}

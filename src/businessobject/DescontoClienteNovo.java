package businessobject;

import modelo.Servico;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class DescontoClienteNovo implements DescontoCliente {
    @Override
    public void aplicarDesconto(Servico servico) {
        BigDecimal valorComDesconto = servico.getValor().multiply(new BigDecimal(0.90));
        String valorFormatado = NumberFormat
                .getCurrencyInstance(new Locale("pt", "br"))
                .format(valorComDesconto);
        System.out.println(" .Cliente Novo tem 10% de desconto: " + valorFormatado);
    }

}

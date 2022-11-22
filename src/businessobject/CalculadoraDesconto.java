package businessobject;

import br.com.ada.petshop.modelo.Servico;

public class CalculadoraDescontoPrecoServico {

    // sempre que uma nova foram de pagamento for criada, teremos que adiconar um novo if
    // nossa classe estar� aberta para altera��es
    // podendo gerar bugs ao sofrer altera��es
    // Podemos aplicar o O do SOLID?
    // O - OCP - Open-Closed Principle - Principio aberto e fechado?

    /*public void aplicaDesconto(Servico servico, Pagamento pagamento){

        if (TipoPagamentoEnum.CREDITO.equals(pagamento.getTipoPagamento())){
            //se for credito, desconto de R$ 1.00
            BigDecimal valorComDesconto = servico.getValor().subtract(new BigDecimal(1.0));
            servico.setValor(valorComDesconto);

        } else if (TipoPagamentoEnum.DEBITO.equals(pagamento.getTipoPagamento())){
            //se for debito, desconto de R$ 10.00
            BigDecimal valorComDesconto = servico.getValor().subtract(new BigDecimal(10.0));
            servico.setValor(valorComDesconto);
        }
    }*/

    // aqui nesse metodo receberemos qualquer classe que implemente a interface AplicadorDesconto
    // ser� chamada a l�gica do aplicador de desconto que chegar aqui como parametro
    // n�o preciso mais realizar altera��es aqui (fechado para altera��o)
    // independente de qual desconto seja criado futuramente, basta que implemente a interface AplicadorDesconto
    // Ex: Classes DescontoCredito, DescontoPix, etc
    public void aplicaDesconto(Servico servico, AplicadorDesconto aplicadorDesconto){
        aplicadorDesconto.aplicaDesconto(servico);
    }
}

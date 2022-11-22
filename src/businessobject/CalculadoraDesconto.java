package businessobject;

import modelo.Servico;

public class CalculadoraDesconto {
    public void aplicaDesconto(Servico servico, DescontoCliente descontoCliente){
        descontoCliente.aplicarDesconto(servico);
    }
}

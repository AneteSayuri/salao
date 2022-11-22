package modelo;

import enumeracao.TipoServicoEnum;

import java.math.BigDecimal;

public class Servico {

    private TipoServicoEnum tipoServico;
    private BigDecimal valor;

    public TipoServicoEnum getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(TipoServicoEnum tipoServico) {
        this.tipoServico = tipoServico;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
            this.valor = valor;
    }

    @Override
    public String toString() {
        return tipoServico + ": R$ " + valor;
    }
}


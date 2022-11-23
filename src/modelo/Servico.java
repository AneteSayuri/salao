package modelo;

import enumeracao.TipoServicoEnum;

import java.math.BigDecimal;

public class Servico {

    private TipoServicoEnum tipoServico;
    private BigDecimal valor;

    public Servico() {
    }

    public Servico(TipoServicoEnum tipoServico, BigDecimal valor) {
        this.tipoServico = tipoServico;
        this.valor = valor;
    }

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
        return tipoServico + ": R$" + valor;
    }
}


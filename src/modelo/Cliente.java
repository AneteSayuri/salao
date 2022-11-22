package modelo;

import enumeracao.SexoEnum;
import enumeracao.TipoClienteEnum;

public class Cliente extends Pessoa{
    private TipoClienteEnum tipoCliente;

    public Cliente(String nome, TipoClienteEnum tipoCliente) {
        super(nome);
        this.tipoCliente = tipoCliente;
    }

    public Cliente(String nome, int idade, String telefone, SexoEnum sexo, TipoClienteEnum tipoCliente) {
        super(nome);
        super.setIdade(idade);
        super.setTelefone(telefone);
        super.setSexo(sexo);
        this.tipoCliente = tipoCliente;
    }

    public TipoClienteEnum getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoClienteEnum tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    @Override
    public String toString() {
        return "Cliente " + tipoCliente + " - " + super.toString();
    }
}

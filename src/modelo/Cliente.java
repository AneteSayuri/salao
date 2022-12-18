package modelo;

import enumeracao.SexoEnum;
import enumeracao.TipoClienteEnum;

import java.time.LocalDate;

public class Cliente extends Pessoa {
    private TipoClienteEnum tipoCliente;

    public Cliente(String nome, TipoClienteEnum tipoCliente) {
        super(nome);
        this.tipoCliente = tipoCliente;
    }

    public Cliente(String nome, String telefone, SexoEnum sexo, LocalDate dataDeNascimento, TipoClienteEnum tipoCliente) {
        super(nome);
        super.setTelefone(telefone);
        super.setSexo(sexo);
        super.setDataDeNascimento(dataDeNascimento);
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

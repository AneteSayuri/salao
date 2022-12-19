package modelo;

import enumeracao.SexoEnum;
import enumeracao.TipoClienteEnum;

import java.time.LocalDate;

public class ClienteBuilder extends Pessoa {
    private TipoClienteEnum tipoCliente;

    public ClienteBuilder nome(String nome) {
        super.setNome(nome);
        return this;
    }

    public ClienteBuilder telefone(String telefone) {
        super.setTelefone(telefone);
        return this;
    }

    public ClienteBuilder sexo(SexoEnum sexo) {
        super.setSexo(sexo);
        return this;
    }

    public ClienteBuilder dataDeNascimento(LocalDate dataDeNascimento) {
        super.setDataDeNascimento(dataDeNascimento);
        return this;
    }

    public ClienteBuilder tipoCliente(TipoClienteEnum tipoCliente) {
        this.tipoCliente = tipoCliente;
        return this;
    }

    public Cliente build() {
        Cliente clienteBuild = new Cliente(getNome(), getTelefone(), getSexo(), getDataDeNascimento(), tipoCliente);
        return clienteBuild;
    }
}

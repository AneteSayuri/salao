package modelo;

import enumeracao.SexoEnum;
import enumeracao.TipoFuncionarioEnum;

import java.time.LocalDate;

public class FuncionarioBuilder extends Pessoa {

    private TipoFuncionarioEnum tipoFuncionario;

    public FuncionarioBuilder nome(String nome) {
        super.setNome(nome);
        return this;
    }

    public FuncionarioBuilder telefone(String telefone) {
        super.setTelefone(telefone);
        return this;
    }

    public FuncionarioBuilder sexo(SexoEnum sexo) {
        super.setSexo(sexo);
        return this;
    }

    public FuncionarioBuilder dataDeNascimento(LocalDate dataDeNascimento) {
        super.setDataDeNascimento(dataDeNascimento);
        return this;
    }

    public FuncionarioBuilder tipoFuncionario(TipoFuncionarioEnum tipoFuncionario) {
        this.tipoFuncionario = tipoFuncionario;
        return this;
    }

    public Funcionario build() {
        Funcionario funcionarioBuild = new Funcionario(getNome(), getTelefone(), getSexo(), getDataDeNascimento(), tipoFuncionario);
        return funcionarioBuild;
    }
}

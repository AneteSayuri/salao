package modelo;

import enumeracao.SexoEnum;
import enumeracao.TipoFuncionarioEnum;

import java.io.Serializable;
import java.time.LocalDate;

public class Funcionario extends Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    private TipoFuncionarioEnum tipoFuncionario;

    public Funcionario(String nome, String telefone, SexoEnum sexo, LocalDate dataDeNascimento, TipoFuncionarioEnum tipoFuncionario) {
        super(nome);
        super.setTelefone(telefone);
        super.setSexo(sexo);
        super.setDataDeNascimento(dataDeNascimento);
        this.tipoFuncionario = tipoFuncionario;
    }

    public TipoFuncionarioEnum getTipoFuncionario() {
        return tipoFuncionario;
    }

    public void setTipoFuncionario(TipoFuncionarioEnum tipoFuncionario) {
        this.tipoFuncionario = tipoFuncionario;
    }

    @Override
    public String toString() {
        return tipoFuncionario + ": " + super.toString();
    }
}

package modelo;

import enumeracao.TipoFuncionarioEnum;

public class Funcionario extends Pessoa{

    private TipoFuncionarioEnum tipoFuncionario;

    public Funcionario(String nome, TipoFuncionarioEnum tipoFuncionario) {
        super(nome);
        this.tipoFuncionario = tipoFuncionario;
    }
}

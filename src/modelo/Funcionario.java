package modelo;

import enumeracao.TipoFuncionarioEnum;

public class Funcionario extends Pessoa{

    private TipoFuncionarioEnum tipoFuncionario;

    public Funcionario(String nome, TipoFuncionarioEnum tipoFuncionario) {
        super(nome);
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

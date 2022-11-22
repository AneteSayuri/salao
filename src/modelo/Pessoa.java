package modelo;

import enumeracao.SexoEnum;

public class Pessoa {

    private String nome;
    private int idade;
    private String telefone;
    private SexoEnum sexo;


    public Pessoa(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if(idade <= 0){
            System.err.println("A idade precisa ser maior do que zero.");
        } else {
            this.idade = idade;
        }
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public SexoEnum getSexo() {
        return sexo;
    }

    public void setSexo(SexoEnum sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "{Nome: '" + nome + '\'' +
                ", Idade: " + idade +
                ", Telefone: '" + telefone + '\'' +
                ", Sexo: " + sexo +
                "}";
    }
}

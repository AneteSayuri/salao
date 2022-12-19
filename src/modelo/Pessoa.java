package modelo;

import enumeracao.SexoEnum;

import java.time.LocalDate;
import java.time.Period;

public class Pessoa {

    private String nome;
    private String telefone;
    private SexoEnum sexo;
    private LocalDate dataDeNascimento;


    public Pessoa() {
    }

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        if (dataDeNascimento.isAfter(LocalDate.now())) {
            System.err.println("A data de nascimento precisa ser anterior a data de hoje.");
        } else {
            this.dataDeNascimento = dataDeNascimento;
        }
    }

    public int getIdade() {
        return Period.between(dataDeNascimento, LocalDate.now()).getYears();
    }


    @Override
    public String toString() {
        return "{Nome: '" + nome + '\'' +
                ", Idade: " + getIdade() +
                ", Telefone: '" + telefone + '\'' +
                ", Sexo: " + sexo +
                "}";
    }
}

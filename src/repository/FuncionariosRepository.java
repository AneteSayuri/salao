package repository;

import businessobject.Relatorios;
import modelo.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class FuncionariosRepository {
    private static List<Funcionario> funcionariosList = new ArrayList<>();

    public void inserirNaLista(Funcionario funcionario){
            funcionariosList.add(funcionario);
    }

    public void imprimirFuncionariosCadastrados(){
        Relatorios<Funcionario> relatorio = new Relatorios();

        System.out.println("______________________ FUNCIONÁRIOS DESTE SALÃO ______________________\n");

        if (funcionariosList.size() > 0) {
            System.out.println("Este salão possui " + funcionariosList.size() + " funcionários:");
            relatorio.imprimirLista(funcionariosList);
        } else if (funcionariosList.isEmpty()){
            System.out.println("Não há Funcionários cadastrados neste salão.");
        }
    }

}

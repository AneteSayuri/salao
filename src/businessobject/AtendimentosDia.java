package businessobject;

import modelo.Cliente;

import java.util.ArrayList;
import java.util.List;

public class AtendimentosDia {

    private final int NUMERO_MAXIMO_ATENDIMENTOS = 3;
    private int posicoesDisponiveis;
    private static List<Cliente> filaClientes = new ArrayList<>();

    public void setFilaClientes(Cliente cliente){
        if (filaClientes.size() < NUMERO_MAXIMO_ATENDIMENTOS) {
            filaClientes.add(cliente);
        } else{
            System.out.println("Não há mais vagas para atendimento hoje. Favor remarcar amanhã.");
        }
    }

    public void mostrarFilaClientes(){
        System.out.println("______________________ CLIENTES A SEREM ATENDIDOS HOJE ______________________");
        posicoesDisponiveis = NUMERO_MAXIMO_ATENDIMENTOS - filaClientes.size();
        System.out.println("Há " + posicoesDisponiveis + " posições ainda disponíveis para atendimento.");
        Relatorios<Cliente> relatorio = new Relatorios();
        relatorio.imprimirLista(filaClientes);

    }
    public void limparFilaClientes(){
        System.out.println("_______________________ LIMPANDO A FILA DE ATENDIMENTO DE HOJE _______________________");
        filaClientes.clear();
    }


}

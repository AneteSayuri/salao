package repository;

import businessobject.Relatorios;
import modelo.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClientesRepository {
    private static List<Cliente> clientesCadastrados = new ArrayList<>();
//    private static int sequence = 1;

    public void inserirNaLista(Cliente cliente){
//        cliente.setId(sequence);
//        sequence ++;
            clientesCadastrados.add(cliente);
    }

    public void imprimirClientesCadastrados(){
        System.out.println("_____________ CLIENTES CADASTRADOS:_____________");
        Relatorios<Cliente> relatorio = new Relatorios();
        relatorio.imprimirLista(clientesCadastrados);

        if (clientesCadastrados.isEmpty()){
            System.out.println("_____________ NÃO HÁ CLIENTES CADASTRADOS _____________");
        }
    }

    public void removerClienteCadastrado(int indice){
        clientesCadastrados.remove(indice);
    }

    public void limparListaCadastrada(){
        System.out.println("_____________ LIMPANDO A LISTA DE CADASTRO______________");
        this.clientesCadastrados.clear();
    }


}

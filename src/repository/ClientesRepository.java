package repository;

import businessobject.Relatorios;
import modelo.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClientesRepository {
    private static List<Cliente> clientesList = new ArrayList<>();

    public void inserirNaLista(Cliente cliente){
            clientesList.add(cliente);
    }

    public void imprimirClientesCadastrados(){
        System.out.println("________________________ LISTA DE CLIENTES CADASTRADOS ________________________");
        Relatorios<Cliente> relatorio = new Relatorios();
        if (clientesList.size() > 0) {
            System.out.println("Número de Clientes cadastrados: " + clientesList.size());
            relatorio.imprimirLista(clientesList);
        } else if (clientesList.isEmpty()){
            System.out.println("A lista de Clientes cadastrados está vazia.");
        }
    }

    public void removerClienteCadastrado(int indice){
        System.out.println("Removendo o cliente: " + clientesList.get(indice));
        clientesList.remove(indice);
    }

    public Cliente getClienteCadastrado(int indice){
      return clientesList.get(indice);
    }

}

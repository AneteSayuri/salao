package teste;

import modelo.Cliente;

import java.util.*;

public class TesteCollections {

    public static void main(String[] args) {
        List<Cliente> listaClientes = new ArrayList<>();

        // metodo add, adiciona cachorro
        Cliente cliente1 = new Cliente();
        Cliente cliente2 = new Cliente();
        Cliente cliente3 = new Cliente();
        listaClientes.add(cliente1);
        listaClientes.add(cliente2);

        for (Cliente cliente: listaClientes) {
            System.out.println(cliente);
        }

        // metodo size ve a quantide de cachorros inseridos
        System.out.println(listaClientes.size());

        // metodo isEmpty ve se a lista esta vazia
        System.out.println(listaClientes.isEmpty());

        // metodo remove deleta um objeto por seu indice (posicao)
        listaClientes.remove(5);
        System.out.println(listaClientes.size());

        // metodo clear limpa a lista
        listaClientes.clear();
        System.out.println(listaClientes.size());

    }


}



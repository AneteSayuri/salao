package repository;

import modelo.Cliente;
import modelo.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepository{
    private static List<Cliente> clientesCadastrados = new ArrayList<>();
    private static int sequence = 1;

    public void cadastrar(Cliente pessoa){
        pessoa.setId(sequence);
        sequence ++;
            clientesCadastrados.add(pessoa);
    }


    public void imprimirClientesCadastrados(){
        System.out.println("_____________ CLIENTES CADASTRADOS:_____________");
        for (Cliente cliente : clientesCadastrados) {
                System.out.println(cliente);
        }

        if (clientesCadastrados.isEmpty()){
            System.out.println("_____________ZERO CLIENTES CADASTRADOS_____________");
        }
    }
    // metodo remove deleta um objeto por seu indice (posicao)
     //   listaFuncionarios.remove(5);
       // System.out.println(listaFuncionarios.size());

    public void limpaCadastro(){
        System.out.println("_____________LIMPANDO O CADASTRO______________");
        this.clientesCadastrados.clear();
    }


}

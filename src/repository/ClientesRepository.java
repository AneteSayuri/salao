package repository;

import businessobject.Relatorios;
import enumeracao.SexoEnum;
import enumeracao.TipoClienteEnum;
import modelo.Cliente;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ClientesRepository {
    private static List<Cliente> clientesList = new ArrayList<>();

    public void inserirNaLista(Cliente cliente) {
        clientesList.add(cliente);
    }

    public void imprimirClientesCadastrados() {
        System.out.println("\n________________________ LISTA DE CLIENTES CADASTRADOS ________________________");
        Relatorios<Cliente> relatorio = new Relatorios();
        if (clientesList.size() > 0) {
            System.out.println("Número de Clientes cadastrados: " + clientesList.size());
            relatorio.imprimirLista(clientesList);
        } else if (clientesList.isEmpty()) {
            System.out.println("A lista de Clientes cadastrados está vazia.");
        }
    }

    public void removerClienteCadastrado(int indice) {
        System.out.println("Removendo o cliente:\n" + clientesList.get(indice));
        clientesList.remove(indice);
    }

    public Cliente getClienteCadastrado(int indice) {
        return clientesList.get(indice);
    }

    public void lerClientesResource() {
        String path = "src/resources/ClientesResource.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            line = br.readLine();

            while (line != null) {
                String[] atributos = line.split(",");

                String nome = atributos[0];
                String telefone = atributos[1];
                SexoEnum sexo = SexoEnum.valueOf(atributos[2]);
                DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate dataDeNascimento = LocalDate.parse(atributos[3], formatoData);
                TipoClienteEnum tipoCliente = TipoClienteEnum.valueOf(atributos[4]);

                Cliente cliente = new Cliente(nome, telefone, sexo, dataDeNascimento, tipoCliente);
                inserirNaLista(cliente);

                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public void salvarBaseAtualizada() {
        String dateTimeNow = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmm"));
        String pathBackup = "src/resources/backup/Clientes_" + dateTimeNow + ".txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathBackup))) {
            bw.write("nome,telefone,sexo,dataDeNascimento,tipoCliente");
            bw.newLine();
            for (Cliente cliente : clientesList) {
                bw.write(cliente.getNome() + "," + cliente.getTelefone() + ","
                        + cliente.getSexo() + ","
                        + cliente.getDataDeNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ","
                        + cliente.getTipoCliente());
                bw.newLine();
            }
            System.out.println("Base Atual de Clientes Salva em: " + pathBackup);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}

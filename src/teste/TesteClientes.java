package teste;

import businessobject.AtendimentosDia;
import enumeracao.SexoEnum;
import enumeracao.TipoClienteEnum;
import modelo.Cliente;
import repository.ClientesRepository;

import java.util.Scanner;

public class TesteClientes {

    private static final ClientesRepository clienteRepository = new ClientesRepository();
    private static final AtendimentosDia atendimentosDia = new AtendimentosDia();


    public static void main(String[] args) {

        int opcaoSelecionada = 0;
        final int SAIR_DO_SISTEMA = 7;
        Scanner scanner = new Scanner(System.in);

        //Clientes criados para base inicial do Teste:
        Cliente cliente1 = new Cliente("Ana", 20, "1111-1111", SexoEnum.MULHER, TipoClienteEnum.REGULAR);
        Cliente cliente2 = new Cliente("Bia", 30, "1111-1112", SexoEnum.MULHER, TipoClienteEnum.VIP);
        Cliente cliente3 = new Cliente("Carlos", 40, "1111-1121", SexoEnum.HOMEM, TipoClienteEnum.REGULAR);
        Cliente cliente4 = new Cliente("Diego", 50, "1111-1211", SexoEnum.HOMEM, TipoClienteEnum.NOVO);
        Cliente cliente5 = new Cliente("Emilia", 60, "1111-2111", SexoEnum.MULHER, TipoClienteEnum.VIP);
        clienteRepository.inserirNaLista(cliente1);
        clienteRepository.inserirNaLista(cliente2);
        clienteRepository.inserirNaLista(cliente3);
        clienteRepository.inserirNaLista(cliente4);
        clienteRepository.inserirNaLista(cliente5);

        System.out.println("_________________________ BEM-VINDO À BASE DE CLIENTES _________________________");
        System.out.println("    Aqui será possível:");
        System.out.println("1 - Ver os clientes cadastrados.");
        System.out.println("2 - Cadastrar um novo cliente.");
        System.out.println("3 - Excluir um cliente cadastrado.");
        System.out.println("4 - Adicionar cliente na lista de atendimentos.");
        System.out.println("5 - Exibir a fila de atendimentos.");
        System.out.println("6 - Limpar a fila de atendimentos.");
        System.out.println("7 - Sair");

        do {
            System.out.println("___________________________________________________________________________");
            System.out.println("1-Visualizar, 2-Cadastrar, 3-Excluir, 4-Adicionar, 5-Fila, 6-Limpar, 7-Sair");
            System.out.print("Selecione a opção desejada: ");
            opcaoSelecionada = scanner.nextInt();

            switch (opcaoSelecionada) {
                case 1:
                    clienteRepository.imprimirClientesCadastrados();
                    break;
                case 2:
                    cadastrar(scanner, clienteRepository);
                    break;
                case 3:
                    remover(scanner, clienteRepository);
                    break;
                case 4:
                    adicionar(scanner, clienteRepository);
                    break;
                case 5:
                    atendimentosDia.mostrarFilaClientes();
                    break;
                case 6:
                    atendimentosDia.limparFilaClientes();
                    break;
                case 7:
                    System.out.println("Saindo do Sistema...");
                    break;
                default:
                    System.out.println("Opção invalida. Digite um número de 1 à 7.");
            }

        } while (opcaoSelecionada != SAIR_DO_SISTEMA);


    }

    private static void cadastrar(Scanner scanner, ClientesRepository clienteRepository) {
        System.out.println("_______________________ CADASTRAR NOVO CLIENTE _______________________");
        System.out.print("Informe o nome do Cliente: ");
        String nome = scanner.next();

        System.out.print("Digite a idade: ");
        int idade = scanner.nextInt();

        System.out.print("Digite o telefone para contato: ");
        String telefone = scanner.next();

        System.out.print("Digite se o cliente se identifica como Homem ou Mulher: ");
        String sexo = scanner.next().toUpperCase();
        SexoEnum sexoEnum = SexoEnum.valueOf(sexo);

        Cliente cliente = new Cliente(nome, TipoClienteEnum.NOVO);
        cliente.setIdade(idade);
        cliente.setTelefone(telefone);
        cliente.setSexo(sexoEnum);

        clienteRepository.inserirNaLista(cliente);
        System.out.println("Cliente adicionado à base de Clientes:");
        System.out.println(cliente);
    }

    private static void remover(Scanner scanner, ClientesRepository clienteRepository) {
        System.out.println("Indique um dos Clientes Cadastrados para ser excluído da Base.");
        clienteRepository.imprimirClientesCadastrados();
        System.out.print("\nDigite o número do Cliente a ser excluído: ");
        int indice = scanner.nextInt()-1;
        clienteRepository.removerClienteCadastrado(indice);
    }

    private static void adicionar(Scanner scanner, ClientesRepository clienteRepository) {
        System.out.println("Indique um dos Clientes Cadastrados para ser adicionar à lista de atendimentos do dia.");
        clienteRepository.imprimirClientesCadastrados();
        System.out.print("\nDigite o número do Cliente a ser adicionado: ");
        int indice = scanner.nextInt()-1;
        Cliente clienteCopia = clienteRepository.getClienteCadastrado(indice);
        System.out.println("Este Cliente está sendo adicionado à fila de atendimentos:");
        System.out.println(clienteCopia);
        atendimentosDia.setFilaClientes(clienteCopia);
    }
}

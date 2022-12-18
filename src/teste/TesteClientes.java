package teste;

import businessobject.AtendimentosDia;
import enumeracao.SexoEnum;
import enumeracao.TipoClienteEnum;
import modelo.Cliente;
import repository.ClientesRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TesteClientes {

    private static final ClientesRepository clienteRepository = new ClientesRepository();
    private static final AtendimentosDia atendimentosDia = new AtendimentosDia();


    public static void main(String[] args) {

        int opcaoSelecionada = 0;
        final int SAIR_DO_SISTEMA = 8;
        Scanner scanner = new Scanner(System.in);

        clienteRepository.lerClientesResource();

        System.out.println("\n_________________________ BEM-VINDO À BASE DE CLIENTES _________________________");
        System.out.println("    Aqui será possível:");
        System.out.println("1 - Ver os clientes cadastrados.");
        System.out.println("2 - Cadastrar um novo cliente.");
        System.out.println("3 - Excluir um cliente cadastrado.");
//        System.out.println("4 - Adicionar cliente na lista de atendimentos.");
//        System.out.println("5 - Exibir a fila de atendimentos.");
//        System.out.println("6 - Limpar a fila de atendimentos.");
        System.out.println("7 - Gravar a base de clientes Atualizada.");
        System.out.println("8 - Sair");

        do {
            System.out.println("___________________________________________________________________________");
            System.out.println("1-Visualizar | 2-Cadastrar | 3-Excluir | 7-Salvar Base | 8-Sair");
//            System.out.println("4-Adicionar   |  5-Fila      | 6-Limpar");
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
                    clienteRepository.salvarBaseAtualizada();
                    break;
                case 8:
                    System.out.println("Saindo do Sistema...");
                    break;
                default:
                    System.out.println("Opção invalida. Digite um número de 1 à 8.");
            }

        } while (opcaoSelecionada != SAIR_DO_SISTEMA);


    }

    private static void cadastrar(Scanner scanner, ClientesRepository clienteRepository) {
        System.out.println("\n_______________________ CADASTRAR NOVO CLIENTE _______________________");
        scanner.nextLine();
        System.out.print("Informe o nome do Cliente: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a Data de Nascimento (dd/mm/aaaa): ");
        String strData = scanner.nextLine();
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = LocalDate.parse(strData, formatoData);

        System.out.print("Digite o telefone para contato: ");
        String telefone = scanner.nextLine();

        System.out.print("Digite se o cliente se identifica como Homem ou Mulher: ");
        String sexo = scanner.next().toUpperCase();
        SexoEnum sexoEnum = SexoEnum.valueOf(sexo);

        Cliente cliente = new Cliente(nome, TipoClienteEnum.NOVO);
        cliente.setTelefone(telefone);
        cliente.setSexo(sexoEnum);
        cliente.setDataDeNascimento(data);

        clienteRepository.inserirNaLista(cliente);
        System.out.println("Cliente adicionado à base de Clientes:");
        System.out.println(cliente);
    }

    private static void remover(Scanner scanner, ClientesRepository clienteRepository) {
        System.out.println("\nIndique um dos Clientes Cadastrados para ser Excluído da Base.");
        clienteRepository.imprimirClientesCadastrados();
        System.out.print("\nDigite o número do Cliente a ser excluído: ");
        int indice = scanner.nextInt() - 1;
        clienteRepository.removerClienteCadastrado(indice);
    }

    private static void adicionar(Scanner scanner, ClientesRepository clienteRepository) {
        System.out.println("\nIndique um dos Clientes Cadastrados para ser Adicionado à lista de atendimentos do dia.");
        clienteRepository.imprimirClientesCadastrados();
        System.out.print("\nDigite o número do Cliente a ser Adicionado: ");
        int indice = scanner.nextInt() - 1;
        Cliente clienteCopia = clienteRepository.getClienteCadastrado(indice);
        System.out.println("Este Cliente está sendo adicionado à fila de atendimentos:");
        System.out.println(clienteCopia);
        atendimentosDia.setFilaClientes(clienteCopia);
    }
}

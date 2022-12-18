package repository;

import businessobject.Relatorios;
import enumeracao.SexoEnum;
import enumeracao.TipoFuncionarioEnum;
import modelo.Funcionario;
import modelo.Pessoa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class FuncionariosRepository {
    private static List<Funcionario> funcionariosList = new ArrayList<>();

    public void lerFuncionariosResource() {
        String path = "src/resources/FuncionariosResource.txt";

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
                TipoFuncionarioEnum tipoFuncionario = TipoFuncionarioEnum.valueOf(atributos[4]);

                Funcionario funcionario = new Funcionario(nome, telefone, sexo, dataDeNascimento, tipoFuncionario);
                inserirNaLista(funcionario);

                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public void inserirNaLista(Funcionario funcionario) {
        funcionariosList.add(funcionario);
    }

    public void imprimirFuncionariosCadastrados() {
        Relatorios<Funcionario> relatorio = new Relatorios();

        System.out.println("______________________ FUNCIONÁRIOS DESTE SALÃO ______________________\n");

        if (funcionariosList.size() > 0) {
            System.out.println("Este salão possui " + funcionariosList.size() + " funcionários:");
            relatorio.imprimirLista(funcionariosList);
        } else if (funcionariosList.isEmpty()) {
            System.out.println("Não há Funcionários cadastrados neste salão.");
        }
    }

    public void mediaIdades() {

        int totalIdades = funcionariosList.stream()
                .map(funcionario -> funcionario.getIdade())
                .reduce(0, (subtotal, valor) -> subtotal + valor);

        System.out.println("A Média de Idade dos funcionários deste salão é de: ("
                + totalIdades + " / " + funcionariosList.size() + ") = "
                + totalIdades / funcionariosList.size() + " anos.");
    }

    public void maxMinIdades() {

        var maisVelha = funcionariosList.stream()
                .min(Comparator.comparing(Pessoa::getDataDeNascimento));
        if (maisVelha.isPresent()) {
            System.out.println("O funcionário mais velho é a(o) " + maisVelha.get().getNome()
                    + " com " + maisVelha.get().getIdade() + " anos.");
        }
        Optional<Funcionario> maisNovo = funcionariosList.stream()
                .max(Comparator.comparing(Pessoa::getDataDeNascimento));
        System.out.println("O funcionário mais novo é a(o) " + maisNovo.get().getNome()
                + " com " + maisNovo.get().getIdade() + " anos.");
    }

    public void filtroSexo() {
        System.out.println("\nOs funcionários que se identificam como Mulher são:");
        funcionariosList.stream()
                .filter(sexo -> {
                    boolean mulher = sexo.getSexo().equals(SexoEnum.MULHER);
                    return mulher;
                }).forEach(System.out::println);

        System.out.println("\nOs funcionários que se identificam como Homem são:");
        funcionariosList.stream()
                .filter(sexo -> {
                    boolean homem = sexo.getSexo().equals(SexoEnum.HOMEM);
                    return homem;
                }).forEach(System.out::println);
    }
}

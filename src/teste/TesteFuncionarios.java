package teste;

import enumeracao.SexoEnum;
import enumeracao.TipoFuncionarioEnum;
import modelo.Funcionario;
import repository.FuncionariosRepository;

public class TesteFuncionarios {

    public static void main(String[] args) {

        FuncionariosRepository funcionariosRepository = new FuncionariosRepository();

        Funcionario recepcionista = new Funcionario("Ana", TipoFuncionarioEnum.RECEPCIONISTA);
        recepcionista.setIdade(22);
        recepcionista.setTelefone("1111-1111");
        recepcionista.setSexo(SexoEnum.MULHER);

        Funcionario cabeleireiro1 = new Funcionario("Bia", TipoFuncionarioEnum.CABELEIREIRO);
        cabeleireiro1.setIdade(32);
        cabeleireiro1.setTelefone("2222-2222");
        cabeleireiro1.setSexo(SexoEnum.MULHER);

        Funcionario cabeleireiro2 = new Funcionario("Carlos", TipoFuncionarioEnum.CABELEIREIRO);
        cabeleireiro2.setIdade(31);
        cabeleireiro2.setTelefone("1111-2222");
        cabeleireiro2.setSexo(SexoEnum.HOMEM);

        Funcionario barbeiro = new Funcionario("Daniel", TipoFuncionarioEnum.BARBEIRO);
        barbeiro.setIdade(21);
        barbeiro.setTelefone("1111-2221");
        barbeiro.setSexo(SexoEnum.HOMEM);

        Funcionario manicure = new Funcionario("Eliana", TipoFuncionarioEnum.MANICURE);
        manicure.setIdade(39);
        manicure.setTelefone("1111-2211");
        manicure.setSexo(SexoEnum.MULHER);

        funcionariosRepository.inserirNaLista(recepcionista);
        funcionariosRepository.inserirNaLista(cabeleireiro1);
        funcionariosRepository.inserirNaLista(cabeleireiro2);
        funcionariosRepository.inserirNaLista(barbeiro);
        funcionariosRepository.inserirNaLista(manicure);

        funcionariosRepository.imprimirFuncionariosCadastrados();

    }

}



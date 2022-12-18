package teste;

import repository.FuncionariosRepository;

public class TesteFuncionarios {

    public static void main(String[] args) {

        FuncionariosRepository funcionariosRepository = new FuncionariosRepository();
        funcionariosRepository.lerFuncionariosResource();
        System.out.println();
        funcionariosRepository.imprimirFuncionariosCadastrados();

        System.out.println("\n_____ RELATÓRIO DE ANÁLISE DO PERFIL DE FUNCIONÁRIOS DESTE SALÃO _____\n");
        funcionariosRepository.mediaIdades();
        funcionariosRepository.maxMinIdades();
        funcionariosRepository.filtroSexo();
        System.out.println("________________________________________________________________________");

    }

}



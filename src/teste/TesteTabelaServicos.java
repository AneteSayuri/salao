package teste;

import businessobject.*;
import enumeracao.TipoServicoEnum;
import modelo.Servico;

import java.math.BigDecimal;

public class TesteTabelaServicos {

    public static void main(String[] args) {

        Servico corteFeminino = new Servico(TipoServicoEnum.CORTE_FEMININO, new BigDecimal(100.00));
        Servico corteMasculino = new Servico(TipoServicoEnum.CORTE_MASCULINO, new BigDecimal(80.00));
        Servico manicure = new Servico(TipoServicoEnum.MANICURE, new BigDecimal(50.00));
        Servico barba = new Servico(TipoServicoEnum.BARBA, new BigDecimal(20.00));

        CalculadoraDesconto calculadoraDesconto = new CalculadoraDesconto();
        DescontoCliente descontoClienteNovo = new DescontoClienteNovo();
        DescontoCliente descontoClienteRegular = new DescontoClienteRegular();
        DescontoCliente descontoClienteVip = new DescontoClienteVip();

        System.out.println("____________________ TABELA DE PREÇO DOS SERVIÇOS ____________________");

        System.out.println("\n" + corteFeminino);
        calculadoraDesconto.aplicaDesconto(corteFeminino, descontoClienteNovo);
        calculadoraDesconto.aplicaDesconto(corteFeminino, descontoClienteRegular);
        calculadoraDesconto.aplicaDesconto(corteFeminino, descontoClienteVip);
        System.out.println("\n" + corteMasculino);
        calculadoraDesconto.aplicaDesconto(corteMasculino, descontoClienteNovo);
        calculadoraDesconto.aplicaDesconto(corteMasculino, descontoClienteRegular);
        calculadoraDesconto.aplicaDesconto(corteMasculino, descontoClienteVip);
        System.out.println("\n" + manicure);
        calculadoraDesconto.aplicaDesconto(manicure, descontoClienteNovo);
        calculadoraDesconto.aplicaDesconto(manicure, descontoClienteRegular);
        calculadoraDesconto.aplicaDesconto(manicure, descontoClienteVip);
        System.out.println("\n" + barba);
        calculadoraDesconto.aplicaDesconto(barba, descontoClienteNovo);
        calculadoraDesconto.aplicaDesconto(barba, descontoClienteRegular);
        calculadoraDesconto.aplicaDesconto(barba, descontoClienteVip);

    }
}

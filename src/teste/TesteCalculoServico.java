package teste;

import businessobject.*;
import enumeracao.TipoServicoEnum;
import modelo.Servico;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class TesteCalculoServico {

    public static void main(String[] args) {

        Servico corteFeminino = new Servico();
        corteFeminino.setTipoServico(TipoServicoEnum.CORTE_FEMININO);
        corteFeminino.setValor(new BigDecimal(100.00));

        Servico corteMasculino = new Servico();
        corteMasculino.setTipoServico(TipoServicoEnum.CORTE_MASCULINO);
        corteMasculino.setValor(new BigDecimal(50.00));

        Servico barba = new Servico();
        barba.setTipoServico(TipoServicoEnum.BARBA);
        barba.setValor(new BigDecimal(20.00));

        Servico manicure = new Servico();
        manicure.setTipoServico(TipoServicoEnum.MANICURE);
        manicure.setValor(new BigDecimal(50.00));

        CalculadoraDesconto calculadoraDesconto = new CalculadoraDesconto();

        System.out.println(corteFeminino);
        DescontoCliente descontoClienteNovo = new DescontoClienteNovo();
        calculadoraDesconto.aplicaDesconto(corteFeminino, descontoClienteNovo);
        System.out.println("Valor com desconto: "+getValorFormatado(corteFeminino.getValor()));
        System.out.println();

        System.out.println(corteMasculino);
        DescontoCliente descontoClienteRegular = new DescontoClienteRegular();
        calculadoraDesconto.aplicaDesconto(corteMasculino, descontoClienteRegular);
        System.out.println("Valor com desconto: "+ getValorFormatado(corteMasculino.getValor()));
        System.out.println();

        System.out.println(barba);
        DescontoCliente descontoClienteVip = new DescontoClienteVip();
        calculadoraDesconto.aplicaDesconto(barba, descontoClienteVip);
        System.out.println("Valor com desconto: "+ getValorFormatado(barba.getValor()));

    }

    private static String getValorFormatado(BigDecimal valor){
        String valorFormatado = NumberFormat
                .getCurrencyInstance(new Locale("pt", "br"))
                .format(valor);
        return valorFormatado;
    }
}

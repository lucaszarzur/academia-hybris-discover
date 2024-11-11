package dependencyInjection;

import dependencyInjection.calculadoraImpostoDI.*;
import dto.Produto;
import dependencyInjection.java.PrecificacaoServiceDI;

import java.math.BigDecimal;

public class TesteMainDependencyInjectionJava {

    public static void main(String[] args) {
        //PrecificacaoServiceDI precificacaoServiceDI = new PrecificacaoServiceDI(new CalculadoraImpostoLucroPresumidoDI());
        PrecificacaoServiceDI precificacaoServiceDI = new PrecificacaoServiceDI(new CalculadoraImpostoSimplesNacionalDI());


        BigDecimal result = precificacaoServiceDI.calcularPreco(new Produto());
        System.out.println(result);
    }
}

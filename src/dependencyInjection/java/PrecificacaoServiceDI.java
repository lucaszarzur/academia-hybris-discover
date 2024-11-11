package dependencyInjection.java;

import dto.Produto;

import java.math.BigDecimal;

public class PrecificacaoServiceDI {

    private CalculadoraImposto calculadoraImposto;

    public PrecificacaoServiceDI(CalculadoraImposto calculadoraImposto) {
        this.calculadoraImposto = calculadoraImposto;
    }

    public BigDecimal calcularPreco(Produto produto) {
        // faz outros cálculos de preço
        return this.calculadoraImposto.calcular(produto);
    }

}
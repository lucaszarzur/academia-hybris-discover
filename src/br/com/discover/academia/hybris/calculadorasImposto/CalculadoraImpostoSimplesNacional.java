package br.com.discover.academia.hybris.calculadorasImposto;

import br.com.discover.academia.hybris.Produto;

import java.math.BigDecimal;

public class CalculadoraImpostoSimplesNacional implements CalculadoraImposto {

    public BigDecimal calcular(Produto produto) {
        return new BigDecimal(2);
    }

}
package br.com.discover.academia.hybris.calculadorasImposto;

import br.com.discover.academia.hybris.Produto;

import java.math.BigDecimal;

//@Primary
public class CalculadoraImpostoLucroPresumido implements CalculadoraImposto {

    public BigDecimal calcular(Produto produto) {
        return new BigDecimal(1);
    }

}
package br.com.discover.academia.hybris.calculadorasImposto;

import br.com.discover.academia.hybris.Produto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Qualifier("simplesNacional")
@Component
public class CalculadoraImpostoSimplesNacional implements CalculadoraImposto {

    public BigDecimal calcular(Produto produto) {
        return new BigDecimal(2);
    }

}
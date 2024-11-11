package br.com.discover.academia.hybris.calculadorasImposto;

import br.com.discover.academia.hybris.Produto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

//@Primary
@Qualifier("lucroPresumido")
@Component
public class CalculadoraImpostoLucroPresumido implements CalculadoraImposto {

    public BigDecimal calcular(Produto produto) {
        return new BigDecimal(1);
    }

}
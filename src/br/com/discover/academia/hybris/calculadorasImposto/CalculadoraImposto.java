package br.com.discover.academia.hybris.calculadorasImposto;

import java.math.BigDecimal;
import br.com.discover.academia.hybris.Produto;

public interface CalculadoraImposto {

    BigDecimal calcular(Produto produto);
}

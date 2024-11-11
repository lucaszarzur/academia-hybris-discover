package dependencyInjection.java;

import dto.Produto;

import java.math.BigDecimal;

public interface CalculadoraImposto {

    BigDecimal calcular(Produto produto);
}

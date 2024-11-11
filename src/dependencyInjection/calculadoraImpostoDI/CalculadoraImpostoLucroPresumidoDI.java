package dependencyInjection.calculadoraImpostoDI;

import dependencyInjection.java.CalculadoraImposto;
import dto.Produto;

import java.math.BigDecimal;

public class CalculadoraImpostoLucroPresumidoDI implements CalculadoraImposto {

    public BigDecimal calcular(Produto produto) {
        return new BigDecimal(0);
    }
}

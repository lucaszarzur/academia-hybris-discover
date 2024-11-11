import dto.Produto;

import java.math.BigDecimal;

public class PrecificacaoService {

    //private CalculadoraImpostoSimplesNacional calculadoraImposto = new CalculadoraImpostoSimplesNacional();
    private CalculadoraImpostoLucroPresumido calculadoraImposto = new CalculadoraImpostoLucroPresumido();

    public BigDecimal calcularPreco(Produto produto) {
        // faz outros cálculos de preço
        return this.calculadoraImposto.calcular(produto);
    }

}
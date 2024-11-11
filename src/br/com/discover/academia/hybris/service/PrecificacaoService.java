package br.com.discover.academia.hybris.service;

import br.com.discover.academia.hybris.Produto;
import br.com.discover.academia.hybris.calculadorasImposto.CalculadoraImposto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.math.BigDecimal;

public class PrecificacaoService {

    // Aqui nós qualificamos qual bean queremos injetar
    @Qualifier("simplesNacional") // simplesNacional
    @Autowired
    private CalculadoraImposto calculadoraImposto;

    public BigDecimal calcularPreco(Produto produto) {
        return this.calculadoraImposto.calcular(produto);
    }

}
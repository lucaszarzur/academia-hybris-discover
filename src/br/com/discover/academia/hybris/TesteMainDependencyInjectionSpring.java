package br.com.discover.academia.hybris;

import br.com.discover.academia.hybris.service.PrecificacaoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

public class TesteMainDependencyInjectionSpring {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("resources/config/applicationContext.xml");
        PrecificacaoService precificacaoService = context.getBean(PrecificacaoService.class);

        BigDecimal result = precificacaoService.calcularPreco(new Produto());
        System.out.println(result);
    }
}

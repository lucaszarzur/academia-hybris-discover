package br.com.discover.academia.hybris;

import br.com.discover.academia.hybris.config.AppConfig;
import br.com.discover.academia.hybris.service.PrecificacaoService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;

public class TesteMainDependencyInjectionSpring {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        PrecificacaoService precificacaoService = context.getBean(PrecificacaoService.class);

        BigDecimal result = precificacaoService.calcularPreco(new Produto());
        System.out.println(result);
    }
}

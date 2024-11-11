import dto.Produto;

import java.math.BigDecimal;

public class TesteMain {

    public static void main(String[] args) {
        PrecificacaoService precificacaoService = new PrecificacaoService();

        BigDecimal result = precificacaoService.calcularPreco(new Produto());
        System.out.println(result);
    }
}

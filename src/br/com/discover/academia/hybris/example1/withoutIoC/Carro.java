package br.com.discover.academia.hybris.example1.withoutIoC;

/*
    Aqui, a classe Carro cria e gerencia a instância de Motor.
    Se quisermos mudar o tipo de motor ou criar testes, isso exigirá mudanças diretas no código da classe Carro
 */
public class Carro {
    private Motor motor;

    public Carro() {
        motor = new Motor(); // Carro é responsável por instanciar o motor
    }

    public void dirigir() {
        motor.ligar();
        System.out.println("Carro está dirigindo!");
    }
}
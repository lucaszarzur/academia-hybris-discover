package br.com.discover.academia.hybris.example1;

import br.com.discover.academia.hybris.example1.withoutIoC.Motor;

/*
    Carro ainda depende de motor, porém, Motor agora é injetado via construtor, sendo responsabilidade de quem o chama
    instanciar, ou seja, invertendo o controle. Agora quem gerencia essa dependência é o container
 */
public class Carro {
    private Motor motor;

    // Motor é injetado, mas Carro não o cria
    public Carro(Motor motor) {
        this.motor = motor;
    }

    public void dirigir() {
        motor.ligar();
        System.out.println("Carro está dirigindo!");
    }
}
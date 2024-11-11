package br.com.discover.academia.hybris.example1;

import br.com.discover.academia.hybris.example1.withoutIoC.Motor;

public class TestProgramIoC {

    public static void main(String[] args) {
        // Setting up the IoC container (dependency injection container)
        Motor motor = new Motor();
        Carro carro = new Carro(motor); // passando Motor como dependencia, gerenciada pelo container

        // Using the class Carro without worrying about creating its dependencies
        carro.dirigir();
    }
}

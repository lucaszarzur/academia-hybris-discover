package br.com.discover.academia.hybris.example1.withoutIoC;


public class TestProgram {

    public static void main(String[] args) {
        // Setting up the IoC container (dependency injection container)
        Carro carro = new Carro(); // delegada a responsabilidade para Carro

        // Using the TaskProcessor without worrying about creating its dependencies
        carro.dirigir();
    }
}

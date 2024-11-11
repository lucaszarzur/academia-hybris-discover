package br.com.discover.academia.hybris.example2;

public class TestProgram {

    public static void main(String[] args) {
        // Setting up the IoC container (dependency injection container)
        ITaskService taskService = new TaskService();
        TaskProcessor taskProcessor = new TaskProcessor(taskService);

        // Using the TaskProcessor without worrying about creating its dependencies
        String result = taskProcessor.processTask();
        System.out.println(result);
    }
}

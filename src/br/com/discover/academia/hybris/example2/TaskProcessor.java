package br.com.discover.academia.hybris.example2;

// Class that depends on ITaskService
public class TaskProcessor {

    private ITaskService taskService;

    // Constructor injection of the dependency
    public TaskProcessor(ITaskService taskService)
    {
        this.taskService = taskService;
    }

    public String processTask()
    {
        // Using the injected dependency
        return taskService.performTask();
    }
}

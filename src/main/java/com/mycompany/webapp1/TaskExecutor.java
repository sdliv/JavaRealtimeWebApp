/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.webapp1;

import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author seand
 */
@Component
@Scope("singleton")
public class TaskExecutor {
    private List<Task> pool = new LinkedList<>();
    
    @PostConstruct
    public void initialize() {
        Runnable taskPoolConsumer = () -> {
            while (true) {
                try {
                    this.pool.stream()
                            .filter(task -> task.isRunning() && task.getDuration() > 0)
                            .forEach(task -> task.decrementDuration());
                    
                    this.pool.stream()
                            .filter(task -> task.isRunning() && task.getDuration() == 0)
                            .forEach(task -> task.setStatus(TaskStatus.SUCCESS));
                    
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        
        new Thread(taskPoolConsumer).start();
    }
    
    public void startAllTasks() throws InterruptedException {
        this.pool.stream().forEach(task -> task.start());
    }
    
    public List getPool() {
        return this.pool;
    }
    
    public void addTask(Task taskToAdd) {
        this.pool.add(taskToAdd);
    }
    
}

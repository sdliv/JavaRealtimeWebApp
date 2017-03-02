/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.webapp1;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author seand
 */
@RestController
@RequestMapping("api/task")
public class TaskService {
    @Autowired
    private TaskExecutor taskExecutor;
    
    @RequestMapping(method = RequestMethod.GET)
    public List getTasks() {
        return this.taskExecutor.getPool();
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public void addTask(@RequestBody Task taskToAdd) {
        this.taskExecutor.addTask(taskToAdd);
    }
    
    public void startIdleTasks() throws InterruptedException {
        this.taskExecutor.startAllTasks();
    }
}

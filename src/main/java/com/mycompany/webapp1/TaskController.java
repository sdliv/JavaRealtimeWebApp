/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.webapp1;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



/**
 *
 * @author seand
 */
@ManagedBean(name = "taskController", eager = true)
@Component
@RequestScoped
public class TaskController {
    @Autowired
    private TaskService taskService;
    
    public void startTasks(ActionEvent event) throws InterruptedException {
        this.taskService.startIdleTasks();
    }
}

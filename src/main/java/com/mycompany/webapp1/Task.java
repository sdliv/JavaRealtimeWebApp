/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.webapp1;

/**
 *
 * @author seand
 */
public class Task {
    private TaskStatus status = TaskStatus.IDLE;
    private long duration;
    
    // Getters and Sett4ers
    
    public TaskStatus getStatus() {
        return status;
    }
    
    public void setStatus(TaskStatus status) {
        this.status = status;
    }
    
    public long getDuration() {
        return duration;
    }
    
    public void setDuration(long duration) {
        this.duration = duration;
    }
    public void decrementDuration() {
        this.duration--;
    }
    
    public boolean isRunning() {
        return this.status.equals(TaskStatus.RUNNING);
    }
    
    public String getName() {
        return this.toString();
    }
    
    public void start() {
        this.status = TaskStatus.RUNNING;
    }
}

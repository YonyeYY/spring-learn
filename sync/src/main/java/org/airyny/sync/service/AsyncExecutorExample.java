package org.airyny.sync.service;

import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.Async;

public class AsyncExecutorExample {

    private TaskExecutor taskExecutor;

    public void printMessage(){
        for (int i = 0; i<6; i++){
            taskExecutor.execute(new MessagePrinterTask("Message: "+i));
        }
    }

    @Async
    public void printMessage2(){
        for (int i = 0; i<6; i++){
            try{
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+ " " + "message:" +i);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }


    private class MessagePrinterTask implements Runnable{

        private String message;

        public MessagePrinterTask(String message){
            this.message = message;
        }
        @Override
        public void run() {
            try{
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+ " " + message);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public TaskExecutor getTaskExecutor() {
        return taskExecutor;
    }

    public void setTaskExecutor(TaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }
}

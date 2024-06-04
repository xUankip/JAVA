package com.multi.thread;

public class ThreadDemo extends Thread {
    private Thread thread;
    private String threadName;

    ThreadDemo(String name) {
        threadName = name;
        System.out.println("Create Thread" + threadName);
    }

    @Override
    public void run() {
        System.out.println("Running" + threadName);
        try {
            for (int i = 3; i > 0; i--) {
                System.out.println("Thread" + threadName + ":" + i);
            }
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
        System.out.println("Thread" + threadName + "exiting");
    }

    @Override
    public void start() {
        System.out.println("Starting :" + threadName);
        if (thread == null) {
            thread = new Thread(this, threadName);
            thread.start();
        }
    }
}

package com.multi.thread;

public class MainThread {
    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo("Thread 1 database");
        threadDemo.start();
        ThreadDemo threadDemo1 = new ThreadDemo("Thread 2 send-email");
        threadDemo1.start();
        System.out.println("stopped");
    }
}

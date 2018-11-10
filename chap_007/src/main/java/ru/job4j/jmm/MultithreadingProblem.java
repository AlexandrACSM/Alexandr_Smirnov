package ru.job4j.jmm;

public class MultithreadingProblem implements Runnable {

    private int count = 0;

    public void increment() {
        count++;
    }

    @Override
    public void run() {
        while (count <= 500) {
            increment();
            System.out.println(String.format("%s %s",this.count,Thread.currentThread().getName()));
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        MultithreadingProblem problem = new MultithreadingProblem();
        new Thread(problem).start();
        new Thread(problem).start();
    }
}

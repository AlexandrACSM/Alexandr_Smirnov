package ru.job4j.wait;

public class ProducerCustomer {
    private final Object lock = new Object();
    private boolean condition = true;

    public void doSomething() throws InterruptedException {
        synchronized (this.lock) {
            while (this.condition) {
                System.out.println(String.format("%s wait",Thread.currentThread().getId()));
                lock.wait();
            }
            System.out.println(String.format("%s userfull work", Thread.currentThread().getId()));
        }
    }

    public void changeBlock(final boolean enable) {
        synchronized (this.lock) {
            System.out.println(String.format("% enable", Thread.currentThread().getId()));
            this.condition = enable;
            this.lock.notify();
        }
    }

    public static void main(String[] args) {
        ProducerCustomer blockingWork = new ProducerCustomer();
        Thread producer = new Thread() {
            @Override
            public void run() {
                blockingWork.changeBlock(false);
            }
        };

        Thread customer = new Thread(){
            @Override
            public void run (){
                try{
                    blockingWork.doSomething();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        producer.start();
        customer.start();
    }
}

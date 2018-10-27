package ru.job4j.synchronizy.counter;

public class CounterThread extends  Thread {
    private Count counter;

    public CounterThread(Count counter){
        this.counter = counter;
    }

    @Override
    public void run(){
        counter.increment();
    }
}

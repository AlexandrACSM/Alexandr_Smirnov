package ru.job4j.synchronizy.counter;

public class Count {

    private static int count = 0;

    public int getCount() {
        return count;
    }

    public synchronized void increment() {
       this.count++;
    }

}

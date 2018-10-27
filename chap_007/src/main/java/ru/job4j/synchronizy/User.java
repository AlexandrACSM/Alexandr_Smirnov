package ru.job4j.synchronizy;

import net.jcip.annotations.ThreadSafe;
import ru.job4j.synchronizy.counter.Count;
import ru.job4j.synchronizy.counter.CounterThread;

@ThreadSafe
public class User {

    private int id;

    private int amount;

    public User( int amount) {
        this.id = setId();
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    private static synchronized int setId() {
        Count count = new Count();
        int id = count.getCount();
        count.increment();
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}

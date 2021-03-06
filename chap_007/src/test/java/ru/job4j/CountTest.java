package ru.job4j;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import ru.job4j.synchronizy.counter.Count;

public class CountTest {

    private class ThreadCount extends Thread{
        private final Count count;

        private ThreadCount(Count count) {
            this.count = count;
        }
        @Override
        public void run(){
            this.count.increment();
        }
    }
    @Test
    public void whenExecute2ThreadThen2()throws  InterruptedException{
        final Count count = new Count();

        Thread first = new ThreadCount(count);
        Thread second = new ThreadCount(count);

        first.start();
        second.start();
        first.join();
        second.join();

    }
}

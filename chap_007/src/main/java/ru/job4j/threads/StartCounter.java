package ru.job4j.threads;

/**
 * @author Aleksandr Smirnov.
 */
public class StartCounter {

    public static void main(String[] args) throws InterruptedException {
        CountSpace countSpace = new CountSpace(" 1 22 333 4444");
        CountWord countWord = new CountWord(" 1 22 333 4444 5");
        Thread thread = new Thread();
        new Thread(countSpace).start();
        new Thread(countWord).start();
        System.out.println("Начнем:");

        System.out.println("Конец");
    }
}

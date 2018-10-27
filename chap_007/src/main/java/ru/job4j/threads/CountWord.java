package ru.job4j.threads;

/**
 * @author Aleksandr Smirnov.
 */
public class CountWord implements Runnable {


    private String string;

    public CountWord(String string) {
        this.string = string;
    }

    public int getCountWord() {
        int count = 0;
        String s = string.trim();
        char[] chars = s.toCharArray();
        for (char chars1 : chars) {
            if (chars1 == ' ') {
                count++;
            }
        }
//        String[] strings = string.split(" ");
//        return strings.length;
        return ++count;
    }

    @Override
    public void run() {

        System.out.format("%s%s\n", "Кол-во слов - ", this.getCountWord());
    }
}

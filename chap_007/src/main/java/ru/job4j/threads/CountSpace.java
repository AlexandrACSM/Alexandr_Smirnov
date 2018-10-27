package ru.job4j.threads;

/**
 * @author Aleksandr Smirnov.
 */
public class CountSpace implements Runnable {
    private String string;

    public CountSpace(String string) {
        this.string = string;
    }

    public int getCountSpace() {
        int count = 0;
        String s = string.trim();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == ' ') {
                count++;
            }
        }
        return count;
//        String[] strings = string.split(" ");
//        return strings.length - 1;
    }

    @Override
    public void run() {
        System.out.format("%s%s\n", "Кол-во пробелов - ", this.getCountSpace());
    }

}

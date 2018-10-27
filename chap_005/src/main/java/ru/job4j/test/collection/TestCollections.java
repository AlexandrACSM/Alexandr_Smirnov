package ru.job4j.test.collection;

import java.util.*;

/**
 * @author Aleksandr Smirnov.
 */
public class TestCollections {
    /**
     * Время добавления элементов в LinkedList.
     */
    static long linkedListdAddTime;
    /**
     * Время добавления элементов в ArrayList.
     */
    static long arrayListAddTime;
    /**
     * Время добавления элементов в TreeSetList.
     */
    static long treeSetAddTime;
    /**
     *Время удаления элементов из LinkedList.
     */
    static long deleteLinkedListTime;
    /**
     *Время удаление элементов из ArrayList.
     */
    static long deleteArrayListTime;
    /**
     *Время удаления элементов из TreeSetList.
     */
    static long deleteTreeSetTime;

    public TestCollections() {
    }

    public static void main(String[] args) {
        TestCollections app = new TestCollections();
        int amount = (int) (Math.random() * 150) + 50;
        String[] strings = app.getStringArray();
        arrayListAddTime = app.add(new ArrayList<>(), strings);
        linkedListdAddTime = app.add(new LinkedList<>(), strings);
        treeSetAddTime = app.add(new TreeSet<>(), strings);
        deleteLinkedListTime = app.delete(new LinkedList<>(), strings, amount);
        deleteArrayListTime = app.delete(new ArrayList<>(), strings, amount);
        deleteTreeSetTime = app.delete(new TreeSet<>(), strings, amount);
        System.out.println(app.toString());
    }

    /**
     * Метод вычисляет время выполнения добавления строк в коллекцию.
     *
     * @param list    - коллеция.
     * @param strings - массив строк.
     * @return - время операции.
     */
    public long add(Collection<String> list, String[] strings) {
        int i = 0;
        long result = 0;
        long time = 0;
        while (i < strings.length) {
            time = time + result;
            String s = strings[i++];
            long start = System.nanoTime();
            list.add(s);
            long finish = System.nanoTime();
            result = (finish - start);
        }
        return time;
    }

    /**
     * Метод вычисляет время выполнения удаления n элементов из коллекции.
     *
     * @param list    - коллеция.
     * @param strings - массив строк.
     * @param amount  - кол-во удаляемых элементов.
     * @return - время операции.
     */
    public long delete(Collection<String> list, String[] strings, int amount) {
        int i = 0;
        long result = 0;
        long time = 0;
        list = addCollection(strings, list);
        while (i < amount) {
            time = time + result;
            String s = strings[i++];
            long start = System.nanoTime();
            list.remove(s);
            long finish = System.nanoTime();
            result = (finish - start);
        }
        return time;
    }

    /**
     * Метод создает коллекцию.
     *
     * @param strings - массив строк.
     * @param list    - коллекция.
     * @return - коллекция.
     */
    public Collection<String> addCollection(String[] strings, Collection<String> list) {
        for (int i = 0; i < strings.length; i++) {
            list.add(strings[i]);
        }
        return list;
    }

    /**
     * Метод получения массива строк.
     *
     * @return - массив строк.
     */
    public String[] getStringArray() {
        String symbols = "qwerty";
        StringBuilder randString = new StringBuilder();
        int addCount = (int) (Math.random() * 400) + 300;
        String[] strings = new String[addCount];
        for (int j = 0; j < addCount; j++) {
            randString.append(symbols.charAt((int) (Math.random() * symbols.length())));
            strings[j] = String.valueOf(randString);
        }
        return strings;
    }

    @Override
    public String toString() {
        return "Тест{\n" +
                "1. linkedListdAddTime=\t" + linkedListdAddTime + "\n" +
                "2. arrayListAddTime=\t" + arrayListAddTime + "\n" +
                "3. treeSetAddTime=  \t" + treeSetAddTime + "\n" +
                "1. deleteLinkedListTime=" + deleteLinkedListTime + "\n" +
                "2. deleteArrayListTime =" + deleteArrayListTime + "\n" +
                "3 .deleteTreeSetTime= \t" + deleteTreeSetTime + "\n" +
                '}';
    }
}

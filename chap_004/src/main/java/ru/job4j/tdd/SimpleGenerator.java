package ru.job4j.tdd;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Aleksandr Smirnov.
 */
public class SimpleGenerator {
    private String key;
    private String subject;
    Map<String, String> map;
    String string;

    public SimpleGenerator(String key, String subject, Map<String, String> map) {
        this.key = key;
        this.subject = subject;
        this.map = map;
    }

    public void get(Map<String, String> map, String s) {
        String[] strings = s.split(" ");

        for (int i = 0; i < strings.length; i++) {
            if (strings[i].contains("${")) {
                String b = strings[i].substring(2,strings[i].length()-1);
                System.out.println(b);
                strings[i] = map.get(b);
            }
        }
    }

    public static void main(String[] args) {
        SimpleGenerator simpleGenerator = new SimpleGenerator("name", "subject", new HashMap<>());
        simpleGenerator.map.put(simpleGenerator.key, simpleGenerator.subject);
        simpleGenerator.get(simpleGenerator.map, "tra ta ta ${name}");
    }

}

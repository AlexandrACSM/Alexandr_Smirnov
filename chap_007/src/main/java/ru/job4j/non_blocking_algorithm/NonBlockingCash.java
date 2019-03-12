package ru.job4j.non_blocking_algorithm;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;

public class NonBlockingCash {

    private final ConcurrentHashMap<Integer, Base> map;

    /**
     * Constructor
     */
    public NonBlockingCash() {
        this.map = new ConcurrentHashMap<>();
    }

    /**
     * Method checks version
     * @param value
     * @param base
     * @return
     */
    public boolean checkVersion(Integer value, Base base) {
        return base.getVersion() == value;
    }

    /**
     * Method adds base
     * @param key
     * @param base
     */
    public void add(Integer key, Base base) {
        this.map.put(key, base);
    }
    /**
     *Method deleting base
     * @param key
     */
    public void delete(Integer key) {
        this.map.remove(key);
    }

    /**
     * Method updates base
     * @param key
     * @param id
     */
    public void update(Integer key, int id) {

        int version = map.get(key).getVersion();

        this.map.computeIfPresent(key, new BiFunction<Integer, Base, Base>() {
            @Override
            public Base apply(Integer integer, Base base) {
                integer = version;
                base = map.get(key);
                if (checkVersion(id, base)) {
                    base.setId(id);
                    base.incrementVersion();
                } else {
                    throw new OptimisticException(" ");
                }
                return base;
            }
        });
    }
}

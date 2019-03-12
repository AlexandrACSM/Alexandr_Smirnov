package ru.job4j.non_blocking_algorithm;

public class Base {
    /**
     * Base id
     */
    private int id;
    /**
     * Base version
     */
    private volatile int version;

    /**
     *Id getter
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Id setter
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Version getter
     * @return version number
     */
    public int getVersion() {
        return version;
    }

    /**
     * Version setter
     * @param version
     */
    public void setVersion(int version) {
        this.version = version;
    }

    /**
     * Version increment
     */
    public void incrementVersion() {
        this.version++;
    }
}

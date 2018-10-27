package ru.job4j.start;

/**
 * Class
 *
 * @author Aleksandr Smirnov.
 * @vesion
 * @since 03.02.2017.
 */
public abstract class BaseAction implements UserAction {

    private String name;

    public BaseAction(String name) {
        this.name = name;
    }

    @Override
    public String info() {
        return String.format("%s, %s", this.key(), this.name);
    }
}


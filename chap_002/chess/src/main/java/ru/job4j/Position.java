package ru.job4j;

/**
 * @author Aleksandr Smirnov.
 * @version 1
 * @since 19.02.2017.
 */
public class Position {
    /**
     * Кординаты.
     */
    private Position position;
    /**
     * х кордината.
     */
    private int x;
    /**
     * у кордината.
     */
    private int y;

    /**
     * Конструктор класса.
     * @param x - кордината.
     * @param y - кордината.
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

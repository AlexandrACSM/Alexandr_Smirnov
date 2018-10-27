package ru.job4j;

import ru.job4j.figure.Figure;

/**
 * Класс игровой доски.
 * @author Aleksandr Smirnov.
 * @version 1
 * @since 19.02.2017.
 */
public class Board {
    /**
     * Поле размера доски.
     */
    private static final int BOARD_SIZE = 8;
    /**
     * Поле хранящее игровое поле.
     */
    private Figure[][] figures;

    /**
     * Конструктор класса.
     */
    public Board() {
        this.figures = new Figure[BOARD_SIZE][BOARD_SIZE];
    }

    /**
     * Метод добавляющий фигуру на игривое поле.
     * @param figure - фигуру которую хотим добавить
     */
    public void addFigure(Figure figure) {
        this.figures[figure.getPosition().getX()][figure.getPosition().getY()] = figure;
    }

    /**
     * Метод удаляет фигуру.
     * @param position - позиция фигуры для удаления.
     */
    public void deleteFigure(Position position) {
        figures[position.getX()][position.getY()] = null;
    }

    /**
     * Метод меняет кординаты фигуры.
     * @param figure - фигура.
     * @param position - кординаты на которые хотим переставить фигуру.
     */
    public void editPositionFigure(Figure figure, Position position) {
        figures[position.getX()][position.getY()] = figure;
        deleteFigure(figure.getPosition());
        figures[position.getX()][position.getY()].setPosition(position);
    }

    /**
     * Метод проверяет возмоность хода по вертикали и горизонтали.
     * @param figure - фигура которой хотим походить.
     * @param position - кординаты на которые хотим походить.
     * @return - false - путь занят , true - путь свободен.
     */
    public boolean pathOnFileOnChessboardAndHorizontal(Figure figure, Position position) {
        if (figure.getPosition().getX() != position.getX() &&
                position.getX() < figures.length && position.getX() >= 0) {
            int j = position.getY();
            if (figure.getPosition().getX() < position.getX()) {
                for (int i = figure.getPosition().getX() + 1; i <= position.getX(); i++) {
                    if (figures[i][j] != null) {
                        return false;
                    }
                }
                return true;
            } else if (figure.getPosition().getX() > position.getX()) {
                for (int i = figure.getPosition().getX(); i <= position.getX(); i--) {
                    if (figures[i][j] != null) {
                        return false;
                    }
                }
                return true;
            }
        }
        if (figure.getPosition().getY() != position.getY() &&
                position.getY() < figures.length && position.getY() >= 0) {
            int j = position.getX();
            if (figure.getPosition().getY() < position.getY()) {
                for (int i = figure.getPosition().getY() + 1; i <= position.getY(); i++) {
                    if (figures[i][j] != null) {
                        return false;
                    }
                }
                return true;
            } else if (figure.getPosition().getY() > position.getY()) {
                for (int i = figure.getPosition().getY(); i <= position.getY(); i--) {
                    if (figures[i][j] != null) {
                        return false;
                    }
                }
                return true;
            }
        }
        return true;
    }
    public Figure getFigure(Position position) {
        return figures[position.getX()][position.getY()];
    }
}
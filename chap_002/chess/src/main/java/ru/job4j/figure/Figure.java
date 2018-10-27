package ru.job4j.figure;

import ru.job4j.ColorFigure;
import ru.job4j.FigureType;
import ru.job4j.Position;

/**
 * @author Aleksandr Smirnov.
 */
public abstract class Figure {
    /**
     * Coordinates.
     * Кординаты.
     */
    private Position position;
    /**
     * The color of figure.
     * Цвет фигуры.
     */
    private final ColorFigure colorFigure;
    /**
     * The Type of the figure.
     * Тип фигуры.
     */
    private final FigureType figureType;

    /**
     * The class constructor.
     * Конструктор класса.
     * @param position - The position of the figure (позиция фигуры).
     * @param colorFigure - the color of the figure (цвет фигуры).
     * @param figureType - the type of the figure тип фигуры.
     */
    public Figure(Position position, ColorFigure colorFigure, FigureType figureType) {
        this.position = position;
        this.colorFigure = colorFigure;
        this.figureType = figureType;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public ColorFigure getColorFigure() {
        return colorFigure;
    }

    public FigureType getFigureType() {
        return figureType;
    }

    public abstract boolean move(Position position);
}

package ru.job4j.figure;

import ru.job4j.ColorFigure;
import ru.job4j.FigureType;
import ru.job4j.Position;

/** "Bishop" figure class.
 * Класс фигуры Bishop.
 * @author Aleksandr Smirnov.
 */
public class Bishop extends Figure {
    /**The possibility of a pass
     * Возможность хода.
     */
    private boolean moveTo;

    /**class constructor.
     * Конструктор класса.
     */
    public Bishop(Position position, ColorFigure colorFigure, FigureType figureType) {
        super(position, colorFigure, FigureType.BISHOP);
    }

    /**
     * The method checks fidelity pass for the figure.
     * Метод проверяет правильность хода для данной фигуры.
     *
     * @param position
     * @return
     */
    @Override
    public boolean move(Position position) {
        if (position.getY() == getPosition().getY() || position.getX() == getPosition().getX()) {
            return moveTo = true;
        }
        return moveTo = false;
    }
}

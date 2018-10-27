package ru.job4j.input;

import ru.job4j.Position;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Aleksandr Smirnov.
 * @version 1
 * @since 19.02.2017.
 */
public class PathInputControllerConsole implements PathInputController {
    /**
     * Ввод кординат.
     * @return position - возвращаем кординаты.
     */
    @Override
    public Position enterPosition() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int[] numArr = Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
        Position position = new Position(numArr[0],numArr[1]);
        return position;
    }
}
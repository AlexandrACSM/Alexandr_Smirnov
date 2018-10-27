package ru.job4j.start;

/**
 * Class
 *
 * @author Aleksandr Smirnov.
 * @vesion
 * @since 30.01.2017.
 */
public class StubInput implements Input {
    private String[] answers;
    private int position = 0;

    public StubInput(String[] answers){
    this.answers = answers;
    }
    @Override
    public String ask(String question) {
        return answers[position++];
    }

    @Override
    public int ask(String question, int[] range) {
        return -1;
    }
}

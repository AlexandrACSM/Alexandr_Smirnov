package ru.job4j.start;

import ru.job4j.models.*;


/**
 * @author Aleksandr Smirnov.
 * @version 1.
 * @since 25.01.2017.
 */
public class StartUI {
    private Input input;

    public StartUI(Input input) {
        this.input = input;
    }

    public void init() {
        Tracker tracker = new Tracker();
        MenuTracker menu = new MenuTracker(this.input, tracker);
        menu.fillActions();
        UserAction deleteAction = new UserAction() {
            @Override
            public int key() {
                return 6;
            }


            @Override
            public void execute(Input input, Tracker tracker) {
                String id = input.ask("Please enter the task's id: ");
                Item item = new Item(id);
                tracker.deleteItem(item);
            }

            @Override
            public String info() {
                return "6. Delete item";
            }
        };
        menu.addAction(deleteAction);
        do {
            menu.show();
            menu.select(input.ask("Select: ", menu.getRangeArray()));
        } while (!"y".equals(input.ask("Exit?(y)")));
    }

    public static void main(String[] args) {
        Input input = new ValidateInput();
        new StartUI(input).init();
    }
}

package ru.job4j.start;

import ru.job4j.models.*;

import java.util.ArrayList;
import java.util.List;

/*
 * @author Aleksandr Smirnov.
 * @version 1.
 * @since 01.02.2017.
 */


public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[7];
//    private List<BaseAction> actions = new ArrayList<>();
    private int position = 0;

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillActions() {
        if (actions != null) {
            this.actions[position++] = new AddItem("Add the new item.");
            this.actions[position++] = new ShowItems("Show all item.");
            this.actions[position++] = new EditItem("Edit the new item.");
            this.actions[position++] = new FindItemById("Find item by id.");
            this.actions[position++] = new FindItemByName("Find item by name.");
            this.actions[position++] = new EditComment("Edit comment.");
        }
    }

    public void addAction(UserAction action) {
        this.actions[position++] = action;
    }

    public int[] getRangeArray() {
        int[] array = new int[actions.length];
        for (int i = 0; i < actions.length; i++) {
            array[i] = actions[i].key();
        }
        return array;
    }

    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    private class AddItem extends BaseAction {

        public AddItem(String name) {
            super(name);
        }

        @Override
        public int key() {
            return 0;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please enter the task's name: ");
            String desc = input.ask("Please enter the task's desc: ");
            tracker.addItem(new Task(name, desc));
        }
    }

    private static class ShowItems extends BaseAction {

        public ShowItems(String name) {
            super(name);
        }

        @Override
        public int key() {
            return 1;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.getAll()) {
                 System.out.println( item.toString());
                }
            }
    }

    class EditItem extends BaseAction {

        public EditItem(String name) {
            super(name);
        }

        @Override
        public int key() {
            return 2;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please enter the task's id: ");
            String name = input.ask("Please enter the task's name: ");
            String desc = input.ask("Please enter the task's desc: ");
            Task task = new Task(name, desc);
            task.setId(id);
            tracker.edit(task);
        }
    }

    class FindItemById extends BaseAction {

        public FindItemById(String name) {
            super(name);
        }

        @Override
        public int key() {
            return 3;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please enter the task's id: ");
            Item item;
            item = tracker.findById(id);
            if (item != null) {
                System.out.printf(item.toString());
            } else {
                System.out.println("File isn't find. Please enter correct name.");
            }
        }
    }

    class FindItemByName extends BaseAction {

        public FindItemByName(String name) {
            super(name);
        }

        @Override
        public int key() {
            return 4;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please enter the task's name: ");
            Item item;
            item = tracker.findByName(name);
            if (item != null) {
                System.out.printf(item.toString());
            } else {
                System.out.println("File isn't find. Please enter correct name.");
            }
        }
    }

    class EditComment extends BaseAction {

        public EditComment(String name) {
            super(name);
        }

        @Override
        public int key() {
            return 5;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please enter the task's id: ");
            String comment = input.ask("Please enter comment");
            tracker.createComment(id, comment);
        }
    }
}
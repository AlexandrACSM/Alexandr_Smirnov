//package ru.job4j;
//
//import org.junit.Test;
//import ru.job4j.models.Item;
//import ru.job4j.start.Tracker;
//
//import java.util.List;
//
//import static junit.framework.TestCase.assertTrue;
//import static org.hamcrest.core.Is.is;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotEquals;
//import static org.junit.Assert.assertThat;
//
//
///**
// * Класс тестирующий методы класса Tracker.
// *
// * @author Aleksandr Smirnov.
// * @version 1.
// * @since 04.02.2017.
// */
//public class TrackerTest {
//    /**
//     * Тест добавления объекта.
//     */
//    @Test
//    public void addItemTest() {
//        Tracker tracker = new Tracker();
//        Item item = new Item("item", "descr");
//        Item result = tracker.addItem(item);
//        assertThat(item, is(result));
//    }
//
//    /**
//     * Тест изменения объекта.
//     */
//    @Test
//    public void editTest() {
//        final String id = "1";
//        Item item = new Item("item", "d");
//        Item task = new Item("TestN", "TestD");
//        Tracker tracker = new Tracker();
//        tracker.addItem(item).setId(id);
//        task.setId(id);
//        tracker.edit(task);
//        tracker.getAll();
//        final String expectedResultN = "TestN";
//        final String expectedResultD = "TestD";
//        assertEquals(expectedResultN, tracker.findById(id).getName());
//        assertEquals(expectedResultD, tracker.findById(id).getDescription());
//        System.out.println(String.format("Test edit item"));
//        System.out.println(String.format("Expected name %s, Actual name %s", expectedResultN,
//                tracker.findById(id).getName()));
//        System.out.println(String.format("Expected desc %s, Actual desc %s", expectedResultD,
//                tracker.findById(id).getDescription()));
//    }
//
//    /**
//     * Тест поиска объекта по полю id.
//     */
//    @Test
//    public void findByIdTest() {
//        Item item = new Item("name", "desc");
//        Item item11 = new Item("name1", "desc1");
//        Tracker tracker = new Tracker();
//        tracker.addItem(item);
//        tracker.addItem(item11);
//        Item result = tracker.findById(item.getId());
//        assertThat(item, is(result));
//    }
//
//    /**
//     * Тест поиска объекта по полю name.
//     */
//    @Test
//    public void findByNameTest() {
//        Item item = new Item("name", "desc");
//        Item item11 = new Item("name1", "desc1");
//        Tracker tracker = new Tracker();
//        tracker.addItem(item);
//        tracker.addItem(item11);
//        Item result = tracker.findByName(item.getName());
//        assertThat(item, is(result));
//    }
//
//    /**
//     * Метод тестирует добавление комментрариев.
//     */
//    @Test
//    public void createCommentTest() {
//        Item item = new Item("name", "desc");
//        Tracker tracker = new Tracker();
//        tracker.addItem(item);
//        tracker.createComment(item.getId(), "test");
//        String result = "test";
//        assertThat(item.getComment(), is(result));
//
//    }
//
//    /**
//     * Метод тестирует получение всех элементов.
//     */
//    @Test
//    public void getAllTest() {
//        Item item = new Item("name", "desc");
//        Item item1 = new Item("name1", "desc1");
//        Tracker tracker = new Tracker();
//        tracker.addItem(item);
//        tracker.addItem(item1);
//        List<Item> list= tracker.getAll();
//        boolean result = items.length > 0;
//        assertTrue(result);
//    }
//
//    /**
//     * Метод тестирует удаление элемента.
//     */
//    @Test
//    public void deleteByIdTest() {
//        Item[] items;
//        Item item = new Item("name", "desc");
//        Item item1 = new Item("name1", "desc1");
//        Tracker tracker = new Tracker();
//        tracker.addItem(item);
//        tracker.addItem(item1);
//        item.setId("12");
//        item1.setId("14");
//        String actualId = "12";
//        tracker.deleteItem(tracker.findById("12"));
//        items = tracker.getAll();
//        for (Item item2 : items) {
//            assertNotEquals(item2.getId(), actualId);
//        }
//    }
//}
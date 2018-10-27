package ru.job4j;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.services.SortUser;
import ru.job4j.services.User;
import ru.job4j.services.UserConvert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Aleksandr Smirnov.
 */
public class UserConvertTest {
    /**
     * Экземпляр класса SortUser/
     */
   private final SortUser sortUser = new SortUser();
    /**
     * Коллекция пользователей.
     */
   private final List<User> list = new ArrayList<>();
    /**
     * Создаем пользователя.
     */
   private final User user = new User(0, "Вася", "Москва", (byte) 4);
    /**
     * Создаем пользователя.
     */
   private final User user2 = new User(1, "Евангелина", "СПб", (byte) 6);
    /**
     * Создаем пользователя.
     */
   private final User user3 = new User(2, "Мурат", "ЕКб", (byte) 7);

    /**
     * Тест переноса данных из List<User> в HashMap<Integer,User>.
     * В качестве ключа используется userId.
     */
    @Test
    public void process() {
        final UserConvert userConvert = new UserConvert();
        final List<User> lis = new LinkedList<>();
        lis.add(user);
        lis.add(user2);
        lis.add(user3);
        HashMap<Integer, User> actualMap = userConvert.process(lis);
        HashMap<Integer, User> expectedMap = new HashMap<>();
        expectedMap.put(0, user);
        expectedMap.put(1, user3);
        expectedMap.put(2, user2);
        assertThat(expectedMap, is(actualMap));
    }

    /**
     * Сортировка по возрасту.
     */
    @Test
    public void sortByAge(){
        list.add(user2);
        list.add(user3);
        list.add(user);
        sortUser.sortByAge(list);
        Assert.assertTrue(list.get(0).getAge()==user.getAge());
        Assert.assertTrue(list.get(2).getAge()==user3.getAge());
    }

    /**
     * Сортировка по длине имени.
     */
    @Test
    public void sortByNameLength(){
        list.add(user3);
        list.add(user2);
        list.add(user);
        sortUser.sortByNameLength(list);
        Assert.assertTrue(list.get(0).getName().length()<list.get(1).getName().length());
        Assert.assertTrue(list.get(1).getName().length()<list.get(2).getName().length());
    }
}

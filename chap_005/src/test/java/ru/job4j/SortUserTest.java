package ru.job4j;

import org.junit.Test;
import ru.job4j.services.SortUser;
import ru.job4j.services.User;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Aleksandr Smirnov.
 */
public class SortUserTest {
    /**
     * Создаем пользователя.
     */
    private final User user2 = new User(2, "55555", "c", (byte) 11);
    /**
     * Создаем пользователя.
     */
    private final User user3 = new User(3, "333", "f", (byte) 12);
    /**
     * Создаем пользователя.
     */
    private final User user = new User(1, "4444", "b", (byte) 10);
    /**
     * Создаем коллекцию пользователей.
     */
    private final List<User> users = new LinkedList<>();

    /**
     * Тест сортировки по возрасту.
     */
    @Test
    public void sortByAge() {
        users.add(user3);
        users.add(user);
        users.add(user2);
        SortUser sortUser = new SortUser();
        Set<User> actualList = sortUser.sortByAge(users);
        Set<User> expectedList = new TreeSet<>();
        expectedList.add(user);
        expectedList.add(user2);
        expectedList.add(user3);
        assertThat(expectedList, is(actualList));
    }

    /**
     * Тест сортировки по длине имени.
     */
    @Test
    public void sortByNameLength() {
        users.add(user);
        users.add(user3);
        users.add(user2);
        SortUser sortUser = new SortUser();
        List<User> actualList = sortUser.sortByNameLength(users);
        List<User> expectedList = new ArrayList<>();
        expectedList.add(user3);
        expectedList.add(user);
        expectedList.add(user2);
        assertThat(expectedList, is(actualList));

    }

    /**
     * Тест сортировки по хеш-коду.
     */
    @Test
    public void sortHash() {
        users.add(user);
        users.add(user3);
        users.add(user2);
        SortUser sortUser = new SortUser();
        List<User> actualList = sortUser.sortHash(users);
        List<User> expectedList = new ArrayList<>();
        expectedList.add(user3);
        expectedList.add(user);
        expectedList.add(user2);
        assertThat(expectedList, is(actualList));
    }
}

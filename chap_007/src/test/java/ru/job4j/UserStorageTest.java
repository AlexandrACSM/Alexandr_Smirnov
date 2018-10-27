package ru.job4j;

import org.junit.Test;
import ru.job4j.synchronizy.User;
import ru.job4j.synchronizy.UserStorage;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class UserStorageTest {

    @Test
    public void addOfUserTest() {
        UserStorage userStorage = new UserStorage();
        userStorage.addOfUser(new User(3));
        userStorage.addOfUser(new User(60));
        assertTrue(!userStorage.getUsers().isEmpty());

    }

    @Test
    public void deleteOfUserTest() {
        User user = new User(3);
        User user1 = new User(60);
        UserStorage userStorage = new UserStorage();
        userStorage.addOfUser(user);
        userStorage.addOfUser(user1);
        userStorage.deleteOfUser(user);
        assertTrue(!userStorage.getUsers().contains(user));
    }

    @Test
    public void transferTest() {
        UserStorage userStorage = new UserStorage();
        User user = new User(100);
        User user1 = new User(60);
        int expectAmountUser1 = 160;
        int expectAmountUser = 0;
        userStorage.addOfUser(user);
        userStorage.addOfUser(user1);
        userStorage.transfer(user.getId(),user1.getId(),100);
        assertTrue(userStorage.getUsers().get(user1.getId()).getAmount()==expectAmountUser1);
    assertTrue(userStorage.getUsers().get(user.getId()).getAmount()==expectAmountUser);
    }
}

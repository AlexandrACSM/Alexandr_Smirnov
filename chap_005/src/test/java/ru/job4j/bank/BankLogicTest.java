package ru.job4j.bank;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author Aleksandr Smirnov.
 */
public class BankLogicTest {
    /**
     * Экземпляр класса BankLogic.
     */
    private final BankLogic bankLogic = new BankLogic(new HashMap<>());
    /**
     * Коллекция пользователей банка.
     */
    private final Map<UserOfBank, List<Accounts>> userState = bankLogic.getUserState();
    /**
     * Создаем пользователя.
     */
    private final UserOfBank userOfBank = new UserOfBank("Vasya", 12345);
    /**
     * Создаем пользователя.
     */
    private final UserOfBank userOfBank2 = new UserOfBank("Vasya", 123456);
    /**
     * Создаем счет.
     */
    private final Account account = new Account(300, 1234555);
    /**
     * Создаем счет.
     */
    private final Account account2 = new Account(400, 12345553);
    /**
     * Создаем счет.
     */
    private final Account account3 = new Account(500, 12345554);
    /**
     * Создаем счет.
     */
    private final Account account4 = new Account(600, 12345556);

    /**
     * Тест добавления пользователя.
     */
    @Test
    public void addUser() {
        bankLogic.addUser(userOfBank);
        bankLogic.addUser(userOfBank2);
        Assert.assertTrue(userState.size() > 0);
    }

    /**
     * Тест удаления пользователя.
     */
    @Test
    public void deleteUser() {
        bankLogic.addUser(userOfBank);
        bankLogic.deleteUser(userOfBank);
        Assert.assertTrue(userState.size() == 0);

    }

    /**
     * Тест добавления счета пользователю.
     */
    @Test
    public void addAccountToUser() {
        bankLogic.addUser(userOfBank);
        bankLogic.addAccountToUser(userOfBank, account);
        bankLogic.addAccountToUser(userOfBank, account3);
        bankLogic.addAccountToUser(userOfBank, account4);
        Assert.assertTrue(userState.size() > 0);
    }

    /**
     * Тест удаления счета пользователя.
     */
    @Test
    public void deleteAccountFromUser() {
        bankLogic.addUser(userOfBank);
        bankLogic.addAccountToUser(userOfBank, account);
        bankLogic.addAccountToUser(userOfBank, account3);
        int size = userState.get(userOfBank).size();
        bankLogic.deleteAccountFromUser(userOfBank, account);
        Assert.assertTrue(size > userState.get(userOfBank).size());
    }

    /**
     * Тест получения всех счетов пользователя.
     */
    @Test
    public void getUserAccounts() {
        bankLogic.addUser(userOfBank);
        bankLogic.addAccountToUser(userOfBank, account);
        bankLogic.addAccountToUser(userOfBank, account2);
        List<Accounts> listExpected = bankLogic.getUserAccounts(userOfBank);
        List<Accounts> list = new ArrayList<>();
        list.add(account);
        list.add(account2);
        Assert.assertTrue(list.equals(listExpected));
    }

    /**
     * Тест перевода средст.
     */
    @Test
    public void transferMoney() {
        bankLogic.addUser(userOfBank);
        bankLogic.addUser(userOfBank2);
        bankLogic.addAccountToUser(userOfBank, account);
        bankLogic.addAccountToUser(userOfBank2, account2);
        boolean result = bankLogic.transferMoney(userOfBank, account, userOfBank2, account2, 20);
        Assert.assertTrue(result);
    }
}
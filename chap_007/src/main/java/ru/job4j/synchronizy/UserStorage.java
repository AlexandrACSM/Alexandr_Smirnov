package ru.job4j.synchronizy;

import net.jcip.annotations.ThreadSafe;


import java.util.ArrayList;

@ThreadSafe
public class UserStorage {
    /*
    * Array for store.
    * */
    private ArrayList<User> users;

    /*
    * Constructor.
    * */
    public UserStorage() {
        this.users = new ArrayList<>();
    }

    /*
    * Add user to storage.
    * */
    public synchronized boolean addOfUser(User user) {
        if (this.users.contains(user)) {
            return false;
        }
        this.users.add(user);
        return true;
    }

    /**
     * Delete of user from list.
     * @return
     */
    public synchronized boolean deleteOfUser(User user) {
        boolean status = false;
        if (this.users.contains(user)) {
            status = this.users.remove(user);
            return status;
        } else
            return status;
    }

    /**
     * Transfer of amount beetween users.
     * @param userIdFrom
     * @param userIdTo
     * @param amount
     * @return
     */
    public synchronized boolean transfer(int userIdFrom, int userIdTo, int amount) {
        if (checkAmount(userIdFrom, amount)) {
            users.get(userIdFrom).setAmount(users.get(userIdFrom).getAmount() - amount);
            users.get(userIdTo).setAmount(users.get(userIdTo).getAmount() + amount);
            return true;
        }
        return false;
    }

    /**
     * Check of user's amount.
     * @param userId
     * @param amount
     * @return
     */
    private synchronized boolean checkAmount(int userId, int amount) {
        if (users.get(userId).getAmount() - amount >= 0) {
            return true;
        }
        return false;
    }

    public ArrayList<User> getUsers() {
        return users;
    }
}

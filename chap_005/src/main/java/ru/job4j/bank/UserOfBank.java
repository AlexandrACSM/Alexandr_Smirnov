package ru.job4j.bank;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aleksandr Smirnov.
 */
public class UserOfBank {
    /**
     * Имя пользователя.
     */
    private String name;
    /**
     * Паспортные данные пользователя.
     */
    private int passport;

    public UserOfBank(String name, int passport) {
        this.name = name;
        this.passport = passport;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassport() {
        return passport;
    }

    public void setPassport(int passport) {
        this.passport = passport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserOfBank)) return false;

        UserOfBank that = (UserOfBank) o;

        if (passport != that.passport) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + passport;
        return result;
    }

    @Override
    public String toString() {
        return "UserOfBank{" +
                "name='" + name + '\'' +
                ", passport=" + passport + "\n";
    }
}

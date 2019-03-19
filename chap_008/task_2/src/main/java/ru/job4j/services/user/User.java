package ru.job4j.services.user;

import java.sql.Timestamp;

/**
 * @author Aleksandr Smirnov.
 */
public class User {
//    Создать модель User c полями name, login, email, createDate.
    private Long userId;
    private String name;
    private String login;
    private String email;
    private Timestamp createDate;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}

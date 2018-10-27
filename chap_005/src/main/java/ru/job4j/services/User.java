package ru.job4j.services;


/**
 * @author Aleksandr Smirnov.
 */
public class User implements Comparable<User> {
    private int id;
    private String name;
    private String city;
    private byte age;

    public User(int id, String name, String city, byte age) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.age = age;
    }


    public int generateUserId() {
        return id++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (id != user.id) return false;
        return name.equals(user.name);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = id++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    @Override
    public int compareTo(User user) {
        if (this.age > user.getAge()) {
            return 1;
        } else if (this.age < user.getAge()) {
            return -1;
        }
        return 0;
    }
}
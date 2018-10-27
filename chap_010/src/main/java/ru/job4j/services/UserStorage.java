package ru.job4j.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.job4j.models.User;


/**
 * @author Aleksandr Smirnov.
 */
public class UserStorage {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        User user = new User();
        user.setLogin("test");
        session.save(user);
//        System.out.println(session.createQuery("from User").list());
session.getTransaction().commit();
session.close();
factory.close();
    }
}

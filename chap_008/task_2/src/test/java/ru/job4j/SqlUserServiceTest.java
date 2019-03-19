package ru.job4j;


import org.junit.Test;
import ru.job4j.services.user.SqlUserServices;
import ru.job4j.services.user.User;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Aleksandr Smirnov.
 */
public class SqlUserServiceTest  {

//    @Test
//    public void createUser() {
//        User user = createNewUser();
//        User dbUser = getUserService().getUser(user.getEmail(), user.getPassword());
//        assertNotNull(dbUser);
//        assertEquals(user.getId(), dbUser.getId());
//        assertEquals(user.getFirstName(), dbUser.getFirstName());
//        assertEquals(user.getLastName(), dbUser.getLastName());
//        assertEquals(user.getEmail(), dbUser.getEmail());
//        assertEquals(user.getPassword(), dbUser.getPassword());
//        assertEquals(UserState.CUSTOMER, dbUser.getState());
//    }
//
//
//    private User createNewUser() {
//        User user = new User();
//        user.setName("Vasya");
//        user.setLogin("Petrov");
//        user.setEmail("Petr@email.ru");
//        SqlUserServices sqlUserServices = new SqlUserServices();
//        boolean result = getUserService().createUser(user);
//        assertTrue(result);
//        assertNotNull(user.getId());
//        return user;
//    }
}

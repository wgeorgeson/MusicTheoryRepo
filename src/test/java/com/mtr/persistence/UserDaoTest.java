package com.mtr.persistence;

import com.mtr.entity.User;
import com.mtr.entity.UserScale;
import com.mtr.test.util.Database;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type UserDao test class
 */
class UserDaoTest {

    UserDao dao;

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

        dao = new UserDao();
    }

    /**
     *  Verifies that getAllUsers() returns the
     *  correct number of overall users
     */
    @Test
    void getAllUsersSuccess() {
        List<User> users = dao.getAllUsers();
        // We want to know the number of users that should be returned
        // Double-click on test_MusicTheoryRepo->tables->users in Database pane to view the no. of users in user table
        assertEquals(3, users.size());
    }

    /**
     * Verifies that getUsersByLastName() returns the correct
     * number of users with a commonality in their last name
     */
    @Test
    void getUsersByLastNameSuccess() {
        List<User> users = dao.getUsersByLastName("p");  // users with "p" in their last name
        assertEquals( 2, users.size());
    }

    /**
     * Verifies that getUserById() is returning the
     * correct user
     */
    @Test
    void getUserByIdSuccess() {
        User retrievedUser = dao.getUserById(2);
        assertNotNull(retrievedUser);
        assertEquals("Eric", retrievedUser.getFirstName());
        assertEquals("Clapton", retrievedUser.getLastName());
        assertEquals("eclapton", retrievedUser.getUserName());
    }

    /**
     * Verify successful insert of a user
     */
    @Test
    void insertSuccess() {
        User newUser = new User("Ace", "Frehley", "aceFrehley@kissband.com", "acesWild","secret4");
        int id = dao.insert(newUser);
        assertNotEquals(0,id);
        User insertedUser = dao.getUserById(id);
        assertEquals("Ace", insertedUser.getFirstName());
        // Could continue comparing all values, but
        // it may make sense to use .equals()
        // TODO review .equals recommendations http://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html#mapping-model-pojo-equalshashcode
    }

    /**
     *  Verify new user has been added to users table
     *  Verify user's new scale has been added to User class' userScales Set
     */
    @Test
    void insertWithOrderSuccess() {
        User newUser = new User("John", "Mayer", "jmguitarman@gmail.com", "johnnyM", "secret5");

        String scaleName = "F Diatonic";
        String scaleData = "F Gb G Ab A Bb B C Db E F";
        UserScale userScale = new UserScale(scaleName, scaleData, newUser);

        newUser.addUserScale(userScale);

        int id = dao.insert(newUser);
        assertNotEquals(0,id);
        User insertedUser = dao.getUserById(id);
        assertEquals("John", insertedUser.getFirstName());
        assertEquals(1, insertedUser.getUserScales().size());
        // Could continue comparing all values, but
        // it may make sense to use .equals()
        // TODO review .equals recommendations http://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html#mapping-model-pojo-equalshashcode
    }


    /**
     * Verify successful delete of user
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getUserById(1));
        assertNull(dao.getUserById(1));
    }

}
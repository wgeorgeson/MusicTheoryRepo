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
    /**
     * Sets up testing by this test class by deleting and rewriting
     * to the DB.  Instantiates a UserDao object.
     */
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
        assertEquals(4, users.size());
    }

    /**
     * Verifies that getUsersByLastName() returns the correct
     * number of users with a commonality in their last name
     */
    @Test
    void getUsersByLastNameSuccess() {
        List<User> users = dao.getUsersByLastName("l");  // users with "p" in their last name
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
     * Verifies that the correct User is returned by username
     */
    @Test
    void getUserScalesByUsernameSuccess() {
        UserDao userDao = new UserDao();
        User retrievedUser = userDao.getUserById(1);
        String userName = retrievedUser.getUserName();

        User user = userDao.getUserByUserName(userName);
        assertEquals( userName, user.getUserName());
    }

    /**
     * Verify successful update of a User
     */
    @Test
    void updateSuccess() {
        String newFirstName = "David";
        User userToUpdate = dao.getUserById(1);
        userToUpdate.setFirstName(newFirstName);
        dao.saveOrUpdate(userToUpdate);
        User userAfterUpdate = dao.getUserById(1);
        assertEquals(newFirstName, userAfterUpdate.getFirstName());
    }


    /**
     * Verify successful insert of a user
     */
    @Test
    void insertSuccess() {
        // using personal email account to retrieve verification code that we have to send to AWS Cognito to verify new user
        User newUser = new User("Ace", "Frehley", "wgeorgeson@madisoncollege.edu", "acesWild","secret1");
        int id = dao.insert(newUser);
        assertNotEquals(0,id);
        User insertedUser = dao.getUserById(id);
        assertEquals("Ace", insertedUser.getFirstName());
    }

    /**
     *  Verify new user has been added to users table
     *  Verify user's new scale has been added to User class' userScales Set
     */
    @Test
    void insertWithScaleSuccess() {
        // using personal email account to retrieve verification code that we have to send to AWS Cognito to verify new user
        User newUser = new User("John", "Mayer", "wgeorgeson@madisoncollege.edu", "johnnyM", "secret1");

        String scaleName = "F Diatonic";
        String scaleData = "F Gb G Ab A Bb B C Db E F";
        UserScale userScale = new UserScale(scaleName, scaleData, newUser);

        newUser.addUserScale(userScale);

        int id = dao.insert(newUser);
        assertNotEquals(0,id);
        User insertedUser = dao.getUserById(id);
        assertEquals("John", insertedUser.getFirstName());
        assertEquals(1, insertedUser.getUserScales().size());
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
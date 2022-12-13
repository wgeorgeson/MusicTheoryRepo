package com.mtr.persistence;

import com.mtr.entity.User;
import com.mtr.entity.UserScale;
import com.mtr.test.util.Database;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test class for userScaleDao class
 */
class UserScaleDaoTest {

    UserScaleDao userScaleDao;

    /**
     * Run set up tasks before each test:
     * 1. execute sql which deletes everything from the userScales table and inserts records
     * 2. Create any objects needed in the tests
     */
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

        userScaleDao = new UserScaleDao();
    }

    /**
     * Verifies all userScales are returned
     */
    @Test
    void getAllUserScalesSuccess() {
        List<UserScale> userScales = userScaleDao.getAllUserScales();
        // We want to know the number of userScales that should be returned
        // Double-click on test_MusicTheoryRepo->tables->userScaless in Database pane to view the no. of userScales in userScales table
        assertEquals(15, userScales.size());
    }

    /**
     * Verifies all userScales with a specific name
     * or commonality are returned
     */
    @Test
    void getUserScalesByNameSuccess() {
        List<UserScale> userScales = userScaleDao.getUserScalesByName("Persian");
        assertEquals( 3, userScales.size());
    }

    /**
     * Verifies that the userScales with the specified username are returned
     */
    @Test
    void getUserScalesByUsernameSuccess() {
        UserDao userDao = new UserDao();
        User user = userDao.getUserById(1);
        String userName = user.getUserName();
        List<UserScale> userScales = userScaleDao.getUserScalesByUsername(userName);
        assertEquals( 4, userScales.size());
    }

    /**
     * Verifies that the userScale with a specific id is returned
     */
    @Test
    void getUserScaleByIdSuccess() {
        UserScale retrievedUserScale = userScaleDao.getUserScaleById(9);
        assertNotNull(retrievedUserScale);
        assertEquals("B♭ Diatonic", retrievedUserScale.getScaleName());
        assertEquals("B♭ C D E♭ F G A B♭", retrievedUserScale.getScaleData());
    }

    /**
     * Verifies that a userScale is updated
     */
    @Test
    void updateSuccess() {
        String newUserScaleData = "G-A-B-C-D#-E-F";
        UserScale userScaleToUpdate = userScaleDao.getUserScaleById(3);
        userScaleToUpdate.setScaleData(newUserScaleData);
        userScaleDao.saveOrUpdate(userScaleToUpdate);

        UserScale updatedUserScale = userScaleDao.getUserScaleById(3);
        assertEquals(newUserScaleData, updatedUserScale.getScaleData());
    }

    /**
     * Verifies that a userScale has been inserted into DB
     *
     * Unlike the other unit tests in this class, this test uses the equals() method
     * of both the UserScales and User classes behind-the-scenes to compare objects for equality
     */
    @Test
    void insertSuccess() {
        // get a user that already exists in the user table
        UserDao userDao = new UserDao();

        User user = userDao.getUserById(1);

        // create a new UserScale for the user
        UserScale newUserScale = new UserScale("C Romanian Major Scale", "C Db E F# G A Bb", user);

        // add the new UserScale to the User's UserScales Set
        user.addUserScale(newUserScale);

        // UserScaleDao object's insert() method inserts the new UserScale
        int id = userScaleDao.insert(newUserScale);

        // make sure the returned userScale id from insert() is not 0, meaning the userScale was inserted successfully
        assertNotEquals(0,id);

        // get the UserScale we just inserted, using its returned id
        UserScale insertedUserScale = userScaleDao.getUserScaleById(id);

        assertEquals(newUserScale, insertedUserScale);

        assertNotNull(insertedUserScale.getUser());
        // make sure the correct user is associated with the UserScale
        assertEquals(user, insertedUserScale.getUser());
    }

    /**
     * Verifies that a userScale has been deleted from the DB
     */
    @Test
    void deleteSuccess() {
        userScaleDao.delete(userScaleDao.getUserScaleById(3));
        assertNull(userScaleDao.getUserScaleById(3));
    }
}
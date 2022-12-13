package com.mtr.persistence;

import com.mtr.entity.User;
import com.mtr.entity.UserChord;
import com.mtr.entity.UserScale;
import com.mtr.test.util.Database;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test class for userChordDao class
 */
class UserChordDaoTest {

    UserChordDao userChordDao;

    /**
     * Run set up tasks before each test:
     * 1. execute sql which deletes everything from the userChords table and inserts records
     * 2. Create any objects needed in the tests
     */
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

        userChordDao = new UserChordDao();
    }

    /**
     * Verifies all userChords are returned
     */
    @Test
    void getAllUserChordsSuccess() {
        List<UserChord> userChords = userChordDao.getAllUserChords();
        // We want to know the number of userChords that should be returned
        // Double-click on test_MusicTheoryRepo->tables->userChords in Database pane to view the no. of userChords in userChords table
        assertEquals(15, userChords.size());
    }

    /**
     * Verifies all userChords with a specific name
     * or commonality are returned
     */
    @Test
    void getUserChordsByNameSuccess() {
        List<UserChord> userChords = userChordDao.getUserChordsByName("E");  // any userChords with an E
        assertEquals( 4, userChords.size());
    }

    /**
     * Verifies that the userChord with a specific id is returned
     */
    @Test
    void getUserChordByIdSuccess() {
        UserChord retrievedUserChord = userChordDao.getUserChordById(6);
        assertNotNull(retrievedUserChord);
        assertEquals("User", retrievedUserChord.getChordCategory());
        assertEquals("Bb 6/9", retrievedUserChord.getChordName());
        assertEquals("Bb D F G C", retrievedUserChord.getChordData());
    }

    /**
     * Verifies that the userChords with the specified username are returned
     */
    @Test
    void getUserChordsByUsernameSuccess() {
        UserDao userDao = new UserDao();
        User user = userDao.getUserById(1);
        String userName = user.getUserName();
        List<UserChord> userChords = userChordDao.getUserChordsByUsername(userName);
        assertEquals( 5, userChords.size());
    }

    /**
     * Verifies that a userChord is updated
     */
    @Test
    void updateSuccess() {
        String newUserChordData = "C#,F,A,B ";
        UserChord userChordToUpdate = userChordDao.getUserChordById(5);
        userChordToUpdate.setChordData(newUserChordData);
        userChordDao.saveOrUpdate(userChordToUpdate);

        UserChord updatedUserChord = userChordDao.getUserChordById(5);
        assertEquals(newUserChordData, updatedUserChord.getChordData());
    }

    /**
     * Verifies that a userChord has been inserted into DB
     *
     * Unlike the other unit tests in this class, this test uses the equals() method
     * of both the UserChords and User classes behind-the-scenes to compare objects for equality
     */
    @Test
    void insertSuccess() {
        // get a user that already exists in the user table
        UserDao userDao = new UserDao();

        User user = userDao.getUserById(2);

        // create a new UserChord for the user
        UserChord newUserChord = new UserChord("User", "Dmaj13", "D B C# F#", user);

        // add the new UserChord to the User's UserChords Set
        user.addUserChord(newUserChord);

        // UserChordDao object's insert() method inserts the new UserChord
        int id = userChordDao.insert(newUserChord);

        // make sure the returned userChord id from insert() is not 0, meaning the userChord was inserted successfully
        assertNotEquals(0,id);

        // get the UserChord we just inserted, using its returned id
        UserChord insertedUserChord = userChordDao.getUserChordById(id);

        assertEquals(newUserChord, insertedUserChord);

        assertNotNull(insertedUserChord.getUser());
        // make sure the correct user is associated with the UserChord
        assertEquals(user, insertedUserChord.getUser());
    }

    /**
     * Verifies that a userChord has been deleted from the DB
     */
    @Test
    void deleteSuccess() {
        userChordDao.delete(userChordDao.getUserChordById(8));
        assertNull(userChordDao.getUserChordById(8));
    }
}
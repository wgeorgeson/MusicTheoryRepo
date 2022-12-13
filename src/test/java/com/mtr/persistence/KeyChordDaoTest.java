package com.mtr.persistence;

import com.mtr.entity.KeysMusic;
import com.mtr.entity.KeyChord;
import com.mtr.test.util.Database;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test class for KeyChordDao class
 */

class KeyChordDaoTest {

    KeyChordDao keyChordDao;

    /**
     * Sets up testing by this test class by deleting and rewriting
     * the DB.  Instantiates a KeyChordDao object.
     */
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

        keyChordDao = new KeyChordDao();
    }

    /**
     * Gets all key chords.
     */
    @Test
    void getAllKeyChordsSuccess() {
        List<KeyChord> keyChords = keyChordDao.getAllKeyChords();
        // We want to know the number of keyChords that should be returned
        // Double-click on test_MusicTheoryRepo->tables->keyChords in Database pane to view the no. of keyChords in keyChords table
        assertEquals(140, keyChords.size());
    }

    @Test
    /**
     * Gets all key chords by category.
     */
    void getKeyChordsByCategorySuccess() {
        List<KeyChord> keyChords = keyChordDao.getKeyChordsByCategory("Seventh");
        assertEquals( 35, keyChords.size());
    }

    @Test
    /**
     * Gets all key chords by key chord name.
     */
    void getKeyChordsByNameSuccess() {
        List<KeyChord> keyChords = keyChordDao.getKeyChordsByName("sus2");  // any chord with "sus2" in it
        assertEquals( 5, keyChords.size());
    }

    @Test
    /**
     * Gets all key chords by key.
     */
    void getKeyChordsByKeyNameSuccess() {
        List<KeyChord> keyChords = keyChordDao.getKeyChordsByKeyName("Bb");
        assertEquals( 28, keyChords.size());
    }
}
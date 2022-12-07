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

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

        keyChordDao = new KeyChordDao();
    }

    @Test
    void getAllKeyChordsSuccess() {
        List<KeyChord> keyChords = keyChordDao.getAllKeyChords();
        // We want to know the number of keyChords that should be returned
        // Double-click on test_MusicTheoryRepo->tables->keyChords in Database pane to view the no. of keyChords in keyChords table
        assertEquals(112, keyChords.size());
    }

    @Test
    void getKeyChordsByCategorySuccess() {
        List<KeyChord> keyChords = keyChordDao.getKeyChordsByCategory("Seventh");
        assertEquals( 28, keyChords.size());
    }

    @Test
    void getKeyChordsByNameSuccess() {
        List<KeyChord> keyChords = keyChordDao.getKeyChordsByName("sus2");  // any chord with "sus2" in it
        assertEquals( 4, keyChords.size());
    }

    @Test
    void getKeyChordsByKeyNameSuccess() {
        List<KeyChord> keyChords = keyChordDao.getKeyChordsByKeyName("Bb");
        assertEquals( 28, keyChords.size());
    }
}
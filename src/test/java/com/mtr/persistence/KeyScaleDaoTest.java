package com.mtr.persistence;

import com.mtr.entity.KeysMusic;
import com.mtr.entity.KeyScale;
import com.mtr.entity.UserScale;
import com.mtr.test.util.Database;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test class for KeyScaleDao class
 */

class KeyScaleDaoTest {

    KeyScaleDao keyScaleDao;

    @BeforeEach
    /**
     * Sets up testing by this test class by deleting and rewriting
     * the DB.  Instantiates a KeyScaleDao object.
     */
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

        keyScaleDao = new KeyScaleDao();
    }

    @Test
    /**
     * Gets all key scales.
     */
    void getAllKeyScalesSuccess() {
        List<KeyScale> keyScales = keyScaleDao.getAllKeyScales();
        // We want to know the number of keyScales that should be returned
        // Double-click on test_MusicTheoryRepo->tables->keyScales in Database pane to view the no. of keyScales in keyScales table
        assertEquals(70, keyScales.size());
    }

    /**
     * Gets key scales by name.
     */
    @Test
    void getKeyScalesByNameSuccess() {
        List<KeyScale> keyScales = keyScaleDao.getKeyScalesByName("Dorian");
        assertEquals( 5, keyScales.size());
    }

    /**
     * Gets key scales by key name.
     */
    @Test
    void getKeyScalesByKeyNameSuccess() {
        List<KeyScale> keyScales = keyScaleDao.getKeyScalesByKeyName("Bb");
        assertEquals( 14, keyScales.size());
    }
}
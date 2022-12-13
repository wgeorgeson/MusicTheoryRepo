package com.mtr.persistence;

import com.mtr.entity.Song;
import com.mtr.test.util.Database;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Song dao test.
 */
class SongDaoTest {

    SongDao songDao;
    List<Song> songs;

    @BeforeEach
    /**
     * Sets up testing by this test class by deleting and rewriting
     * the DB.  Instantiates a Song object.
     */
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

        songDao = new SongDao();
    }

    /**
     * Gets all songs.
     */
    @Test
    void getAllSongs() {
        songs = songDao.getAllSongs();
        assertEquals(25, songs.size());
    }

    /**
     * Gets songs by name.
     */
    @Test
    void getSongsByName() {
        songs = songDao.getSongByName("Purple Rain");
        assertEquals(1, songs.size());
    }

    /**
     * Gets songs by artist.
     */
    @Test
    void getSongsByArtist() {
        songs = songDao.getSongsByArtist("Elton John");
        assertEquals(2, songs.size());
    }

    /**
     * Gets songs by key.
     */
    @Test
    void getSongsByKey() {
        songs = songDao.getSongsByKey("C#");
        assertEquals(5, songs.size());
    }
}
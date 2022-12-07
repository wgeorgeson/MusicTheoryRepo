package com.mtr.persistence;

import com.mtr.entity.Song;
import com.mtr.test.util.Database;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SongDaoTest {

    SongDao songDao;
    List<Song> songs;

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

        songDao = new SongDao();
    }

    @Test
    void getAllSongs() {
        songs = songDao.getAllSongs();
        assertEquals(20, songs.size());
    }

    @Test
    void getSongsByName() {
        songs = songDao.getSongByName("Purple Rain");
        assertEquals(1, songs.size());
    }

    @Test
    void getSongsByArtist() {
        songs = songDao.getSongsByArtist("Elton John");
        assertEquals(2, songs.size());
    }

    @Test
    void getSongsByKey() {
        songs = songDao.getSongsByKey("C#");
        assertEquals(5, songs.size());
    }
}
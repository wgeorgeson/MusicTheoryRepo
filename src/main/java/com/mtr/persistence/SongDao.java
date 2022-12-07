package com.mtr.persistence;

import com.mtr.entity.Song;
import com.mtr.entity.KeysMusic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.*;
import java.util.List;

/**
 * The type Song dao
 */
public class SongDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Gets all songs
     *
     * @return the all the songs
     */
    public List<Song> getAllSongs() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Song> query = builder.createQuery(Song.class);
        Root<Song> root = query.from(Song.class);
        List<Song> songs = session.createQuery(query).getResultList();
        session.close();
        return songs;
    }

    /**
     * Gets a List of songs by song name.
     *
     * @param name the song name
     * @return the songs
     */
    public List<Song> getSongByName(String name) {
        /*
         *  SELECT * FROM songs WHERE song_name = 'name'
         */
        logger.debug("Searching for: {}", name); // name will be used in place of the curly braces ({})
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Song> query = builder.createQuery(Song.class);
        Root<Song> root = query.from(Song.class);
        // Think of the following two stmts as the sql WHERE portion of your query
        Expression<String> propertyPath = root.get("songName");
        query.where(builder.equal(propertyPath, name));
        List<Song> songs = session.createQuery(query).getResultList();
        session.close();
        return songs;
    }

    /**
     * Gets a song by song name.
     *
     * @param artist the song artist
     * @return the List of songs by the artist
     */
    public List<Song> getSongsByArtist(String artist) {
        /*
         *  SELECT * FROM songs WHERE song_artist = 'artist'
         */
        logger.debug("Searching for: {}", artist); // name will be used in place of the curly braces ({})
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Song> query = builder.createQuery(Song.class);
        Root<Song> root = query.from(Song.class);
        // Think of the following two stmts as the sql WHERE portion of your query
        Expression<String> propertyPath = root.get("songArtist");
        query.where(builder.equal(propertyPath, artist));
        List<Song> songs = session.createQuery(query).getResultList();
        session.close();
        return songs;
    }

    /**
     * Gets a List of songs by key
     *
     * @param keyName the key name
     * @return the List of songs
     */
    public List<Song> getSongsByKey(String keyName) {
        logger.debug("Searching for songs in the key of: {}", keyName);
        Session session = sessionFactory.openSession();
        /*
         *  SELECT * FROM Song WHERE KeysMusic.key_id = Song.key_id
         *  AND KeysMusic.keyName = "keyName"
         */
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Song> query = builder.createQuery(Song.class);
        Root<Song> root = query.from(Song.class);
        Path<KeysMusic> propertyPath = root.get("keysMusic");
        query.where(builder.and(
                builder.equal(propertyPath.get("keyName"), keyName)));
        List<Song> songs = session.createQuery(query).getResultList();
        session.close();
        return songs;
    }
}
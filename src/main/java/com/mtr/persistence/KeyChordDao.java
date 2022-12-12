package com.mtr.persistence;

import com.mtr.entity.KeyChord;
import com.mtr.entity.KeysMusic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.*;
import java.util.List;

/**
 * The type KeyChord dao
 */
public class KeyChordDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Gets all keyChords
     *
     * @return the all the keyChords
     */
    public List<KeyChord> getAllKeyChords() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<KeyChord> query = builder.createQuery(KeyChord.class);
        Root<KeyChord> root = query.from(KeyChord.class);
        List<KeyChord> keyChords = session.createQuery(query).getResultList();
        session.close();
        return keyChords;
    }

    /** Gets a List of keyChords by category
     *
     * @param category the keyChord category
     * @return the keyChords
     */
    public List<KeyChord> getKeyChordsByCategory(String category) {
        /*
         *  SELECT * FROM keyChords WHERE category = "category"
         */
        logger.debug("Searching for: {}", category); // category will be used in place of the curly braces ({})
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<KeyChord> query = builder.createQuery(KeyChord.class);
        Root<KeyChord> root = query.from(KeyChord.class);
        // Think of the following two stmts as the sql WHERE portion of your query
        Expression<String> propertyPath = root.get("category");
        query.where(builder.equal(propertyPath, category));
        List<KeyChord> keyChords = session.createQuery(query).getResultList();
        session.close();
        return keyChords;
    }

    /**
     * Gets a List of keyChords by chord name.
     *
     * @param name the keyChord name
     * @return the keyChords
     */
    public List<KeyChord> getKeyChordsByName(String name) {
        /*
         *  SELECT * FROM keyChords WHERE chord_name LIKE '%name%'
         */
        logger.debug("Searching for: {}", name); // name will be used in place of the curly braces ({})
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<KeyChord> query = builder.createQuery(KeyChord.class);
        Root<KeyChord> root = query.from(KeyChord.class);
        // Think of the following two stmts as the sql WHERE portion of your query
        Expression<String> propertyPath = root.get("chordName");
        query.where(builder.like(propertyPath, "%" + name + "%"));
        List<KeyChord> keyChords = session.createQuery(query).getResultList();
        session.close();
        return keyChords;
    }

    /**
     * Gets a List of keyChords by key name.
     *
     * @param keyName the key name
     * @return the List of keyChords
     */
    public List<KeyChord> getKeyChordsByKeyName(String keyName) {
        logger.debug("Searching for chords in the key of: {}", keyName);
        Session session = sessionFactory.openSession();
        /*
         *  SELECT * FROM KeyChord WHERE KeysMusic.key_id = KeyChord.key_id
         *  AND KeysMusic.keyName = "keyName"
         */
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<KeyChord> query = builder.createQuery(KeyChord.class);
        Root<KeyChord> root = query.from(KeyChord.class);
        Path<KeysMusic> propertyPath = root.get("keysMusic");
        query.where(builder.and(
                builder.equal(propertyPath.get("keyName"), keyName)));
        List<KeyChord> keyChords = session.createQuery(query).getResultList();
        session.close();
        return keyChords;
    }

}

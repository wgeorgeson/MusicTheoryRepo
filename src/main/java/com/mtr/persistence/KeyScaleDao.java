package com.mtr.persistence;

import com.mtr.entity.KeyScale;
import com.mtr.entity.KeysMusic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.*;
import java.util.List;

/**
 * The type KeyScale dao
 */
public class KeyScaleDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Gets all keyScales
     *
     * @return the all the keyScales
     */
    public List<KeyScale> getAllKeyScales() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<KeyScale> query = builder.createQuery(KeyScale.class);
        Root<KeyScale> root = query.from(KeyScale.class);
        List<KeyScale> keyScales = session.createQuery(query).getResultList();
        session.close();
        return keyScales;
    }

    /**
     * Gets a List of keyScales by scale name.
     *
     * @param name the keyScale name
     * @return the keyScales
     */
    public List<KeyScale> getKeyScalesByName(String name) {
        /*
         *  SELECT * FROM keyScales WHERE scale_name = "A name inputted to this method"
        */
        logger.debug("Searching for: {}", name); // name will be used in place of the curly braces ({})
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<KeyScale> query = builder.createQuery(KeyScale.class);
        Root<KeyScale> root = query.from(KeyScale.class);
        // Think of the following two stmts as the sql WHERE portion of your query
        Expression<String> propertyPath = root.get("scaleName");
        query.where(builder.like(propertyPath, "%" + name + "%"));
        List<KeyScale> keyScales = session.createQuery(query).getResultList();
        session.close();
        return keyScales;
    }

    /**
     * Gets a List of keyScales by key name.
     *
     * @param keyName the key name
     * @return the List of keyScales
     */
    public List<KeyScale> getKeyScalesByKeyName(String keyName) {
        logger.debug("Searching for scales in the key of: {}", keyName);
        Session session = sessionFactory.openSession();
        /*
         *  SELECT * FROM KeyScale WHERE KeysMusic.key_id = KeyScale.key_id
         *  AND KeysMusic.keyName = "keyName"
         */
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<KeyScale> query = builder.createQuery(KeyScale.class);
        Root<KeyScale> root = query.from(KeyScale.class);
        Path<KeysMusic> propertyPath = root.get("keysMusic");
        query.where(builder.and(
            builder.equal(propertyPath.get("keyName"), keyName)));
        List<KeyScale> keyScales = session.createQuery(query).getResultList();
        session.close();

        for (KeyScale keyScale: keyScales) {
            logger.info(keyScale + "\n");
        }

        return keyScales;
    }

}

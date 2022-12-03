package com.mtr.persistence;

import com.mtr.entity.UserChord;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * The type UserChord dao.
 */
public class UserChordDao {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Gets all userChords
     *
     * @return the all the userChords
     */
    public List<UserChord> getAllUserChords() {
        // Get the SessionFactory object to open up a session and connect to the DB
        Session session = sessionFactory.openSession();
        // The next two stmts allow us to build a query that we can use on a particular entity class (the UserChord class)
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<UserChord> query = builder.createQuery(UserChord.class);
        // The following stmt is like the sql FROM portion of our query
        Root<UserChord> root = query.from(UserChord.class);
        // The following stmt will allow us to run the query, returning a list of users
        List<UserChord> userChords = session.createQuery(query).getResultList();
        // Close the session
        session.close();
        return userChords;
    }

    /**
     * Gets a List of userChords by chord name.
     *
     * @param name the userChord name
     * @return the userChords
     */
    public List<UserChord> getUserChordsByName(String name) {
        logger.debug("Searching for: {}", name); // name will be used in place of the curly braces ({})
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<UserChord> query = builder.createQuery(UserChord.class);
        Root<UserChord> root = query.from(UserChord.class);
        // Think of the following two stmts as the sql WHERE portion of your query
        Expression<String> propertyPath = root.get("chordName");
        query.where(builder.like(propertyPath, "%" + name + "%"));
        List<UserChord> userChords = session.createQuery(query).getResultList();
        session.close();
        return userChords;
    }

    /**
     * Gets a userChord by id.
     *
     * @param id the userChord id
     * @return the userChord by id
     */
    public UserChord getUserChordById(int id) {
        /*
         *  The creators of Hibernate built search by Id capabilities into the framework, so we don't have
         *  to do as much coding here
         */
        Session session = sessionFactory.openSession();
        UserChord userChord = session.get(UserChord.class, id);
        session.close();
        return userChord;
    }

    /**
     * update a userChord
     * @param userChord is the UserChord object we want updated
     */
    public void saveOrUpdate(UserChord userChord) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(userChord);
        transaction.commit();
        session.close();
    }

    /**
     * update userChord
     *
     * @param userChord UserChord to be inserted into the DB
     * @return the id of the userChord just inserted
     */
    public int insert(UserChord userChord) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int) session.save(userChord);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete a userChord
     *
     * @param userChord the UserChord to be deleted
     */
    public void delete(UserChord userChord) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(userChord);
        transaction.commit();
        session.close();
    }
}

package com.mtr.persistence;

import com.mtr.entity.UserScale;

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
 * The type UserScale dao.
 */
public class UserScaleDao {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Gets all userScales
     *
     * @return the all the userScales
     */
    public List<UserScale> getAllUserScales() {
        // Get the SessionFactory object to open up a session and connect to the DB
        Session session = sessionFactory.openSession();
        // The next two stmts allow us to build a query that we can use on a particular entity class (the UserScale class)
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<UserScale> query = builder.createQuery(UserScale.class);
        // The following stmt is like the sql FROM portion of our query
        Root<UserScale> root = query.from(UserScale.class);
        // The following stmt will allow us to run the query, returning a list of UserScale objects
        List<UserScale> userScales = session.createQuery(query).getResultList();
        // Close the session
        session.close();
        return userScales;
    }

    /**
     * Gets a List of userScales by scale name.
     *
     * @param name the userScale name
     * @return the userScales
     */
    public List<UserScale> getUserScalesByName(String name) {
        logger.debug("Searching for: {}", name); // name will be used in place of the curly braces ({})
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<UserScale> query = builder.createQuery(UserScale.class);
        Root<UserScale> root = query.from(UserScale.class);
        // Think of the following two stmts as the sql WHERE portion of your query
        Expression<String> propertyPath = root.get("scaleName");
        query.where(builder.like(propertyPath, "%" + name + "%"));
        List<UserScale> userScales = session.createQuery(query).getResultList();
        session.close();
        return userScales;
    }

    /**
     * Gets a userScale by id.
     *
     * @param id the userScale id
     * @return the userScale by id
     */
    public UserScale getUserScaleById(int id) {
        /*
        *  The creators of Hibernate built search by Id capabilities into the framework, so we don't have
        *  to do as much coding here
        */
        Session session = sessionFactory.openSession();
        UserScale userScale = session.get(UserScale.class, id);
        session.close();
        return userScale;
    }

    /**
     * update a userScale
     * @param userScale is the UserScale object we want updated
     */
    public void saveOrUpdate(UserScale userScale) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(userScale);
        transaction.commit();
        session.close();
    }

    /**
     * update userScale
     *
     * @param userScale UserScale to be inserted into the DB
     * @return the id of the userScale just inserted
     */
    public int insert(UserScale userScale) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int) session.save(userScale);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete a userScale
     *
     * @param userScale the UserScale to be deleted
     */
    public void delete(UserScale userScale) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(userScale);
        transaction.commit();
        session.close();
    }
}

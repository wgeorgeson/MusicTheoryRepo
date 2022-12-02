package com.mtr.persistence;

import com.mtr.entity.User;

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
 * The type User dao.
 */
public class UserDao {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Gets all users.
     *
     * @return the all users
     */
    public List<User> getAllUsers() {
        // Get the SessionFactory object to open up a session and connect to the DB
        Session session = sessionFactory.openSession();
        // The next two stmts allow us to build a query that we can use on a particular entity class (the User class)
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        /* .class after a class name, it references the Class object that represents the given class (formally, it is a named class literal).
         *   The type of SomeClass.class is Class<SomeClass>.
         *   It's the same thing as instantiating SomeClass and then calling someClass.getClass()
         */
        // The following stmt is like the sql FROM portion of our query
        Root<User> root = query.from(User.class);
        // The following stmt will allow us to run the query, returning a list of users
        List<User> users = session.createQuery(query).getResultList();
        // Close the session
        session.close();
        return users;
    }

    /**
     * Gets users by last name.
     *
     * @param lastName the last name
     * @return the users by last name
     */
    public List<User> getUsersByLastName(String lastName) {
        logger.debug("Searching for: {}", lastName); // lastName will be used in place of the curly braces ({})
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        // Think of the following two stmts as the sql WHERE portion of your query
        Expression<String> propertyPath = root.get("lastName");
        query.where(builder.like(propertyPath, "%" + lastName + "%"));
        List<User> users = session.createQuery(query).getResultList();
        session.close();
        return users;
    }

    /**
     * Gets user by id.
     *
     * @param id the id
     * @return the user by id
     */
    public User getUserById(int id) {
        Session session = sessionFactory.openSession();
        /*
         *  The creators of Hibernate built search by Id capabilities into the framework, so we don't have
         *  to do the amount of coding here as we did for getAllUsers() or getUsersByLastName()
         */
        User user = session.get(User.class, id);
        session.close();
        return user;
    }

    /**
     * update user
     *
     * @param user User to be inserted or updated
     */
    public void saveOrUpdate(User user) {
        Session session = sessionFactory.openSession();
        session.saveOrUpdate(user);
        session.close();
    }

    /**
     * update user
     *
     * @param user User to be inserted or updated
     */
    public int insert(User user) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int) session.save(user);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete a user
     *
     * @param user User to be deleted
     */
    public void delete(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
    }
}
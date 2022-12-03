package com.mtr.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.*;  // LocalDate, Period
import java.util.*;

/**
 * A class to represent a user.
 *
 * @author pwaite
 */
@Entity(name = "User")
@Table(name = "users")
public class User {
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    // Do not have to provide a @Column annotation for email because the var name and column name are both named "email"
    private String email;
    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    /*
     *  @OneToMany --> One user to Many
     *  mappedBy = "user" --> Referring to the instance variable "User user" in the UserScale and UserChord entities.  This is the variable with the matching @ManyToOne to this var's @OneToMany
     *  cascade = CascadeType.ALL  --> If a user gets deleted in the DB, all the orders associated with that user also get deleted
     *  orphanRemoval = true  --> What Hibernate will to the entities in memory.  If a user is removed from memory, then so are the user's orders
     *  fetch = FetchType.EAGER  --> Populate the orders Set right away when reading all the orders from the DB (for a user).
     */
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<UserScale> userScales = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<UserChord> userChords = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int user_id;


    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param email     the email
     * @param userName  the username
     * @param password  the password
     */
    public User(String firstName, String lastName, String email, String userName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }


    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets username.
     *
     * @param userName the username
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets userId.
     *
     * @return the userId
     */
    public int getUserId() {
        return user_id;
    }

    /**
     * Sets id.
     *
     * @param user_id the user id
     */
    public void setUserId(int user_id) {
        this.user_id = user_id;
    }

    /**
     * Gets a Set of userScales.
     *
     * @return the userScales
     */
    public Set<UserScale> getUserScales() {
        return userScales;
    }

    /**
     * Sets a Set of userScales.
     *
     * @param userScales the userScales
     * @return the userScales
     */
    public void setUserScales(Set<UserScale> userScales) {
        this.userScales = userScales;
    }

    /**
     * Add userScale to the userScales Set.
     * Set the user of the userScale to this current user.
     *
     * @param userScale the userScale
     */
    public void addUserScale(UserScale userScale) {
        userScales.add(userScale);
        userScale.setUser(this);
    }

    /**
     * Remove a userScale from a particular user.
     *
     * @param userScale the userScale
     */
    public void removeUserScale(UserScale userScale) {
        userScales.remove(userScale);
        userScale.setUser(null);
    }

    /**
     * Gets a Set of userChords.
     *
     * @return the userChords
     */
    public Set<UserChord> getUserChords() {
        return userChords;
    }

    /**
     * Sets a Set of userChords.
     *
     * @param userChords the userChords
     * @return the userChords
     */
    public void setUserChords(Set<UserChord> userChords) {
        this.userChords = userChords;
    }

    /**
     * Add userChord to the userChords Set.
     * Set the user of the userChord to this current user.
     *
     * @param userChord the userChord
     */
    public void addUserChord(UserChord userChord) {
        userChords.add(userChord);
        userChord.setUser(this);
    }

    /**
     * Remove a userChord from a particular user.
     *
     * @param userChord the userChord
     */
    public void removeUserChord(UserChord userChord) {
        userChords.remove(userChord);
        userChord.setUser(null);
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return user_id == user.user_id
                && firstName.equals(user.firstName)
                && lastName.equals(user.lastName)
                && userName.equals(user.userName)
                && email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, userName, email, user_id);
    }
}

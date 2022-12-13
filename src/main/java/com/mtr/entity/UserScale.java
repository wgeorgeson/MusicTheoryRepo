package com.mtr.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

/**
 * The type UserScale.
 */
@Entity(name = "UserScale")
@Table(name = "userScales")
public class UserScale {

    // Even if id of Entity class and id of Column name are the same, you must still specify @Id, @GeneratedValue, and @GenericGenerator
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int user_scale_id;

    @Column(name = "user_scale_name")
    private String scaleName;

    @Column(name = "user_scale_data")
    private String scaleData;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    // Hibernate will map this User to the user_id field in the UserScales table for us
    private User user;

    /**
     * Instantiates a new UserScale.  No-arg constructor.
     */
    public UserScale() {
    }

    /**
     * Instantiates a new UserScale object.  Constructor w/ args.
     *
     * @param scaleName     the scaleName
     * @param scaleData     the chordData
     * @param user          the user
     */
    public UserScale(String scaleName, String scaleData, User user) {
        this.scaleName = scaleName;
        this.scaleData = scaleData;
        this.user = user;
    }

    /**
     * Gets user_scale_id.
     *
     * @return the user_scale_id
     */
    public int getUserScaleId() {
        return user_scale_id;
    }

    /**
     * Sets user_scale_id.
     *
     * @param user_scale_id the user_chord_id
     */
    public void setUserScaleId(int user_scale_id) {
        this.user_scale_id = user_scale_id;
    }


    /**
     * Gets scale name.
     *
     * @return the scale name
     */
    public String getScaleName() {
        return scaleName;
    }

    /**
     * Sets scale name.
     *
     * @param scaleName the scale name
     */
    public void setScaleName(String scaleName) {
        this.scaleName = scaleName;
    }

    /**
     * Gets scale data.
     *
     * @return the scale data
     */
    public String getScaleData() {
        return scaleData;
    }

    /**
     * Sets scale data.
     *
     * @param scaleData the scale data
     */
    public void setScaleData(String scaleData) {
        this.scaleData = scaleData;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * A printable UserScale object.
     *
     * @return a UserScale object in a String format
     */
    @Override
    public String toString() {
        return "UserChord{" +
                "id =" + user_scale_id +
                ", name ='" + scaleName + '\'' +
                ", data ='" + scaleData + '\'' +
                ", user =" + user +
                '}';
    }

    @Override
    /**
     * Overridden method that determines if two UserScales are equal.
     *
     * @param o
     * @return boolean
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserScale userScale = (UserScale) o;
        // Order order = (Order) o;

        return user_scale_id == userScale.user_scale_id
                && scaleName.equals(userScale.scaleName)
                && scaleData.equals(userScale.scaleData);
        // return id == order.id && description.equals(order.description);
    }

    @Override
    /**
     * Overridden method computes the hash values of given input objects
     * Used in conjunction with equals()
     *
     * @return a hashcode int
     */
    public int hashCode() {
        return Objects.hash(user_scale_id, scaleName, scaleData);
        // return Objects.hash(id, description);
    }
}


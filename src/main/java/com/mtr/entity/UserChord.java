package com.mtr.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

/**
 * The type UserChord.
 */
@Entity(name = "UserChord")
@Table(name = "userChords")
public class UserChord {

    // Even if id of Entity class and id of Column name are the same, you must still specify @Id, @GeneratedValue, and @GenericGenerator
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int user_chord_id;

    @Column(name = "user_chord_category")
    private String chordCategory;

    @Column(name = "user_chord_name")
    private String chordName;

    @Column(name = "user_chord_data")
    private String chordData;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    // Hibernate will map this User to the user_id field in the UserChords table
    private User user;

    /**
     * Instantiates a new UserChord object.  No-arg constructor.
     */
    public UserChord() {
    }

    /**
     * Instantiates a new UserChord object.  Constructor w/ args.
     *
     * @param chordCategory the chordCategory
     * @param chordName     the chordName
     * @param chordData     the chordData
     * @param user          the user
     */
    public UserChord(String chordCategory, String chordName, String chordData, User user) {
        this.chordCategory = chordCategory;
        this.chordName = chordName;
        this.chordData = chordData;
        this.user = user;
    }

    /**
     * Gets user_chord_id.
     *
     * @return the user_chord_id
     */
    public int getUserChordId() {
        return user_chord_id;
    }

    /**
     * Sets user_chord_id.
     *
     * @param user_chord_id the user_chord_id
     */
    public void setUserChordId(int user_chord_id) {
        this.user_chord_id = user_chord_id;
    }

    /**
     * Gets chord category.
     *
     * @return the chord category
     */
    public String getChordCategory() {
        return chordCategory;
    }

    /**
     * Sets chord category.
     *
     * @param chordCategory the chord category
     */
    public void setChordCategory(String chordCategory) {
        this.chordCategory = chordCategory;
    }
    /**
     * Gets chord name.
     *
     * @return the chord name
     */
    public String getChordName() {
        return chordName;
    }

    /**
     * Sets chord name.
     *
     * @param chordName the chord name
     */
    public void setChordName(String chordName) {
        this.chordName = chordName;
    }

    /**
     * Gets chord data.
     *
     * @return the chord data
     */
    public String getChordData() {
        return chordData;
    }

    /**
     * Sets chord data.
     *
     * @param chordData the chord data
     */
    public void setChordData(String chordData) {
        this.chordData = chordData;
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

    @Override
    public String toString() {
        return "UserChord{" +
                "id =" + user_chord_id +
                ", category ='" + chordCategory + '\'' +
                ", name ='" + chordName + '\'' +
                ", data ='" + chordData + '\'' +
                ", user =" + user +
                '}';
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserChord userChord = (UserChord) o;
        return user_chord_id == userChord.user_chord_id
                && chordCategory.equals(userChord.chordCategory)
                && chordName.equals(userChord.chordName)
                && chordData.equals(userChord.chordData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_chord_id, chordCategory, chordName, chordData);
    }
}


package com.mtr.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * The type KeyChord
 *
 * @author Bill Georgeson
 */
@Entity(name = "KeyChord")
@Table(name = "keyChords")
public class KeyChord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int chord_id;

    @Column(name = "chord_category")
    private String category;

    @Column(name = "chord_name")
    private String chordName;

    @Column(name = "chord_data")
    private String chordData;

    @ManyToOne
    @JoinColumn(name="key_id", nullable=false)
    // Hibernate will map this KeysMusic object to the key_id field in the KeyChords table
    private KeysMusic keysMusic;

    /**
     * Instantiates a new keyChord object.
     *
     * No-arg constructor.
     */
    public KeyChord() {

    }

    /**
     * Instantiates a new KeyChord object.  Constructor w/ args.
     *
     * @param category  the category
     * @param chordName the chordName
     * @param chordData the chordData
     * @param keysMusic the KeysMusic object
     */
    public KeyChord(String category, String chordName, String chordData, KeysMusic keysMusic) {
        this.category = category;
        this.chordName = chordName;
        this.chordData = chordData;
        this.keysMusic = keysMusic;
    }

    /**
     * Gets chord id.
     *
     * @return the chord id
     */
    public int getChord_id() {
        return chord_id;
    }

    /**
     * Sets chord id.
     *
     * @param chord_id the chord id
     */
    public void setChord_id(int chord_id) {
        this.chord_id = chord_id;
    }

    /**
     * Gets category.
     *
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets category.
     *
     * @param category the category
     */
    public void setCategory(String category) {
        this.category = category;
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
     * Gets a keysMusic object.
     *
     * @return the keysMusic object
     */
    public KeysMusic getKeysMusic() {
        return keysMusic;
    }

    /**
     * Sets a keysMusic object.
     *
     * @param keysMusic the keysMusic
     */
    public void setKeysMusic(KeysMusic keysMusic) {
        this.keysMusic = keysMusic;
    }

    @Override
    public String toString() {
        return "KeyChord {" +
                "id = " + chord_id +
                ", chord name ='" + chordName + '\'' +
                ", chord data ='" + chordData + '\'' +
                ", KeysMusic = " + keysMusic +
                '}';
    }
}


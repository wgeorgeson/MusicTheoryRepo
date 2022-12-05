package com.mtr.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * The type KeyChord
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
     * @param chordName     the chordName
     * @param chordData     the chordData
     * @param keysMusic     the KeysMusic object
     */
    public KeyChord(String category, String chordName, String chordData, KeysMusic keysMusic) {
        this.category = category;
        this.chordName = chordName;
        this.chordData = chordData;
        this.keysMusic = keysMusic;
    }

    public int getChord_id() {
        return chord_id;
    }

    public void setChord_id(int chord_id) {
        this.chord_id = chord_id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getChordName() {
        return chordName;
    }

    public void setChordName(String chordName) {
        this.chordName = chordName;
    }

    public String getChordData() {
        return chordData;
    }

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


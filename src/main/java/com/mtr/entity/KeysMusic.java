package com.mtr.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

/**
 * A class to represent a user.
 *
 * @author Bill Georgeson
 */
@Entity(name = "KeysMusic")  // the name of this class
@Table(name = "keysMusic")  // the name of the table this class maps to
public class KeysMusic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int key_id;

    @Column(name = "key_name")
    private String keyName;

    @OneToMany(mappedBy = "keysMusic", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<KeyScale> keyScales = new HashSet<>();

    @OneToMany(mappedBy = "keysMusic", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<KeyChord> keyChords = new HashSet<>();

    @OneToMany(mappedBy = "keysMusic", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Song> songs = new HashSet<>();


    /**
     * Instantiates a new KeysMusic object
     * <p>
     * Constructor. No-args.
     */
    public KeysMusic() {

    }

    /**
     * Instantiates a new KeysMusic object
     *
     * @param keyName the name of the key ("B" or "C#", etc.)
     */
    public KeysMusic(String keyName) {
        this.keyName = keyName;
    }

    /**
     * Gets key id.
     *
     * @return the key id
     */
    public int getKeyId() {
        return key_id;
    }

    /**
     * Sets key id.
     *
     * @param key_id the key id
     */
    public void setKeyId(int key_id) {
        this.key_id = key_id;
    }

    /**
     * Gets key name.
     *
     * @return the key name
     */
    public String getKeyName() {
        return keyName;
    }

    /**
     * Sets key name.
     *
     * @param keyName the key name
     */
    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    /**
     * Gets key scales.
     *
     * @return the key scales
     */
    public Set<KeyScale> getKeyScales() {
        return keyScales;
    }

    /**
     * Sets key scales.
     *
     * @param keyScales the key scales
     */
    public void setKeyScales(Set<KeyScale> keyScales) {
        this.keyScales = keyScales;
    }

    /**
     * Gets key chords.
     *
     * @return the key chords
     */
    public Set<KeyChord> getKeyChords() {
        return keyChords;
    }

    /**
     * Sets key chords.
     *
     * @param keyChords the key chords
     */
    public void setKeyChords(Set<KeyChord> keyChords) {
        this.keyChords = keyChords;
    }

    /**
     * Gets songs.
     *
     * @return the songs
     */
    public Set<Song> getSongs() {
        return songs;
    }

    /**
     * Sets songs.
     *
     * @param songs the songs
     */
    public void setSongs(Set<Song> songs) {
        this.songs = songs;
    }

    public String toString() {
        return "KeysMusic{" +
                "KeyID ='" + key_id + '\'' +
                ", KeyName='" + keyName + '\'' +
                '}';
    }
}

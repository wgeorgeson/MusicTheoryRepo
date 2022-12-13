package com.mtr.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * The type Song
 *
 * @author Bill Georgeson
 */
@Entity(name = "Song")
@Table(name = "songs")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int song_id;

    @Column(name = "song_name")
    private String songName;

    @Column(name = "song_artist")
    private String songArtist;

    @Column(name = "song_spotifyId")
    private String songSpotifyId;

    @ManyToOne
    @JoinColumn(name="key_id", nullable=false)
    // Hibernate will map this KeysMusic object to the key_id field in the songs table
    private KeysMusic keysMusic;

    /**
     * Instantiates a new Song object.
     * <p>
     * No-arg constructor.
     */
    public Song() {

    }

    /**
     * Instantiates a new Song object.  Constructor w/ args.
     *
     * @param songName   the songName
     * @param songArtist the songArtis
     * @param keysMusic  the KeysMusic object
     */
    public Song(String songName, String songArtist, KeysMusic keysMusic) {
        this.songName = songName;
        this.songArtist = songArtist;
        this.keysMusic = keysMusic;
    }

    /**
     * Gets song id.
     *
     * @return the song id
     */
    public int getSong_id() {
        return song_id;
    }

    /**
     * Sets song id.
     *
     * @param song_id the song id
     */
    public void setSong_id(int song_id) {
        this.song_id = song_id;
    }

    /**
     * Gets song name.
     *
     * @return the song name
     */
    public String getSongName() {
        return songName;
    }

    /**
     * Sets song name.
     *
     * @param songName the song name
     */
    public void setSongName(String songName) {
        this.songName = songName;
    }

    /**
     * Gets song artist.
     *
     * @return the song artist
     */
    public String getSongArtist() {
        return songArtist;
    }

    /**
     * Sets song artist.
     *
     * @param songArtist the song artist
     */
    public void setSongArtist(String songArtist) {
        this.songArtist = songArtist;
    }

    /**
     * Gets song spotify id.
     *
     * @return the song spotify id
     */
    public String getSongSpotifyId() {
        return songSpotifyId;
    }

    /**
     * Sets song spotify id.
     *
     * @param songSpotifyId the song spotify id
     */
    public void setSongSpotifyId(String songSpotifyId) {
        this.songSpotifyId = songSpotifyId;
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
        return "Song {" +
                "id = " + song_id +
                ", Song name ='" + songName + '\'' +
                ", Song artist ='" + songArtist + '\'' +
                ", KeysMusic = " + keysMusic +
                '}';
    }
}


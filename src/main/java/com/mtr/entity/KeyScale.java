package com.mtr.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * The type KeyScale
 *
 * @author Bill Georgeson
 */
@Entity(name = "KeyScale")
@Table(name = "keyScales")
public class KeyScale {

    // Even if id of Entity class and id of Column name are the same, you must still specify @Id, @GeneratedValue, and @GenericGenerator
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int scale_id;

    @Column(name = "scale_name")
    private String scaleName;

    @Column(name = "scale_data")
    private String scaleData;

    @ManyToOne
    @JoinColumn(name="key_id", nullable=false)
    // Hibernate will map this KeysMusic object to the key_id field in the keyScales table
    private KeysMusic keysMusic;

    /**
     * Instantiates a new KeyScale object.
     * <p>
     * No-arg constructor.
     */
    public KeyScale() {

    }

    /**
     * Instantiates a new KeyScale object.  Constructor w/ args.
     *
     * @param scaleName the scaleName
     * @param scaleData the scaleData
     * @param keysMusic the keysMusic object
     */
    public KeyScale(String scaleName, String scaleData, KeysMusic keysMusic) {
        this.scaleName = scaleName;
        this.scaleData = scaleData;
        this.keysMusic = keysMusic;
    }

    /**
     * Gets scale id.
     *
     * @return the scale id
     */
    public int getScale_id() {
        return scale_id;
    }

    /**
     * Sets scale id.
     *
     * @param scale_id the scale id
     */
    public void setScale_id(int scale_id) {
        this.scale_id = scale_id;
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
        return "KeyScale {" +
                "id = " + scale_id +
                ", scale name ='" + scaleName + '\'' +
                ", scale data ='" + scaleData + '\'' +
                ", KeysMusic = " + keysMusic +
                '}';
    }
}

package com.jokeAPI;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Joke.
 */
public class Joke{

	@JsonProperty("delivery")
	private String delivery;

	@JsonProperty("flags")
	private Flags flags;

	@JsonProperty("safe")
	private boolean safe;

	@JsonProperty("setup")
	private String setup;

	@JsonProperty("id")
	private int id;

	@JsonProperty("error")
	private boolean error;

	@JsonProperty("category")
	private String category;

	@JsonProperty("type")
	private String type;

	@JsonProperty("lang")
	private String lang;

	/**
	 * Get delivery string.
	 *
	 * @return the string
	 */
	public String getDelivery(){
		return delivery;
	}

	/**
	 * Get flags flags.
	 *
	 * @return the flags
	 */
	public Flags getFlags(){
		return flags;
	}

	/**
	 * Is safe boolean.
	 *
	 * @return the boolean
	 */
	public boolean isSafe(){
		return safe;
	}

	/**
	 * Get setup string.
	 *
	 * @return the string
	 */
	public String getSetup(){
		return setup;
	}

	/**
	 * Get id int.
	 *
	 * @return the int
	 */
	public int getId(){
		return id;
	}

	/**
	 * Is error boolean.
	 *
	 * @return the boolean
	 */
	public boolean isError(){
		return error;
	}

	/**
	 * Get category string.
	 *
	 * @return the string
	 */
	public String getCategory(){
		return category;
	}

	/**
	 * Get type string.
	 *
	 * @return the string
	 */
	public String getType(){
		return type;
	}

	/**
	 * Get lang string.
	 *
	 * @return the string
	 */
	public String getLang(){
		return lang;
	}
}
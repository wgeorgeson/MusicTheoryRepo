package com.jokeAPI;

import com.fasterxml.jackson.annotation.JsonProperty;

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

	public String getDelivery(){
		return delivery;
	}

	public Flags getFlags(){
		return flags;
	}

	public boolean isSafe(){
		return safe;
	}

	public String getSetup(){
		return setup;
	}

	public int getId(){
		return id;
	}

	public boolean isError(){
		return error;
	}

	public String getCategory(){
		return category;
	}

	public String getType(){
		return type;
	}

	public String getLang(){
		return lang;
	}
}
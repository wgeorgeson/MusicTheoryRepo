package com.jokeAPI;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Flags{

	@JsonProperty("sexist")
	private boolean sexist;

	@JsonProperty("explicit")
	private boolean explicit;

	@JsonProperty("religious")
	private boolean religious;

	@JsonProperty("nsfw")
	private boolean nsfw;

	@JsonProperty("political")
	private boolean political;

	@JsonProperty("racist")
	private boolean racist;

	public boolean isSexist(){
		return sexist;
	}

	public boolean isExplicit(){
		return explicit;
	}

	public boolean isReligious(){
		return religious;
	}

	public boolean isNsfw(){
		return nsfw;
	}

	public boolean isPolitical(){
		return political;
	}

	public boolean isRacist(){
		return racist;
	}
}
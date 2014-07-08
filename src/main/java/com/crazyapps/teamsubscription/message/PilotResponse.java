package com.crazyapps.teamsubscription.message;

public class PilotResponse {

	private final String name;
	private final String nationality;

	public PilotResponse(String name, String nationality) {
		super();
		this.name = name;
		this.nationality = nationality;
	}

	public String getName() {
		return name;
	}

	public String getNationality() {
		return nationality;
	}

}

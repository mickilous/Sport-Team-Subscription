package com.crazyapps.teamsubscription.message;

import java.util.List;

public class TeamResponse {

	private final long id;
	private final String name;
	private final Integer number;
	private final String avatar;
	private final boolean isLookingForPilots;
	private final List<PilotResponse> pilots;

	public TeamResponse(long id, String name, Integer number, String avatar, boolean isLookingForPilots, List<PilotResponse> pilots) {
		super();
		this.id = id;
		this.name = name;
		this.number = number;
		this.avatar = avatar;
		this.isLookingForPilots = isLookingForPilots;
		this.pilots = pilots;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getNumber() {
		return number;
	}

	public String getAvatar() {
		return avatar;
	}

	public boolean isLookingForPilots() {
		return isLookingForPilots;
	}

	public List<PilotResponse> getPilots() {
		return pilots;
	}

}

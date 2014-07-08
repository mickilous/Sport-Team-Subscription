package com.crazyapps.teamsubscription.model;

public class Pilot {

	private long id;
	private long fbId;
	private String avatar;
	private String nationality;
	private boolean isLookingForTeam;
	private boolean isKHO;
	private boolean isAPC8;

	public Pilot(long id, long fbId, String avatar, String nationality,
			boolean isLookingForTeam, boolean isKHO, boolean isAPC8) {
		super();
		this.id = id;
		this.fbId = fbId;
		this.avatar = avatar;
		this.nationality = nationality;
		this.isLookingForTeam = isLookingForTeam;
		this.isKHO = isKHO;
		this.isAPC8 = isAPC8;
	}
}

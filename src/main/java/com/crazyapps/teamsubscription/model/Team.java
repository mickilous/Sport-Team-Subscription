package com.crazyapps.teamsubscription.model;

import java.util.List;

//@Entity
public class Team {

	//
	// @Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	private Integer number;

	private String avatar;

	private Integer maxPilots;

	private List<Pilot> pilots;

	private boolean lookingForPilots;

	public Team() {
	}

	public Team(String name, Integer number, String avatar, Integer maxPilots, boolean lookingForPilots) {
		super();
		this.name = name;
		this.number = number;
		this.avatar = avatar;
		this.maxPilots = maxPilots;
		this.lookingForPilots = lookingForPilots;
	}

}

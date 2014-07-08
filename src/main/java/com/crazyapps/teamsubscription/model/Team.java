package com.crazyapps.teamsubscription.model;

import java.util.List;

public class Team {
	
	private Long id;
	private String name;
	private Integer number;
	private String avatar;
	private List<Pilot> pilots;
	private boolean isLookingForPilots;
}

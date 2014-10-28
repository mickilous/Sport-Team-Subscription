package com.crazyapps.teamsubscription.data;

import com.crazyapps.teamsubscription.model.Pilot;
import com.crazyapps.teamsubscription.model.Team;

public class DataProvider {

	public static Team newTeam() {
		return new Team("name", 1, "avatar", 1, false);
	}

	public static Pilot newPilot() {
		return new Pilot(1, "avatar", "be", false, false, false);
	}
}

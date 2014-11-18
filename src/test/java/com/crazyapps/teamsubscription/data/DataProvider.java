package com.crazyapps.teamsubscription.data;

import com.crazyapps.teamsubscription.exception.BusinessException;
import com.crazyapps.teamsubscription.model.Pilot;
import com.crazyapps.teamsubscription.model.Team;

public class DataProvider {

	public static Team newTeam() {
		return new Team("name", 1, "avatar", 4, newPilot(), false);
	}

	public static Pilot newPilot() {
		return new Pilot("pilot@mail.com", 1, "avatar", "be", false, false, false);
	}

	public static Team newTeamWithPilot() throws BusinessException {
		Team team = newTeam();
		team.addPilot(newPilot());
		return team;
	}
}

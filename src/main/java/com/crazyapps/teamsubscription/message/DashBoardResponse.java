package com.crazyapps.teamsubscription.message;

import java.util.List;

public class DashBoardResponse {

	private final PilotResponse pilot;
	private final TeamResponse team;
	private final List<TeamResponse> teams;
	private final List<PilotResponse> teamLessPilots;

	public DashBoardResponse(PilotResponse pilot, TeamResponse team,
			List<TeamResponse> teams, List<PilotResponse> teamLessPilots) {
		super();
		this.pilot = pilot;
		this.team = team;
		this.teams = teams;
		this.teamLessPilots = teamLessPilots;
	}

	public PilotResponse getPilot() {
		return pilot;
	}

	public TeamResponse getTeam() {
		return team;
	}

	public List<TeamResponse> getTeams() {
		return teams;
	}

	public List<PilotResponse> getTeamLessPilots() {
		return teamLessPilots;
	}

}

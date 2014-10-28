package com.crazyapps.teamsubscription.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crazyapps.teamsubscription.message.DashBoardResponse;
import com.crazyapps.teamsubscription.message.PilotResponse;
import com.crazyapps.teamsubscription.message.TeamResponse;

@RestController
public class ApplicationController {

	@RequestMapping(method = GET, value = "/dashboard")
	public DashBoardResponse dashBoard() {

		PilotResponse pilot = me();

		TeamResponse team = null;

		List<TeamResponse> allTeams = Arrays.asList(team1(), team2(), team3(),
				team4());

		List<PilotResponse> teamLessPilots = teamLessPilots();

		return new DashBoardResponse(pilot, team, allTeams, teamLessPilots);
	}

	private TeamResponse myTeam() {
		return new TeamResponse("My Te4m", 42, "evil-minion-icon-2.png", false,
				coPilots());
	}

	private List<PilotResponse> coPilots() {
		return Arrays.asList(new PilotResponse("Me Myself and I", "fr"),
				new PilotResponse("pilot45", "gb"), new PilotResponse(
						"pilot12", "nl"), new PilotResponse("pilot34", "be"));
	}

	private PilotResponse me() {
		return new PilotResponse("Me Myself and I", "BE");
	}

	private TeamResponse team1() {
		return new TeamResponse("A-team !!", 1, "evil-minion-icon-2.png", true,
				Arrays.asList(
						//
						new PilotResponse("Ajkjskds Tfkskflsm", "fr"),
						new PilotResponse("Fsqklsdlkqm Ljkqsjdl", "gb"),
						new PilotResponse("pilot12", "nl"), //
						new PilotResponse("pilot34", "be")));
	}

	private TeamResponse team2() {
		return new TeamResponse("B-team !!", 22, "evil-minion-icon-4.png",
				true, Arrays.asList(
				//
						new PilotResponse("pilot21", "fr"), //
						new PilotResponse("pilot22", "gb"), //
						new PilotResponse("pilot23", "nl"), //
						new PilotResponse("pilot24", "be")));
	}

	private TeamResponse team3() {
		return new TeamResponse("C-team !!", 32, "evil-minion-icon-4.png",
				true, Arrays.asList(
				//
						new PilotResponse("pilot31", "fr"), //
						new PilotResponse("pilot32", "gb"), //
						new PilotResponse("pilot33", "nl"), //
						new PilotResponse("pilot34", "be")));
	}

	private TeamResponse team4() {
		return new TeamResponse("D-team !!", 52, "evil-minion-icon-4.png",
				true, Arrays.asList(
				//
						new PilotResponse("pilot51", "fr"), //
						new PilotResponse("pilot52", "gb"), //
						new PilotResponse("pilot53", "nl"), //
						new PilotResponse("pilot54", "be")));
	}

	private List<PilotResponse> teamLessPilots() {
		return Arrays.asList(
		//
				new PilotResponse("pilot91", "fr"), //
				new PilotResponse("pilot92", "gb"), //
				new PilotResponse("pilot93", "nl"), //
				new PilotResponse("pilot94", "be"));
	}
}

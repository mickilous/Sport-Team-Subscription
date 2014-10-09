package com.crazyapps.teamsubscription.controller;

import static java.util.Collections.singletonList;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.ArrayList;
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

		TeamResponse team = null;// myTeam();

		List<TeamResponse> allTeams = Arrays.asList(team1(), team2(), team3(), team4());

		List<PilotResponse> teamLessPilots = teamLessPilots();

		return new DashBoardResponse(pilot, team, allTeams, teamLessPilots);
	}

	@RequestMapping(method = GET, value = "/numbers")
	public List<Integer> pilotNumbers(int pilots) {
		List<Integer> numbers = new ArrayList<Integer>();
		// 1 : 1 - 8
		// 2 : 9 - 44
		// 3 : 45 - 58
		// 4 : 58 - 65
		//
		// Miss
		// 48 48
		// 58

		if (pilots == 1) {
			for (int i = 1; i <= 8; i++) {
				numbers.add(i);
			}
		}

		if (pilots == 2) {
			for (int i = 9; i <= 44; i++) {
				numbers.add(i);
			}
		}

		if (pilots == 3) {
			for (int i = 45; i <= 58; i++) {
				numbers.add(i);
			}
		}

		if (pilots == 4) {
			for (int i = 59; i <= 65; i++) {
				numbers.add(i);
			}
		}
		return numbers;
	}

	@RequestMapping(method = POST, value = "/createTeam")
	public TeamResponse createTeam(String name, Integer number, Integer pilots) {
		return myNewTeam();
	}

	private TeamResponse myTeam() {
		return new TeamResponse(1, "My Te4m", 42, "evil-minion-icon-2.png", false, coPilots());
	}

	private TeamResponse myNewTeam() {
		return new TeamResponse(1, "My Te4m", 42, "evil-minion-icon-2.png", false, singletonList(me()));
	}

	private List<PilotResponse> coPilots() {
		return Arrays.asList(new PilotResponse("Me Myself and I", "fr"), new PilotResponse("pilot45", "gb"), new PilotResponse("pilot12", "nl"), new PilotResponse("pilot34", "be"));
	}

	private PilotResponse me() {
		return new PilotResponse("Me Myself and I", "BE");
	}

	private TeamResponse team1() {
		return new TeamResponse(2, "A-team !!", 1, "evil-minion-icon-2.png", true, Arrays.asList(
		//
				new PilotResponse("Ajkjskds Tfkskflsm", "fr"), new PilotResponse("Fsqklsdlkqm Ljkqsjdl", "gb"), new PilotResponse("pilot12", "nl"), //
				new PilotResponse("pilot34", "be")));
	}

	private TeamResponse team2() {
		return new TeamResponse(3, "B-team !!", 22, "evil-minion-icon-4.png", true, Arrays.asList(
		//
				new PilotResponse("pilot21", "fr"), //
				new PilotResponse("pilot22", "gb"), //
				new PilotResponse("pilot23", "nl"), //
				new PilotResponse("pilot24", "be")));
	}

	private TeamResponse team3() {
		return new TeamResponse(4, "C-team !!", 32, "evil-minion-icon-4.png", true, Arrays.asList(
		//
				new PilotResponse("pilot31", "fr"), //
				new PilotResponse("pilot32", "gb"), //
				new PilotResponse("pilot33", "nl"), //
				new PilotResponse("pilot34", "be")));
	}

	private TeamResponse team4() {
		return new TeamResponse(5, "D-team !!", 52, "evil-minion-icon-4.png", true, Arrays.asList(
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

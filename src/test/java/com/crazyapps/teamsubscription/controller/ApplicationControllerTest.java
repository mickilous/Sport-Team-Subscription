package com.crazyapps.teamsubscription.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpSession;

import com.crazyapps.teamsubscription.C;
import com.crazyapps.teamsubscription.data.DataProvider;
import com.crazyapps.teamsubscription.exception.BusinessException;
import com.crazyapps.teamsubscription.message.DashBoardResponse;
import com.crazyapps.teamsubscription.message.PilotResponse;
import com.crazyapps.teamsubscription.model.Pilot;
import com.crazyapps.teamsubscription.model.Team;
import com.crazyapps.teamsubscription.repository.PilotRepository;
import com.crazyapps.teamsubscription.repository.TeamRepository;

@RunWith(MockitoJUnitRunner.class)
public class ApplicationControllerTest {

	@InjectMocks
	ApplicationController applicationController = new ApplicationController();

	@Mock
	PilotRepository pilotRepository;

	@Mock
	TeamRepository teamRepository;

	@Test
	public void testDashBoard() throws BusinessException {
		Team teamWithPilot = DataProvider.newTeamWithPilot();
		Team team = DataProvider.newTeam();
		List<Team> allTeams = Arrays.asList(teamWithPilot, team);
		Pilot pilot = teamWithPilot.getPilots().get(1);

		when(pilotRepository.findOne(anyLong())).thenReturn(pilot);
		when(teamRepository.findAll()).thenReturn(allTeams);

		MockHttpSession httpSession = new MockHttpSession();
		httpSession.setAttribute(C.USER, pilot);
		DashBoardResponse dashBoard = applicationController.dashBoard(httpSession);

		PilotResponse pilotResponse = dashBoard.getPilot();
		assertEquals(pilot.getName(), pilotResponse.getName());
		assertEquals(pilot.getNationality(), pilot.getNationality());

		assertEquals(pilot.getTeam().getId(), dashBoard.getTeam().getId());
		assertEquals(pilot.getTeam().getName(), dashBoard.getTeam().getName());
		assertEquals(pilot.getTeam().getNumber(), dashBoard.getTeam().getNumber());
		assertEquals(pilot.getTeam().getPilots().size(), dashBoard.getTeam().getPilots().size());

		verify(pilotRepository).findOne(11L);
		verify(teamRepository).findAll();

	}

	// @Test
	// public void testPilotNumbers() {
	// }
	//
	// @Test
	// public void testCreateTeam() {
	// }

}

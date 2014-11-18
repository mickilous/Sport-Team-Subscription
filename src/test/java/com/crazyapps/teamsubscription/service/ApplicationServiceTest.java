package com.crazyapps.teamsubscription.service;

import static com.crazyapps.teamsubscription.data.DataProvider.newPilot;
import static com.crazyapps.teamsubscription.data.DataProvider.newTeam;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.crazyapps.teamsubscription.exception.BusinessException;
import com.crazyapps.teamsubscription.model.Pilot;
import com.crazyapps.teamsubscription.model.Team;
import com.crazyapps.teamsubscription.repository.PilotRepository;
import com.crazyapps.teamsubscription.repository.TeamRepository;

@RunWith(MockitoJUnitRunner.class)
public class ApplicationServiceTest {

	@InjectMocks
	ApplicationService applicationService = new ApplicationServiceImpl();

	@Mock
	PilotRepository pilotRepository;

	@Mock
	TeamRepository teamRepository;

	@Test
	public void testCreatePilot() {

		when(pilotRepository.save(any(Pilot.class))).then(returnsFirstArg());

		Pilot pilot = applicationService.createPilot("email", 1L, "avatar", "nationality");

		assertEquals("email", pilot.getEmail());
		assertEquals((Long) 1L, pilot.getFbId());
		assertEquals("avatar", pilot.getAvatar());
		assertEquals("nationality", pilot.getNationality());
		verify(pilotRepository).save(pilot);
	}

	@Test
	public void testUpdatePilot() {

		Pilot pilot = newPilot();
		when(pilotRepository.findOne(1L)).thenReturn(pilot);
		when(pilotRepository.save(pilot)).thenReturn(pilot);

		Pilot updatedPilot = applicationService.updatePilot(1L, true, true, true);

		assertTrue(updatedPilot.isLookingForTeam());
		assertTrue(updatedPilot.isKHO());
		assertTrue(updatedPilot.isAPC8());
		verify(pilotRepository).save(pilot);
	}

	@Test
	public void testCreateTeam() {

		when(teamRepository.save(any(Team.class))).then(returnsFirstArg());

		Pilot pilot = newPilot();
		Team team = applicationService.createTeam("name", 1, "avatar", 2, pilot, false);

		assertEquals("name", team.getName());
		assertEquals((Integer) 1, team.getNumber());
		assertEquals("avatar", team.getAvatar());
		assertEquals((Integer) 2, team.getMaxPilots());
		assertEquals(pilot, team.getTeamAdmin());
		assertFalse(team.isLookingForPilots());
		verify(teamRepository).save(team);
	}

	@Test
	public void testUpdateTeam() throws BusinessException {

		Team team = newTeam();
		when(teamRepository.findOne(1L)).thenReturn(team);
		when(teamRepository.save(team)).thenReturn(team);

		Team updatedTeam = applicationService.updateTeam(1L, "name2", 2, "avatar2", 1, true);

		assertEquals("name2", updatedTeam.getName());
		assertEquals((Integer) 2, updatedTeam.getNumber());
		assertEquals("avatar2", updatedTeam.getAvatar());
		assertEquals((Integer) 1, updatedTeam.getMaxPilots());
		assertTrue(updatedTeam.isLookingForPilots());
	}
}

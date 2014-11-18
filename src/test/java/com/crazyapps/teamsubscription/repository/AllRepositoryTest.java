package com.crazyapps.teamsubscription.repository;

import static com.crazyapps.teamsubscription.data.DataProvider.newPilot;
import static com.crazyapps.teamsubscription.data.DataProvider.newTeam;
import static com.crazyapps.teamsubscription.data.DataProvider.newTeamWithPilot;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.crazyapps.teamsubscription.Application;
import com.crazyapps.teamsubscription.exception.BusinessException;
import com.crazyapps.teamsubscription.model.Pilot;
import com.crazyapps.teamsubscription.model.Team;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class AllRepositoryTest {

	@Autowired
	PilotRepository pilotRepository;

	@Autowired
	TeamRepository teamRepository;

	@Test
	public void testPilotRepository() {
		Pilot pilot = newPilot();

		pilotRepository.save(pilot);
		assertNotNull(pilot.getId());
	}

	@Test
	public void testTeamRepository() throws BusinessException {
		Team team = newTeam();

		teamRepository.save(team);

		assertNotNull(team.getId());
		assertNotNull(team.getTeamAdmin());
		assertNotNull(team.getTeamAdmin().getId());
	}

	@Test
	public void testTeamRepository_With_Pilot() throws BusinessException {
		Team team = newTeamWithPilot();

		teamRepository.save(team);
		assertNotNull(team.getId());
		assertNotNull(team.getPilots().get(0).getId());
	}

}

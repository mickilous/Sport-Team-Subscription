package com.crazyapps.teamsubscription.repository;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.crazyapps.teamsubscription.Application;
import com.crazyapps.teamsubscription.data.DataProvider;
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
		Pilot pilot = new Pilot(1, "avatar", "be", true, true, true);
		Team team = DataProvider.newTeam();

		pilotRepository.save(pilot);
		assertNotNull(pilot.getId());
	}

	@Test
	public void testTeamRepository() {

	}

}

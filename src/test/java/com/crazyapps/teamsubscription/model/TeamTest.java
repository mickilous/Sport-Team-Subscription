package com.crazyapps.teamsubscription.model;

import static com.crazyapps.teamsubscription.data.DataProvider.newPilot;
import static com.crazyapps.teamsubscription.data.DataProvider.newTeam;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.crazyapps.teamsubscription.exception.BusinessException;
import com.crazyapps.teamsubscription.exception.BusinessException.Code;

public class TeamTest {

	@Test
	public void testSetMaxPilots() throws BusinessException {
		Team team = newTeam();

		team.setMaxPilots(1);
		team.setMaxPilots(2);
		team.setMaxPilots(3);
		team.setMaxPilots(4);

		try {
			team.setMaxPilots(0);
			fail("Team must not support 0 as MaxPilots");
		} catch (BusinessException e) {
			assertEquals(Code.TEAM_SIZE_UNSUPPORTED, e.getCode());
		}

		try {
			team.setMaxPilots(5);
			fail("Team must not support greater than 4 as MaxPilots");
		} catch (BusinessException e) {
			assertEquals(Code.TEAM_SIZE_UNSUPPORTED, e.getCode());
		}

	}

	@Test
	public void testAddPilot() throws BusinessException {
		Team team = newTeam();
		Pilot pilot = newPilot();

		team.setMaxPilots(2); // Team Admin + Pilot
		team.addPilot(pilot);

		try {
			team.addPilot(pilot);
			fail("Team must not support more pilots than MaxPilots");
		} catch (BusinessException e) {
			assertEquals(Code.TEAM_SIZE_EXCEDEED, e.getCode());
		}

	}
}

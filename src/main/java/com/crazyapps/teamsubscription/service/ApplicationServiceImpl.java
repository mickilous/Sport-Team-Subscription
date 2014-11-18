package com.crazyapps.teamsubscription.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crazyapps.teamsubscription.exception.BusinessException;
import com.crazyapps.teamsubscription.model.Pilot;
import com.crazyapps.teamsubscription.model.Team;
import com.crazyapps.teamsubscription.repository.PilotRepository;
import com.crazyapps.teamsubscription.repository.TeamRepository;

@Service
public class ApplicationServiceImpl implements ApplicationService {

	@Autowired
	PilotRepository pilotRepository;

	@Autowired
	TeamRepository teamRepository;

	@Override
	public Pilot createPilot(String email, Long fbId, String avatar, String nationality) {
		Pilot pilot = new Pilot(email, fbId, avatar, nationality, false, false, false);
		return pilotRepository.save(pilot);
	}

	@Override
	public Pilot updatePilot(long id, boolean isLookingForTeam, boolean isKHO, boolean isAPC8) {
		Pilot pilot = pilotRepository.findOne(id);
		pilot.setLookingForTeam(isLookingForTeam);
		pilot.setKHO(isKHO);
		pilot.setAPC8(isAPC8);
		return pilotRepository.save(pilot);
	}

	@Override
	public Team createTeam(String name, Integer number, String avatar, Integer maxPilots, Pilot teamAdmin, boolean lookingForPilots) {
		Team team = new Team(name, number, avatar, maxPilots, teamAdmin, lookingForPilots);
		return teamRepository.save(team);
	}

	@Override
	public Team updateTeam(long id, String name, Integer number, String avatar, Integer maxPilots, boolean isLookingForPilots) throws BusinessException {
		Team team = teamRepository.findOne(id);
		team.setName(name);
		team.setNumber(number);
		team.setAvatar(avatar);
		team.setMaxPilots(maxPilots);
		team.setLookingForPilots(isLookingForPilots);
		return teamRepository.save(team);
	}

}

package com.crazyapps.teamsubscription.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crazyapps.teamsubscription.model.Pilot;
import com.crazyapps.teamsubscription.repository.PilotRepository;

@Service
public class ApplicationServiceImpl implements ApplicationService {

	@Autowired
	PilotRepository pilotRepository;

	@Override
	public Pilot createPilot(String email, Long fbId, String avatar, String nationality) {
		Pilot pilot = new Pilot(email, fbId, avatar, nationality, false, false, false);
		return pilotRepository.save(pilot);
	}

	@Override
	public Pilot updatePilot(long id, boolean isLookingForTeam, boolean isKHO, boolean isAPC8) {
		// TODO Auto-generated method stub
		return null;
	}

}

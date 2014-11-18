package com.crazyapps.teamsubscription.service;

import com.crazyapps.teamsubscription.exception.BusinessException;
import com.crazyapps.teamsubscription.model.Pilot;
import com.crazyapps.teamsubscription.model.Team;

public interface ApplicationService {

	Pilot createPilot(String email, Long fbId, String avatar, String nationality);

	Pilot updatePilot(long id, boolean isLookingForTeam, boolean isKHO, boolean isAPC8);

	Team createTeam(String name, Integer number, String avatar, Integer maxPilots, Pilot teamAdmin, boolean lookingForPilots);

	Team updateTeam(long id, String name, Integer number, String avatar, Integer maxPilots, boolean lookingForPilots) throws BusinessException;

}

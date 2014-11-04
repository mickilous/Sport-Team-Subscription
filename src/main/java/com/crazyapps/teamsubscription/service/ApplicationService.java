package com.crazyapps.teamsubscription.service;

import com.crazyapps.teamsubscription.model.Pilot;

public interface ApplicationService {

	Pilot createPilot(String email, Long fbId, String avatar, String nationality);

	Pilot updatePilot(long id, boolean isLookingForTeam, boolean isKHO, boolean isAPC8);

}

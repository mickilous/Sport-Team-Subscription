package com.crazyapps.teamsubscription.repository;

import org.springframework.data.repository.CrudRepository;

import com.crazyapps.teamsubscription.model.Pilot;

public interface PilotRepository extends CrudRepository<Pilot, Long> {

	Pilot findByFbId(Long fbId);

}

package com.crazyapps.teamsubscription.repository;

import org.springframework.data.repository.CrudRepository;

import com.crazyapps.teamsubscription.model.Team;

public interface TeamRepository extends CrudRepository<Team, Long> {

}

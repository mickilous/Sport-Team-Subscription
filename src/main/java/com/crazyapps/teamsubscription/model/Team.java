package com.crazyapps.teamsubscription.model;

import static com.crazyapps.teamsubscription.exception.BusinessException.Code.TEAM_SIZE_UNSUPPORTED;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.FetchType.EAGER;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;

import com.crazyapps.teamsubscription.exception.BusinessException;
import com.crazyapps.teamsubscription.exception.BusinessException.Code;

@Entity
public class Team {

	private final int PILOTS_LIMIT = 4;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	private Long id;

	@Column
	@Getter
	private String name;

	@Column
	@Getter
	private Integer number;

	@Column
	@Getter
	private String avatar;

	@Column
	@Getter
	private Integer maxPilots;

	@OneToMany(mappedBy = "team", fetch = EAGER, cascade = PERSIST)
	@Getter
	private List<Pilot> pilots;

	@Column
	@Getter
	private boolean lookingForPilots;

	public Team() {
	}

	public Team(String name, Integer number, String avatar, Integer maxPilots, boolean lookingForPilots) {
		this.name = name;
		this.number = number;
		this.avatar = avatar;
		this.maxPilots = maxPilots;
		this.lookingForPilots = lookingForPilots;
		this.pilots = new ArrayList<Pilot>();
	}

	public void setMaxPilots(int maxPilots) throws BusinessException {

		if (maxPilots < 1 || maxPilots > PILOTS_LIMIT)
			throw new BusinessException(TEAM_SIZE_UNSUPPORTED);

		this.maxPilots = maxPilots;

	}

	public void addPilot(Pilot pilot) throws BusinessException {
		if (pilots.size() >= maxPilots)
			throw new BusinessException(Code.TEAM_SIZE_EXCEDEED);

		this.pilots.add(pilot);
	}

}

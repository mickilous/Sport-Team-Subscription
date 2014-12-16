package com.crazyapps.teamsubscription.model;

import static com.crazyapps.teamsubscription.exception.BusinessException.Code.TEAM_SIZE_UNSUPPORTED;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import com.crazyapps.teamsubscription.exception.BusinessException;
import com.crazyapps.teamsubscription.exception.BusinessException.Code;

@Entity(name = "TS_TEAM")
@EqualsAndHashCode(of = { "number"})
@ToString
public class Team {

	@Transient
	private final int PILOTS_LIMIT = 4;

	@Id
	@Column(name = "TEAM_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	private Long id;

	@Column(name = "NAME")
	@Getter
	@Setter
	private String name;

	@Column(name = "NUMBER")
	@Getter
	@Setter
	private Integer number;

	@Column(name = "AVATAR")
	@Getter
	@Setter
	private String avatar;

	@Column(name = "MAX_PILOTS")
	@Getter
	@Setter
	private Integer maxPilots;

	@OneToMany(mappedBy = "team", fetch = EAGER, cascade = PERSIST)
	@Getter
	private List<Pilot> pilots;

	@OneToOne(fetch = LAZY)
	@JoinColumn(name = "TEAM_ADMIN_PILOT_ID")
	@Getter
	private Pilot teamAdmin;

	@Column(name = "IS_LOOKING_FOR_PILOTS")
	@Getter
	@Setter
	private boolean isLookingForPilots;

	public Team() {
	}

	public Team(String name, Integer number, String avatar, Integer maxPilots, Pilot teamAdmin, boolean isLookingForPilots) {
		this.name = name;
		this.number = number;
		this.avatar = avatar;
		this.maxPilots = maxPilots;
		this.teamAdmin = teamAdmin;
		this.isLookingForPilots = isLookingForPilots;
		this.pilots = new ArrayList<Pilot>(Arrays.asList(teamAdmin));
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

package com.crazyapps.teamsubscription.model;

import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.FetchType.EAGER;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Entity
@EqualsAndHashCode(exclude = { "id"})
@ToString
public class Pilot {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	private Long id;

	@Column
	@Getter
	private String email;

	@Column
	@Getter
	private Long fbId;

	@Column
	@Getter
	private String avatar;

	@Column
	@Getter
	private String nationality;

	@Column
	@Getter
	private boolean isLookingForTeam;

	@Column
	@Getter
	private boolean isKHO;

	@Column
	@Getter
	private boolean isAPC8;

	@ManyToOne(fetch = EAGER, cascade = PERSIST)
	@JoinColumn(name = "team_id")
	private Team team;

	public Pilot(String email, long fbId, String avatar, String nationality, boolean isLookingForTeam, boolean isKHO, boolean isAPC8) {
		this.fbId = fbId;
		this.avatar = avatar;
		this.nationality = nationality;
		this.isLookingForTeam = isLookingForTeam;
		this.isKHO = isKHO;
		this.isAPC8 = isAPC8;
	}

}

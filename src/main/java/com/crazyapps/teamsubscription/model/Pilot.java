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
import lombok.Setter;
import lombok.ToString;

@Entity(name = "TS_PILOT")
@EqualsAndHashCode(exclude = { "id"})
@ToString
public class Pilot {

	@Id
	@Column(name = "PILOT_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	private Long id;

	@Column(name = "NAME")
	@Getter
	private String name;

	@Column(name = "EMAIL")
	@Getter
	private String email;

	@Column(name = "FACEBOOK_ID")
	@Getter
	private Long fbId;

	@Column(name = "AVATAR")
	@Getter
	private String avatar;

	@Column(name = "NATIONALITY")
	@Getter
	@Setter
	private String nationality;

	@Column(name = "IS_LOOKING_FOR_TEAM")
	@Getter
	@Setter
	private boolean isLookingForTeam;

	@Column(name = "IS_KHO")
	@Getter
	@Setter
	private boolean isKHO;

	@Column(name = "IS_APC8")
	@Getter
	@Setter
	private boolean isAPC8;

	@ManyToOne(fetch = EAGER, cascade = PERSIST)
	@JoinColumn(name = "TEAM_ID")
	private Team team;

	public Pilot() {
	}

	public Pilot(String email, long fbId, String avatar, String nationality, boolean isLookingForTeam, boolean isKHO, boolean isAPC8) {
		this.email = email;
		this.fbId = fbId;
		this.avatar = avatar;
		this.nationality = nationality;
		this.isLookingForTeam = isLookingForTeam;
		this.isKHO = isKHO;
		this.isAPC8 = isAPC8;
	}

}

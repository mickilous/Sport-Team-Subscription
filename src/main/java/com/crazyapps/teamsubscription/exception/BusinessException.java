package com.crazyapps.teamsubscription.exception;

import lombok.Getter;

@SuppressWarnings("serial")
public class BusinessException extends Exception {

	@Getter
	private Code code;

	public BusinessException(Code code) {
		super(code.name());
		this.code = code;
	}

	public enum Code {
		TEAM_SIZE_UNSUPPORTED, TEAM_SIZE_EXCEDEED;
	}

}

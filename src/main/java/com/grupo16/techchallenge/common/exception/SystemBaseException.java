package com.grupo16.techchallenge.common.exception;

public abstract class SystemBaseException extends RuntimeException {
	private static final long serialVersionUID = -6666280410119910018L;
	
	public abstract String getCode();
	public abstract Integer getHttpStatus();
	@Override
	public abstract String getMessage();

}

package com.grupo16.techchallenge.usuario.domain;

public enum TipoParentesco {
	
	PAI,
	MAE,
	IRMAO,
	IRMA;
	
	public static TipoParentesco getByOrdinal(int ordinal){
		TipoParentesco[] values = values();
		return values[ordinal];
	}	

}

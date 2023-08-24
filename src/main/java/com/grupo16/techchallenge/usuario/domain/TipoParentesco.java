package com.grupo16.techchallenge.usuario.domain;

public enum TipoParentesco {
	
	PAI,
	MAE,
	PADASTRO,
	MADASTRA,
	FILHO,
	FILHA,
	IRMAO,
	IRMA,
	TIO,
	TIA,
	PRIMO,
	PRIMA,
	SOGRO,
	SOGRA,
	NETO,
	NETA,
	GENRO,
	NORA,
	BISAVO,
	AVO,
	SOBRINHO,
	SOBRINHA,
	MADRINHA,
	PADRINHO,
	CUNHADO,
	CUNHADA,
	NAMORADA,
	NAMORADO;
	
	public static TipoParentesco getByOrdinal(int ordinal){
		TipoParentesco[] values = values();
		return values[ordinal];
	}	

}

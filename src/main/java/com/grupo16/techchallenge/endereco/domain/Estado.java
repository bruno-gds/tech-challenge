package com.grupo16.techchallenge.endereco.domain;

public enum Estado {

	//ATENÇÃO: a posição dos estados não deve ser alterada, pois irá afetar no banco.  

	AC,
	AL,
	AP,
	AM,
	BA,
	CE,
	ES,
	GO,
	MA,
	MT,
	MS,
	MG,
	PA,
	PB,
	PR,
	PE,
	PI,
	RJ,
	RN,
	RS,
	RO,
	RR,
	SC,
	SP,
	SE,
	TO,
	DF;

	public static Estado getByOrdinal(int ordinal){
		Estado[] values = values();
		return values[ordinal];
	}
}

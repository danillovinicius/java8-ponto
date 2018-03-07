package com.dvlima.ponto.enumeration;

public enum TipoRegistroEnum {
	E("Entrada", "Registro de entrada de ponto"), S("Saída", "Registro de saída de ponto");

	private String tipo;
	private String descricao;

	TipoRegistroEnum(String tipo, String descricao) {
		this.tipo = tipo;
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}

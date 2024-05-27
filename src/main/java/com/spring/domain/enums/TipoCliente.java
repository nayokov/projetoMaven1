package com.spring.domain.enums;

public enum TipoCliente {

	PESSOAFISICA(0, "Pessoa Física"),
	PESSOAJURIDICA(1, "Pessoa Jurídica");

	private int cod;
	private String descricao;

	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	// com static é possivel de ser executada mesmo sem instanciar objetos
	public static TipoCliente toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}

		for (TipoCliente tipoCliente : TipoCliente.values()) {
			if (cod.equals(tipoCliente.getCod())) {
				return tipoCliente;
			}

		}
		throw new IllegalArgumentException("Id inválido :" + cod);
	}

}

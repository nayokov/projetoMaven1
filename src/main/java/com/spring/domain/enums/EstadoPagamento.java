package com.spring.domain.enums;

public enum EstadoPagamento {

	PENDENTE(1, "Pndente"),
	QUITADO(2, "QUITADO"),
	CANCELADO(3, "CANCELADO");

	private int cod;
	private String estado;

	private EstadoPagamento(int cod, String estado) {
		this.cod = cod;
		this.estado = estado;
	}

	public int getCod() {
		return cod;
	}

	public String getEstado() {
		return estado;
	}

	// com static é possivel de ser executada mesmo sem instanciar objetos
	public static EstadoPagamento toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}

		for (EstadoPagamento estadoPagamento : EstadoPagamento.values()) {
			if (cod.equals(estadoPagamento.getCod())) {
				return estadoPagamento;
			}

		}
		throw new IllegalArgumentException("Id inválido :" + cod);
	}
}

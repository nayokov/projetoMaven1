package com.spring.domain;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.spring.domain.enums.EstadoPagamento;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)// Inheritance determina se cria uma tabela pra cada filho ou se cria uma tabela com ambos indo nulo para uma delas
public abstract class Pagamento implements Serializable {// pagamento abstrato pois so pode instanciar as filhas
	private static final long serialVersionUID = 1L;
	@Id
	private Integer id;
	private Integer estadoPagto;
	@JsonBackReference
	@OneToOne
	@JoinColumn(name = "pedido_id")
	@MapsId // garante que o id do pedido seja o mesmo do pagamento
	private Pedido pedido;

	public Pagamento() {

	}

	public Pagamento(Integer id, EstadoPagamento estadoPagto, Pedido pedido) {
		super();
		this.id = id;
		this.estadoPagto = estadoPagto.getCod();
		this.pedido = pedido;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EstadoPagamento getEstadoPagto() {
		return EstadoPagamento.toEnum(estadoPagto);
	}

	public void setEstadoPagto(EstadoPagamento estadoPagto) {
		this.estadoPagto = estadoPagto.getCod();
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pagamento other = (Pagamento) obj;
		return Objects.equals(id, other.id);
	}

}

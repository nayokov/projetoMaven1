package com.spring.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.spring.domain.enums.EstadoPagamento;

import jakarta.persistence.Entity;
@Entity
public class PagamentoBoleto extends Pagamento{
	private static final long serialVersionUID = 1L;
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataVencimento;
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataPagamento;
	
	public PagamentoBoleto() {
		
	}

	public PagamentoBoleto(Integer id, EstadoPagamento estadoPagto, Pedido pedido,Date dataVencimento, Date dataPagamento) {
		super(id, estadoPagto, pedido);
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	
	
	
	
}

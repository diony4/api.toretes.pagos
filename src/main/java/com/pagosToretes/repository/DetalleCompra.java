package com.pagosToretes.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

@Entity
@Table(name="detallecompra")

@NamedStoredProcedureQueries(value = {
		@NamedStoredProcedureQuery(name = "guardardetallecompra", procedureName = "f_registrar_detalle_compra", parameters = {
				
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "in_idcompra", type = Integer.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "in_listadetalle", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "out_resultado", type = String.class) })
				
						
})

public class DetalleCompra {
	
	@Id
	@Column(name="idcompra")
	private int idcompra;
	
	@Column(name="idbebida")
	private int idbebida;
	
	@Column(name="subtotal")
	private double subtotal;
	
	@Column(name="cantidad")
	private int cantidad;
	
	
	public DetalleCompra() {
		super();
		// TODO Auto-generated constructor stub
	}


	public DetalleCompra(int idcompra, int idbebida, double subtotal, int cantidad) {
		super();
		this.idcompra = idcompra;
		this.idbebida = idbebida;
		this.subtotal = subtotal;
		this.cantidad = cantidad;
	}


	public int getIdcompra() {
		return idcompra;
	}


	public void setIdcompra(int idcompra) {
		this.idcompra = idcompra;
	}


	public int getIdbebida() {
		return idbebida;
	}


	public void setIdbebida(int idbebida) {
		this.idbebida = idbebida;
	}


	public double getSubtotal() {
		return subtotal;
	}


	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	

}

package com.pagosToretes.repository;

import java.util.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;


@Entity
@Table(name = "compras")

@NamedStoredProcedureQueries(value = {
		@NamedStoredProcedureQuery(name = "guardarcompras", procedureName = "f_registrar_compra", parameters = {
				
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "in_idusuario", type = Integer.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "in_idsociocomercial", type = Integer.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "in_fechacompra", type = Date.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "in_tipopagocompra", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "in_montocompra", type = Double.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "in_estadocompra", type = Integer.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "in_ahorrocompra", type = Double.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "in_modalidad", type = Integer.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "in_direccion", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "out_resultado", type = String.class) })
		
				
		
})

public class Compras {

	@Id
	@Column(name="idcompra")
	private int idcompra;
	
	@Column(name="idusuario")
	private int idusuario;
	
	@Column(name="idsociocomercial")
	private int idsociocomercial;
	
	@Column(name="fechacompra")
	private Date fechacompra;
	
	@Column(name="tipopagocompra")
	private String tipopagocompra;
	
	@Column(name="montocompra")
	private double montocompra;
	
	@Column(name="estadocompra")
	private int estadocompra;
	
	@Column(name="ahorrocompra")
	private double ahorrocompra;
	
	@Column(name="modalidad")
	private int modalidad;
	
	@Column(name="direccion_usuario")
	private String direccion_usuario;
	
	
	public Compras() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Compras(int idcompra, int idusuario, int idsociocomercial, Date fechacompra, String tipopagocompra,
			double montocompra, int estadocompra, double ahorrocompra, int modalidad, String direccion_usuario) {
		super();
		this.idcompra = idcompra;
		this.idusuario = idusuario;
		this.idsociocomercial = idsociocomercial;
		this.fechacompra = fechacompra;
		this.tipopagocompra = tipopagocompra;
		this.montocompra = montocompra;
		this.estadocompra = estadocompra;
		this.ahorrocompra = ahorrocompra;
		this.modalidad = modalidad;
		this.direccion_usuario = direccion_usuario;
	}


	public int getIdcompra() {
		return idcompra;
	}


	public void setIdcompra(int idcompra) {
		this.idcompra = idcompra;
	}


	public int getIdusuario() {
		return idusuario;
	}


	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}


	public int getIdsociocomercial() {
		return idsociocomercial;
	}


	public void setIdsociocomercial(int idsociocomercial) {
		this.idsociocomercial = idsociocomercial;
	}


	public Date getFechacompra() {
		return fechacompra;
	}


	public void setFechacompra(Date fechacompra) {
		this.fechacompra = fechacompra;
	}


	public String getTipopagocompra() {
		return tipopagocompra;
	}


	public void setTipopagocompra(String tipopagocompra) {
		this.tipopagocompra = tipopagocompra;
	}


	public double getMontocompra() {
		return montocompra;
	}


	public void setMontocompra(double montocompra) {
		this.montocompra = montocompra;
	}


	public int getEstadocompra() {
		return estadocompra;
	}


	public void setEstadocompra(int estadocompra) {
		this.estadocompra = estadocompra;
	}


	public double getAhorrocompra() {
		return ahorrocompra;
	}


	public void setAhorrocompra(double ahorrocompra) {
		this.ahorrocompra = ahorrocompra;
	}


	public int getModalidad() {
		return modalidad;
	}


	public void setModalidad(int modalidad) {
		this.modalidad = modalidad;
	}


	public String getDireccion_usuario() {
		return direccion_usuario;
	}


	public void setDireccion_usuario(String direccion_usuario) {
		this.direccion_usuario = direccion_usuario;
	}


	
		
}

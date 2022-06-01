package com.pagosToretes.bean;


public class ListaDetalle {
	
	private int idcompra;
	private String listaDetalle;
	
	public ListaDetalle() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ListaDetalle(int idcompra, String listaDetalle) {
		super();
		this.idcompra = idcompra;
		this.listaDetalle = listaDetalle;
	}
	public int getIdcompra() {
		return idcompra;
	}
	public void setCompras(int idcompra) {
		this.idcompra = idcompra;
	}
	public String getListaDetalle() {
		return listaDetalle;
	}
	public void setListaDetalle(String listaDetalle) {
		this.listaDetalle = listaDetalle;
	}

	

}

package com.pagosToretes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pagosToretes.RepositoryI.DetalleCompraRepositoryI;
import com.pagosToretes.bean.ListaDetalle;
import com.pagosToretes.repository.DetalleCompra;

@Service
public class DetalleCompraServicio {
	
	@Autowired
	private DetalleCompraRepositoryI detalleCompraRepositoryI;
	
	public String guardarDetalleCompra(ListaDetalle detalle) {
		return detalleCompraRepositoryI.guardarDetalleCompra(detalle.getIdcompra(),detalle.getListaDetalle());
	}

}

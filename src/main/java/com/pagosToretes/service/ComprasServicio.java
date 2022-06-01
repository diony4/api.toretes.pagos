package com.pagosToretes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pagosToretes.RepositoryI.ComprasRepositoryI;
import com.pagosToretes.repository.Compras;



@Service
public class ComprasServicio {
	
	@Autowired
	private ComprasRepositoryI compraRepository;
	
	public String insertarCompra(Compras compra) throws Exception{
		return compraRepository.registrarCompra(
				compra.getIdusuario(),
				compra.getIdsociocomercial(),
				compra.getFechacompra(),
				compra.getTipopagocompra(),
				compra.getMontocompra(),
				compra.getEstadocompra(),
				compra.getAhorrocompra(),
				compra.getModalidad(),
				compra.getDireccion_usuario());
	}

}

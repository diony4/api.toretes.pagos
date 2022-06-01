package com.pagosToretes.RepositoryI;

import java.util.*;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pagosToretes.repository.Compras;


@Repository
public interface ComprasRepositoryI extends CrudRepository<Compras, Integer> {
	
	@Procedure(name = "guardarcompras")
	public String registrarCompra(
			@Param("in_idusuario") int in_idusuario,
			@Param("in_idsociocomercial") int in_idsociocomercial,		
			@Param("in_fechacompra") Date in_fechacompra,		
			@Param("in_tipopagocompra") String in_tipopagocompra,
			@Param("in_montocompra") double in_montocompra,
			@Param("in_estadocompra") int in_estadocompra,	
			@Param("in_ahorrocompra") double in_ahorrocompra,
			@Param("in_modalidad") int in_modalidad,
			@Param("in_direccion") String direccion
			);
}

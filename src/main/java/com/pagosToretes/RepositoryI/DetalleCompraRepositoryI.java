package com.pagosToretes.RepositoryI;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pagosToretes.repository.DetalleCompra;

@Repository
public interface DetalleCompraRepositoryI extends CrudRepository<DetalleCompra, Integer> {
	
	@Procedure(name="guardardetallecompra")
	public String guardarDetalleCompra(
			@Param("in_idcompra") int idcompra,
			@Param("in_listadetalle") String listadetalle);
	
}

package com.pagosToretes.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.pagosToretes.bean.ListaDetalle;
import com.pagosToretes.bean.Token;
import com.pagosToretes.bean.TokenApi;
import com.pagosToretes.repository.Compras;
import com.pagosToretes.service.ComprasServicio;
import com.pagosToretes.service.DetalleCompraServicio;
import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.common.IdentificationRequest;
import com.mercadopago.client.payment.PaymentClient;
import com.mercadopago.client.payment.PaymentCreateRequest;
import com.mercadopago.client.payment.PaymentPayerRequest;
import com.mercadopago.client.preference.PreferenceBackUrlsRequest;
import com.mercadopago.client.preference.PreferenceClient;
import com.mercadopago.client.preference.PreferenceItemRequest;
import com.mercadopago.client.preference.PreferenceRequest;
import com.mercadopago.resources.payment.Payment;
import com.mercadopago.resources.preference.Preference;
	
@RestController
@CrossOrigin(origins="*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT })
@RequestMapping("/api/pagostoretes")
public class PagosToretesController {
	

	
	@Autowired
	private ComprasServicio comprasServicio;
	
	@Autowired
	private DetalleCompraServicio detalleServicio;

	
	//STOREPROCEDURE INSERTAR COMPRA
	@RequestMapping(value="/compra/registrar",method = RequestMethod.POST)
	public ResponseEntity<?> postCompra(@RequestBody Compras compra) throws Exception{
				
		String data = comprasServicio.insertarCompra(compra);
		return new ResponseEntity<>(data,HttpStatus.OK);
	}
	
	//STOREPROCEDURE INSERTAR DETALLECOMPRA
	@RequestMapping(value="/detallecompra/registrar",method = RequestMethod.POST)
	public ResponseEntity<?> postDetalle(@RequestBody ListaDetalle detalle) throws Exception{
		
		String data = detalleServicio.guardarDetalleCompra(detalle);
		return new ResponseEntity<>(data,HttpStatus.OK);
	}
	
			
	// PAGAR EN MERCADO PAGO CHEKOUT PRO
	@RequestMapping(value="/pagar/tokenTarjeta", method = RequestMethod.POST)
	public ResponseEntity<?> realizarCompra(@RequestBody List<Token> token) throws Exception {
	//APP_USR-4241670256428229-050421-4637e71821726af5cf025ccd66e30a93-720653915  PRODUCCION
    //TEST-8168237410420976-022602-542fb7e6f0eefcd706cdef76abe415ed-720653915   PRUEBA 	
		String data = "";
			//MercadoPago.SDK.setClientId("4241670256428229");
			//MercadoPago.SDK.setClientSecret("6WYLdiLTvASg4qPPsYfeAPHRSU1K6zNt");
			MercadoPagoConfig.setAccessToken("TEST-7821903690306348-101720-ceb20f0d995968a05f390ba1b38caa3a-658221744");
			
	
			PreferenceBackUrlsRequest backUrls = PreferenceBackUrlsRequest.builder()
				       .success("http://localhost:8100/comprobante")
				       .pending("http://localhost:8100/nuevaReservaDetalle")
				       .failure("http://localhost:8100/nuevaReservaDetalle")
				       .build();
			PreferenceClient client = new PreferenceClient();
			// Crea un ítem en la preferencia
			List<PreferenceItemRequest> items = new ArrayList<>();
			for(Token t : token) {
				PreferenceItemRequest item =
						   PreferenceItemRequest.builder()
						       .title(String.valueOf(t.getNombre()))
						       .quantity(t.getCantidad())
						       .unitPrice(new BigDecimal(String.valueOf(t.getPrecio())))
						       .build();
				items.add(item);
			}
	
			
			PreferenceRequest request = PreferenceRequest.builder()
					.backUrls(backUrls)
					.autoReturn("approved")
					.items(items).build();

			Preference c = client.create(request);
			
			Gson gson = new Gson();
			data = gson.toJson(c);
			
		return new ResponseEntity<>(data,HttpStatus.OK);
		
	}
	
	
	// PAGAR EN MERCADO PAGO CHEKOUT API
	@RequestMapping(value="/pagar/token/api", method = RequestMethod.POST)
	public ResponseEntity<?> pagarApi(@RequestBody TokenApi token) throws Exception{
		MercadoPagoConfig.setAccessToken("TEST-7821903690306348-101720-ceb20f0d995968a05f390ba1b38caa3a-658221744");
		String data = "";
		PaymentClient client = new PaymentClient();
		
		PaymentCreateRequest paymentCreateRequest =
		   PaymentCreateRequest.builder()
		       .transactionAmount(token.getTotal())
		       .token(token.getToken())
		       .description(token.getDescripcion())
		       .statementDescriptor("Toretes Restaurant")
		       .installments(1)
		       .paymentMethodId(token.getTipo())
		       .payer(
		           PaymentPayerRequest.builder()
		               .email(token.getEmail())
		               .firstName(token.getApellidoUsuario())         
		               .identification(
		                   IdentificationRequest.builder()
		                       .type("DNI")
		                       .number(token.getDni())
		                       .build())
		               .build())
		       .build();
		
		Payment c = client.create(paymentCreateRequest);
		Gson gson = new Gson();
		data = gson.toJson(c);

		return new ResponseEntity<>(data,HttpStatus.OK);
	}
	
	
}

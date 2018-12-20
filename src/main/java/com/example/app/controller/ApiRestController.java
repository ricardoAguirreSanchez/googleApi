package com.example.app.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.service.GoogleService;

@RestController
public class ApiRestController {
	
	private static Logger log = Logger.getLogger(ApiRestController.class);
	
	@Autowired
	GoogleService googleService;
	
	/**
	 * Endpoint para consultar la existencia de un doc por id
	 *  
	 * */
	@RequestMapping(value = "/search-in-doc/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getUser(@PathVariable("id") long id) {
		log.info("[GET search-in-doc] Buscando documento de id:" + id);
		String resultado = new String();
		resultado = "";
		try {
			//Le pedimos al service que haga la busqueda
			resultado = googleService.findDocumentById(id);
		} catch (Exception e) {
			log.error("[GET search-in-doc] Error buscando documento de id:" + id);
			return new ResponseEntity<String>("HTTP/1.1 500 ERROR - Fallo al tratar de usar la API de Google!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if("OK".equals(resultado)) {
			return new ResponseEntity<String>("HTTP/1.1 200 OK - Existe el documento!", HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("HTTP/1.1 404 NOT FOUND - No encontrado!", HttpStatus.NOT_FOUND);
		}
	}
	
//	@RequestMapping(value = "/file/", method = RequestMethod.POST)
//	public ResponseEntity<String> createUser(@RequestBody DocumentoDTO documento) {
//		
//		System.out.println("Tratando de crear al usuario: " + userNew.getUsername());
//		
//		if (userService.isUserExist(userNew)) {
//			return new ResponseEntity<String>(HttpStatus.CONFLICT);// mando conflicto pork ya existe el user
//		}
//		
//		userService.saveUser(userNew);
//		System.out.println("Se creo al usuario");
//		
//		//aca estamos devolviendo un string, ejemplo de json esta en getUser 
//		return new ResponseEntity<String>("Usuario agregado!!", HttpStatus.OK);
//	}
}

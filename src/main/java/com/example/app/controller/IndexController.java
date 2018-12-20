package com.example.app.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
	
	private static Logger log = Logger.getLogger(IndexController.class);

	/**
	 * Endpoint para controlar que este levantado el apiRest
	 *  
	 * */
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getIndex() {
		log.info("[INDEX] solicitando saludo inicial...");
		return new ResponseEntity<String>("Hola que hace?...", HttpStatus.OK);
	}
}
package com.example.app.service.imple;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.example.app.service.GoogleService;

@Service
public class GoogleServiceImpl implements GoogleService {

	private static Logger log = Logger.getLogger(GoogleServiceImpl.class);
	
	@Override
	public String findDocumentById(long id) {
		log.info("[GoogleService] - A punto de consumir la api... ");
		
		//logica posta--------------------------------------------
		
		
		return "OK";
	}
	
}

package fr.devoxx.spring.mission.utils;

import java.io.InputStream;

public class NotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotFoundException(Integer id) {
		super("Could not find stone with position " +id);
	}

	public NotFoundException() {
		// TODO Auto-generated constructor stub
	}

	public NotFoundException(String message) {
		super("Could not create mission because " + message);
	}


	
}

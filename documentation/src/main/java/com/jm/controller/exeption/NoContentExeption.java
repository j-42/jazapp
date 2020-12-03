package com.jm.controller.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoContentExeption extends Throwable {
	
	public NoContentExeption(String s) {
		super(s);
	}
	
}

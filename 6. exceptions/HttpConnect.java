package com.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

public class HttpConnect {
	
	/**
	 * 
	 * @param destination
	 * @param data
	 * @param partner
	 * @throws IOException
	 * @throws IllegalArgumentException generated if destination < 0 || destination > 1
	 */
	public static String send(int destination, String data, String partner) throws IOException {
		//we mentioned throws because any other method implementing send should know about the exception that
		// and hence it acts as a marker
		System.out.println("\nInside send ...");
		String response = "success";
		
		if (destination < 0 || destination > 1) {
			throw new IllegalArgumentException();
		}
		
		if (destination == 0){
			throw new FileNotFoundException();
		} else if (destination == 1) {
			//throw new IOException();
			response = "<result><code>success</code></result>";
		}
		
		System.out.println("\nEnd of send ...");		
		return response;
	}
}
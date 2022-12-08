package com.example.springbootmongo;

import java.util.ResourceBundle;

public class Messages {
	
	public static final String PERSON_NOT_FOUND = "person.not.found";

	public static String get(String messageKey) {
		return ResourceBundle.getBundle("messages").getString(messageKey);
	}
    
	public static String format(String messageKey, Object... args) {
		return String.format(get(messageKey), args);
	}
	
}

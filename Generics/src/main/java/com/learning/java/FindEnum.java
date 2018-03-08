package com.learning.java;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class to find the type of enum
 * 
 * @author preethi
 *
 */
public class FindEnum {
	Logger logger = Logger.getLogger(FindEnum.class.getName());

	/**
	 * Method to find the instance of enum
	 * 
	 * @param enumClass
	 * 			Class for enum instance
	 * @param value
	 * 			value for enum instnace
	 * @return
	 * 		return enum instance
	 */
	public <T, E> E findEnum(Class<E> enumClass, T value) {

		Method[] methods = enumClass.getDeclaredMethods();
		for (E values : enumClass.getEnumConstants()) {
			for (Method method : methods) {
				if (method.getName().equalsIgnoreCase("valueOf")) {
					try {
						if (method.invoke(values).equals(value)) {
							return values;
						}
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						logger.log(Level.INFO, String.valueOf(e.getStackTrace()));
					}
				}
			}
		}
		return null;
	}
}
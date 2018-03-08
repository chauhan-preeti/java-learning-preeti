package com.learning.java;

import java.util.HashMap;
import java.util.Map;

/**
 * Enum for priority 
 * 
 * @author preethi
 *
 */
public enum Priority {

	PLATINUM(1), GOLD(2), SILVER(3);
	private Integer priorityCode;

	private Priority(Integer priorityCode) {
		this.priorityCode = priorityCode;
	}

	public Integer getPriorityCode() {
		return priorityCode;
	}

	protected void setPriorityCode(Integer priorityCode) {
		this.priorityCode = priorityCode;
	}
	
	 private static Map<Integer, Priority> map = new HashMap<>();
		
	 static {
	        for (Priority priorityEnum : Priority.values()) {
	            map.put(priorityEnum.priorityCode, priorityEnum);
	        }
	    }
	 
	 public static <T> Priority valueOf(T val) {
	        return map.get(val);
	    }

}

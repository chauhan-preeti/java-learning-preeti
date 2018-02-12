package com.learning.java;

public enum Priority {
	
	PLATINUM(1),GOLD(2),SILVER(3);
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

}

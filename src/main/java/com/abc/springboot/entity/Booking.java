package com.abc.springboot.entity;

import java.time.LocalDate;

public class Booking {
    private String memberName;
    private String className;
    private LocalDate participationDate;
    
    public Booking(String memberName, String className, LocalDate participationDate) {
        this.memberName = memberName;
        this.className = className;
        this.participationDate = participationDate;
    }
    
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public LocalDate getParticipationDate() {
		return participationDate;
	}
	public void setParticipationDate(LocalDate participationDate) {
		this.participationDate = participationDate;
	}
	@Override
	public String toString() {
		return "Booking [memberName=" + memberName + ", className=" + className + ", participationDate="
				+ participationDate + "]";
	}
	
	

    
}


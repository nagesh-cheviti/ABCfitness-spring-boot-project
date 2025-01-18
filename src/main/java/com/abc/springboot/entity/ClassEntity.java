package com.abc.springboot.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class ClassEntity {
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalTime startTime;
    private int duration;
    private int capacity;
    private List<LocalDate> scheduledDates;
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public LocalTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public List<LocalDate> getScheduledDates() {
		return scheduledDates;
	}
	public void setScheduledDates(List<LocalDate> scheduledDates) {
		this.scheduledDates = scheduledDates;
	}
	@Override
	public String toString() {
		return "ClassEntity [name=" + name + ", startDate=" + startDate + ", endDate=" + endDate + ", startTime="
				+ startTime + ", duration=" + duration + ", capacity=" + capacity + ", scheduledDates=" + scheduledDates
				+ "]";
	}

    
}


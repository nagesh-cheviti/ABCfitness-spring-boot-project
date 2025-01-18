package com.abc.springboot.service;

import org.springframework.stereotype.Service;

import com.abc.springboot.entity.ClassEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClassService {
    private final List<ClassEntity> classes = new ArrayList<>();

    public void createClass(ClassEntity classEntity) {
        if (classEntity.getEndDate().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("End date must be in the future.");
        }
        
        if (classEntity.getEndDate().isBefore(classEntity.getStartDate())) {
            throw new IllegalArgumentException("End date must be greater than or equal to the start date.");
        }

        if (classEntity.getCapacity() < 1) {
            throw new IllegalArgumentException("Class capacity must be at least 1.");
        }

        List<LocalDate> dates = classEntity.getStartDate()
                .datesUntil(classEntity.getEndDate().plusDays(1))
                .toList();
        classEntity.setScheduledDates(dates);
        classes.add(classEntity);
    }

    public List<ClassEntity> getClasses() {
        return classes;
    }
}


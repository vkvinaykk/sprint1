package com.employeepayroll.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeepayroll.entity.PublicHolidays;

public interface PublicHolidaysRepository extends JpaRepository<PublicHolidays,Integer> {
boolean findByHolidayDate(LocalDate date);
}

package com.employeepayroll.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="public_holidays")
public class PublicHolidays {
	@Id
	@Column(name = "holiday_id")
	int holidayId;
	@Column(name = "occassion_desc")
	String occassionDescription;
	@Column(name = "holiday_date")
	LocalDate holidayDate;

	public PublicHolidays() {
	}

	public PublicHolidays(int holidayId, String occassionDescription, LocalDate holidayDate) {
		super();
		this.holidayId = holidayId;
		this.occassionDescription = occassionDescription;
		this.holidayDate = holidayDate;
	}

	public int getHolidayId() {
		return holidayId;
	}

	public void setHolidayId(int holidayId) {
		this.holidayId = holidayId;
	}

	public String getOccassionDescription() {
		return occassionDescription;
	}

	public void setOccassionDescription(String occassionDescription) {
		this.occassionDescription = occassionDescription;
	}

	public LocalDate getHolidayDate() {
		return holidayDate;
	}

	public void setHolidayDate(LocalDate holidayDate) {
		this.holidayDate = holidayDate;
	}

}

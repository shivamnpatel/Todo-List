package com.shivam.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

@Entity
@Table(name = "todos")
public class Todo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String userEmail;

	@Size(min = 10, message = "Enter at least 10 characters")
	private String description;

	@Temporal(TemporalType.DATE)
	private Date targetDate;

	public Todo() {

	}

	public Todo(String userEmail, String description, Date targetDate) {
		this.userEmail = userEmail;
		this.description = description;
		this.targetDate = targetDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", userEmail=" + userEmail + ", description=" + description + ", targetDate="
				+ targetDate + "]";
	}

}
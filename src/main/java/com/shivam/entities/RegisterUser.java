package com.shivam.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class RegisterUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	@NotBlank(message = "* Username cannot be blank")
	@Size(min = 5, message = "* Minimum 5 char")
	private String userName;
	@NotBlank(message = "* Email cannot be blank")
	private String email;
	@NotBlank(message = "* Password cannot be blank")
	private String password;

	public RegisterUser() {
		
	}
	
	public RegisterUser(int userId, String userName, String email, String password) {
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "RegisterDTO [userId=" + userId + ", userName=" + userName + ", email=" + email + ", password="
				+ password + "]";
	}

}

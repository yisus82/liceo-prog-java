package com.liceolapaz.des.jprf;

import java.net.URL;

public class Usuario {
	private int id;
	private String email;
	private String firstName;
	private String lastName;
	private URL avatar;
	
	public Usuario(int id, String email, String firstName, String lastName, URL avatar) {
		super();
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.avatar = avatar;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public URL getAvatar() {
		return avatar;
	}

	public void setAvatar(URL avatar) {
		this.avatar = avatar;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", avatar=" + avatar + "]";
	}
}

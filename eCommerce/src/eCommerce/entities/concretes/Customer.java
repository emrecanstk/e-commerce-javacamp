package eCommerce.entities.concretes;

import eCommerce.entities.abstracts.Entity;

public class Customer implements Entity {
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
	public Customer(int id, String firstName, String lastName, String email, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
	
}

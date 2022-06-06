package eCommerce.core.abstracts;

import eCommerce.entities.concretes.Customer;

public interface EmailService {
	boolean validator(Customer customer);
}

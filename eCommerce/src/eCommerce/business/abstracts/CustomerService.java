package eCommerce.business.abstracts;

import java.util.List;

import eCommerce.entities.concretes.Customer;

public interface CustomerService {
	void memberAdd(Customer customer);
	void memberDelete(Customer customer);
	void memberUpdate(Customer customer);
	List<Customer> getAll();
	void memberAddWithGoogle(String email, String passport);
}

package eCommerce.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eCommerce.dataAccess.abstracts.CustomerDao;
import eCommerce.entities.concretes.Customer;

public class HibernateCustomerDao implements CustomerDao {
	
	List<Customer> customerList = new ArrayList<Customer>();
	
	@Override
	public void add(Customer customer) {
		System.out.println("added with hibernate: "+ customer.getFirstName());
		this.customerList.add(customer);
		
	}

	@Override
	public void delete(Customer customer) {
		System.out.println("deleted with hibernate: "+ customer.getFirstName());
		this.customerList.remove(customer);
		
	}

	@Override
	public void update(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

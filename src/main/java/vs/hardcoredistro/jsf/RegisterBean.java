package vs.hardcoredistro.jsf;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import vs.hardcoredistro.entities.Customer;
import vs.hardcoredistro.services.CustomerService;

@Named
@RequestScoped
public class RegisterBean {
	
	@Inject
	private CustomerService customerService;

	private String email;
	private String password;
	private String name;
	private String address;
	private String city;
	private String zipcode;
	private String country;

	public void register() {
		Customer reg = new Customer(email, password, name);
		reg.setName(name);
		reg.setAddress(address);
		reg.setCity(city);
		reg.setZipcode(zipcode);
		reg.setCountry(country);
		customerService.create(reg);
		clear();
	}
	
	private void clear() {
		email = null;
		password = null;
		name = null;
		address = null;
		city = null;
		zipcode = null;
		country = null;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}

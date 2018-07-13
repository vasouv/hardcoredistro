package vs.hardcoredistro.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "CUSTOMER")
public class Customer {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "cemail")
	private String email;

	@NotNull
	@Column(name = "cpassword")
	private String password;

	@NotNull
	@Column(name = "cname")
	private String name;

	@NotNull
	@Column(name = "caddress")
	private String address;

	@NotNull
	@Column(name = "ccity")
	private String city;

	@NotNull
	@Column(name = "czipcode")
	private String zipcode;

	@NotNull
	@Column(name = "ccountry")
	private String country;

	public Customer() {

	}

	public Customer(@NotNull String email, @NotNull String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

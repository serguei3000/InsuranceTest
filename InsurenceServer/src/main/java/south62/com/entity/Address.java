package south62.com.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class Address implements Serializable {
	private static final long serialVersionUID = -6966934116551219193L;
	
	@NotNull
	@Column
	protected String zipCode;
	
	@NotNull
	@Column
	protected String state;
	
	@NotNull
	@Column
	protected String province;
	
	@NotNull
	@Column
	protected String region;
	
	@NotNull
	@Column
	protected String city;
	
	@NotNull
	@Column
	protected String street;
	
	@NotNull
	@Column
	protected String household;
	
	@Column
	protected String corpus;
	
	@Column
	protected String building;
	
	@Column
	protected String flat;
	
	public Address() {};

	public Address(@NotNull String zipCode, @NotNull String state, @NotNull String province, @NotNull String region,
			@NotNull String city, @NotNull String street, @NotNull String household, String corpus, String building,
			String flat) {
		super();
		this.zipCode = zipCode;
		this.state = state;
		this.province = province;
		this.region = region;
		this.city = city;
		this.street = street;
		this.household = household;
		this.corpus = corpus;
		this.building = building;
		this.flat = flat;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHousehold() {
		return household;
	}

	public void setHousehold(String household) {
		this.household = household;
	}

	public String getCorpus() {
		return corpus;
	}

	public void setCorpus(String corpus) {
		this.corpus = corpus;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getFlat() {
		return flat;
	}

	public void setFlat(String flat) {
		this.flat = flat;
	}
	
}

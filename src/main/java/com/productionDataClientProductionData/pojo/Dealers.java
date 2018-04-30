package com.productionDataClientProductionData.pojo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name ="Dealers")
public class Dealers implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	public Dealers() {
		
	}
	
	
	public Dealers(String id, String code, String name, String address1, String address2, String city, String zip,
			String parentcode, boolean active, Countries countries, State_provinces state_provinces,
			Provider_codes providerCodes) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.zip = zip;
		this.parentcode = parentcode;
		this.active = active;
		this.countries = countries;
		this.state_provinces = state_provinces;
		this.providerCodes = providerCodes;
	}




	@Id
    @JsonProperty("id")
	private String id;
	
	@Column(name ="code")
	private String code;
	
	@Column(name ="DealerNames")
	private String name;
	
	@Column(name ="address1")
	private String address1;
	@Column(name="address2")
	private String address2;
	@Column(name="City")
	private String city;
	
	@Column(name ="Zip")
	private String zip;
	
	@Column(name="ParentCodes")
	private String parentcode;
	
	@Column(name="Active")
	@Type(type="true_false")
	private boolean active;
	
	@OneToOne(cascade =CascadeType.ALL)
	@JsonIgnore
	private Countries countries;
	@OneToOne(cascade =CascadeType.ALL)
	private State_provinces state_provinces;
	@ManyToOne(cascade=CascadeType.ALL)
	private Provider_codes providerCodes;
	@Transient
	private boolean isItTrue= false;
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getZip() {
		return zip;
	}


	public void setZip(String zip) {
		this.zip = zip;
			isItTrue=false;
	}
	public boolean dontAddData(){
		return isItTrue;
	
	}

	public State_provinces getState_provinces() {
		return state_provinces;
	}


	public void setState_provinces(State_provinces state_provinces) {
		this.state_provinces = state_provinces;
	}


	public String getParent_code() {
		return parentcode;
	}

	public void setParent_code(String parent_code) {
		this.parentcode = parent_code;
	}

	public Countries getCountries() {
		return countries;
	}

	public void setCountries(Countries address_country) {
		this.countries = address_country;
	}
	

	public State_provinces getAddress_state_province() {
		return state_provinces;
	}




	public void setAddress_state_province(State_provinces state_provinces) {
		this.state_provinces = state_provinces;
	}




	public String getAddress1() {
		return address1;
	}






	public void setAddress1(String address1) {
		this.address1 = address1;
	}






	public String getAddress2() {
		return address2;
	}






	public void setAddress2(String address2) {
		this.address2 = address2;
	}






	public String getCity() {
		return city;
	}






	public void setCity(String city) {
		this.city = city;
	}






	public boolean getActive() {
		return active;
	}






	public void setActive(Boolean active) {
		this.active = active;
	}






	public Provider_codes getProvider_codes() {
		return providerCodes;
	}

	public void setProvider_codes(Provider_codes provider_code) {
		this.providerCodes = provider_code;
	}






	@Override
	public String toString() {
		return "Dealers [id=" + id + ", code=" + code + ", name=" + name + ", parentcode=" + parentcode + ", countries="
				+ countries + ", state_provinces=" + state_provinces + ", providerCodes=" + providerCodes + "]";
	}



	

	
	
}

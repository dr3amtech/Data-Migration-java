package com.productionDataClientProductionData.pojo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.productionDataClientProductionData.impl.ApiSuperClass;


@Entity
@Table(name ="ProviderCodes")
public class Provider_codes  implements ApiSuperClass ,Serializable {

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Provider_codes() {}
	
	 
	 
	
	 public Provider_codes(String id, String code) {
		super();
		this.id = id;
		this.code = code;
	}



	@Id
	@Column(name ="id")
	private String id;
	
	@Column(name="Code")
	private String code;

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




	@Override
	public String toString() {
		return "Provider_codes [id=" + id + ", code=" + code + "]";
	}




	@Override
	public Map<? extends String, ? extends Object> getAdditionalProperties() {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public List<String> l1(String nothing) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
}

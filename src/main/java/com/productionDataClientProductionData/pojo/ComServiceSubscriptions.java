package com.productionDataClientProductionData.pojo;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.productionDataClientProductionData.impl.ApiSuperClass;

@Entity
@Table(name ="ComServiceSubscriptions")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "startDate","endDate","subscriptionLength" })
@JsonIgnoreProperties(ignoreUnknown = true)
public class ComServiceSubscriptions implements  ApiSuperClass,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;





	public ComServiceSubscriptions() {
		
	}
	

	


	




	public ComServiceSubscriptions(String id, Date startDate, Date endDate, Integer subscriptionLength,
			Map<String, Object> additionalProperties) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.subscriptionLength = subscriptionLength;
		this.additionalProperties = additionalProperties;
	}










	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}
	@Id
	@JsonProperty("id")
	private String id;
	@Column(name = "startDate")
	@JsonProperty("startDate")
	private Date startDate;
	@Column(name ="endDate")
	@JsonProperty("endDate")
	private Date endDate;
	
	@Column(name=" subscriptionLength")
	@JsonProperty("subscriptionLength")
	private Integer subscriptionLength;
	@Transient
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
	@Transient
	public final List<String> l1 = new ArrayList<String>();
	
	@Transient
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	
	
	

	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}





	@JsonProperty("startDate")
	public Date getStartDate() {
		return startDate;
	}

	@JsonProperty("startDate")
	public void setStartDate(String startDate) {
		try {
		this.startDate = simpleDateFormat.parse(startDate);
		}catch(ParseException e) {
			e.printStackTrace();
		}
	}

	@JsonProperty("endDate")
	public Date getEndDate() {
		return endDate;
	}

	@JsonProperty("endDate")
	public void setEndDate(String endDate) {
		try {
		
		this.endDate = (Date)simpleDateFormat.parse(endDate);
		}catch(ParseException e) {
			e.printStackTrace();
		}
	}

	@JsonProperty("subscriptionLength")
	public Integer getSubscriptionLength() {
		return subscriptionLength;
	}

	@JsonProperty("subscriptionLength")
	public void setSubscriptionLength(Integer subscriptionLength) {
		this.subscriptionLength = subscriptionLength;
	}


	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}


	@Override
	public List<String> l1(String nothing) {
			return l1;
	}










	@Override
	public String toString() {
		return "ComServiceSubscriptions [id=" + id + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", subscriptionLength=" + subscriptionLength + "]";
	}





	
	
	

}
package fr.istic.miage.m1.tpNosql;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

@Entity("adresses")
public class Adress {
	
	@Id ObjectId id;
	private String street;
	private String city;
	private String postCode;
	private String country;
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Adress [street=" + street + ", city=" + city + ", postCode="
				+ postCode + ", country=" + country + "]";
	}
	
	

}

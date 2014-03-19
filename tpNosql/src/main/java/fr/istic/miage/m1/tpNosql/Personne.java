package fr.istic.miage.m1.tpNosql;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Embedded;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Reference;

@Entity("personnes")
public class Personne {
	 
	@Id ObjectId id;
	 
	private String name;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Embedded private List<Adress> liste_adresses = new ArrayList<Adress>();


	public void setAddress(Adress address) {
		// TODO Auto-generated method stub
		liste_adresses.add(address);
	}
	@Override
	public String toString() {
		return "Personne [name=" + name + "]";
	}
	
	public List<Adress> get_Liste_adresses () {
		return liste_adresses;
	}
	

}

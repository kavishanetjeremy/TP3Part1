package fr.istic.miage.m1.tpNosql;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Reference;

@Entity("articles")
public class Article {

	@Id private ObjectId id;
	private String name;
	private int stars;
	
	@Reference private List<Personne> liste_acheteur = new ArrayList<Personne>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
	}
	
	public void ajoute_acheteur(Personne p){
		liste_acheteur.add(p);
	}
	@Override
	public String toString() {
		return "Article [name=" + name + ", stars=" + stars + "]";
	}
	
	public List<Personne> get_Liste_acheteur() {
		return liste_acheteur;
	}
}

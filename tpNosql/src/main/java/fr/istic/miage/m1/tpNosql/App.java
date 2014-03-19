package fr.istic.miage.m1.tpNosql;

import java.net.UnknownHostException;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws UnknownHostException
    {
    	Morphia morphia = new Morphia();   

        Mongo mongo = new Mongo();

        morphia.map(Personne.class).map(Adress.class);

        Datastore ds = morphia.createDatastore(mongo, "my_database");

        // creation des articles
        
        Article a = new Article();
        Article a2 = new Article();
        
        a.setName("01net");
        a.setStars(5);
        
        a2.setName("l'ordinateur c'est geniale");
        a.setStars(10);
        
       
       
        // creation de personnes et des adresses qui leurs corespond
        Personne p = new Personne();

        p.setName("Tintin");

        Adress address = new Adress();

        address.setStreet("123 Some street");

        address.setCity("Some city");

        address.setPostCode("123 456");

        address.setCountry("Some country");

        //set address

        p.setAddress(address);

        // Save p the POJO

        ds.save(p);
        
        
        
        Personne p2 = new Personne();

        p2.setName("Kavishan");

        Adress address2 = new Adress();

        address2.setStreet("quelque part a bruz");

        address2.setCity("Bruz");

        address2.setPostCode("35170");

        address2.setCountry("France");
        
        p2.setAddress(address2);

        // Save p2  the POJO

        ds.save(p2);
        
        
        
        
        Personne p3 = new Personne();

        p3.setName("Jeremy");

        Adress address3 = new Adress();

        address3.setStreet("gregorien de pure souche");

        address3.setCity("St gregoire");

        address3.setPostCode("35760");

        address3.setCountry("France");
        
        p3.setAddress(address3);

        // Save p3 the POJO

        ds.save(p3);
        

        a.ajoute_acheteur(p);
        a2.ajoute_acheteur(p2);
        a2.ajoute_acheteur(p3);
        
        ds.save(a);
        ds.save(a2);
        
        ds.save(address);
        ds.save(address2);
        ds.save(address3);
         
        
        for (Article art : ds.find(Article.class)) {
            System.out.println(art.toString());
            for (Personne pers : art.get_Liste_acheteur()) {
            	System.out.println("          " + pers.toString());
            	for (Adress ad : pers.get_Liste_adresses()) {
            		System.out.println("                                       " + ad.toString());
            	}
            }
        }
      
    }
}

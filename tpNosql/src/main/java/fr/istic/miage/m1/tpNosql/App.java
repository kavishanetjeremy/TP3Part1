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

       

        Personne p = new Personne();

        p.setName("Tintin");

        Adress address = new Adress();

        address.setStreet("123 Some street");

        address.setCity("Some city");

        address.setPostCode("123 456");

        address.setCountry("Some country");

        //set address

        p.setAddress(address);

        // Save the POJO

        ds.save(p);

        for (Personne e : ds.find(Personne.class)) {

            System.out.println(e.getName());
        	e.getAdress();
        }
      
    }
}

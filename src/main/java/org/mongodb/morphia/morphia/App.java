package org.mongodb.morphia.morphia;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

import domaine.Address;
import domaine.Article;
import domaine.Person;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {

		Morphia morphia = new Morphia();
		MongoClient mongo = new MongoClient();
		morphia.map(Person.class).map(Address.class);
		Datastore ds = morphia.createDatastore(mongo, "my_database");

		Person person = new Person();
		person.setName("Tintin");
		
		Address address = new Address();
		address.setStreet("123 Some street");
		address.setCity("Some city");
		address.setPostCode("123 456");
		address.setCountry("Some country");
		
		Article article = new Article();
		article.setName("Iphone");
		article.setStars(3);
		article.setPerson(person);
		
		ds.save(article);
		// set address
		person.setAddress(address);
		// Save the POJO
		ds.save(person);
		
		
		for (Person e : ds.find(Person.class))
			System.err.println(e);
	}

}

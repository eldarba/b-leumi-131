package app.core.runners;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import app.core.entities.Address;
import app.core.entities.School;
import app.core.entities.Teacher;

@Component
public class TransactionDemo implements CommandLineRunner {
	
	@Autowired
	private EntityManagerFactory factory;

	@Override
	public void run(String... args) throws Exception {
		
		// JPA Transaction
		// get an entity manager - manages all entities during transaction
		EntityManager em = factory.createEntityManager();
		
		
		Address address = new Address(0, 45, "Herzel", "Jerusalem", "Israel", null);
		List<Teacher> teachers = new ArrayList<>();
		teachers.add(new Teacher(0, "aaa", null));
		teachers.add(new Teacher(0, "bbb", null));
		School school = new School(0, "AAA", address, teachers);
		
		// start a transaction
		em.getTransaction().begin();
		try {
			///////////////////////
			System.out.println("============================");
			System.out.println("is address persistent? " + em.contains(address));
			em.persist(school);
			System.out.println("is address persistent? " + em.contains(address));
			System.out.println("============================");
			///////////////////////
			em.getTransaction().commit();
			System.out.println(">>> committed");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println(">>> rolled back");
		}
		
	}

}

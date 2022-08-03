package app.core.runners;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import app.core.entities.School;

// @Component
public class TransactionDemo2 implements CommandLineRunner {

	@Autowired
	private EntityManagerFactory factory;

	@Override
	public void run(String... args) throws Exception {

		// JPA Transaction
		// get an entity manager - manages all entities during transaction
		EntityManager em = factory.createEntityManager();

		// start a transaction
		em.getTransaction().begin();
		try {
			///////////////////////
			System.out.println("============================");
			School school = em.find(School.class, 2);
			System.out.println(school);
			System.out.println(school.getTeachers());
			
			
			System.out.println(em.contains(school));
			System.out.println(em.contains(school.getTeachers().get(0)));
			school.getTeachers().get(0).setName("Avi");
			
			em.detach(school);
			System.out.println(em.contains(school));
			System.out.println(em.contains(school.getTeachers().get(0)));
			
			System.out.println("============================");
			///////////////////////
			em.getTransaction().commit();
			System.out.println(">>> committed");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println(">>> rolled back");
			e.printStackTrace();
		}

	}

}

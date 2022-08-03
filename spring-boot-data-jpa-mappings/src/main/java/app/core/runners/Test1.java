package app.core.runners;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import app.core.entities.Address;
import app.core.entities.School;
import app.core.entities.Teacher;
import app.core.services.SchoolService;

// @Component
public class Test1 implements CommandLineRunner {

	@Autowired
	private SchoolService service;

	@Override
	public void run(String... args) throws Exception {
		// the school address
		Address address = new Address(0, 200, "Yafo", "Tel Aviv", "Israel", null);
		// the school teachers
		List<Teacher> teachers = new ArrayList<>();
		teachers.add(new Teacher(0, "Israel", null));
		teachers.add(new Teacher(0, "Ariella", null));
//		teachers.add(new Teacher(0, "Rachel", null));
		// the school
		School school = new School();
		school.setName("JBT");
		school.setAddress(address);
		school.setTeachers(teachers);

		// add the above school to the database using the service
		service.createSchool(school);
	}

}

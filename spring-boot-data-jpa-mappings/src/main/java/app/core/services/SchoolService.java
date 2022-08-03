package app.core.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.core.entities.School;
import app.core.repositories.SchoolRepostory;

@Service
@Transactional
public class SchoolService {
	
	@Autowired
	private SchoolRepostory repo;
	
	public void createSchool(School school) {
		if(!repo.existsById(school.getId())) {
			repo.save(school);
		}else {
			throw new RuntimeException("createSchool failed - already exists");
		}
	}
	
	public School getSchool(int id) {
		return repo.findById(id)
				.orElseThrow(()->new RuntimeException("getSchool failed - not found"));
	}
	
	
	public void updateSchool(School school) {
		if(repo.existsById(school.getId())) {
			repo.save(school);
		}else {
			throw new RuntimeException("updateSchool failed - not found");
		}
	}
	
	public void deleteSchool(int id) {
		repo.deleteById(id);
	}

}

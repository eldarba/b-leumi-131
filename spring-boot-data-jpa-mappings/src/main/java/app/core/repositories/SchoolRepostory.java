package app.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import app.core.entities.School;

public interface SchoolRepostory extends JpaRepository<School, Integer> {

}

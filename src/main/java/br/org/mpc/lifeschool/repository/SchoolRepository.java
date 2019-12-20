package br.org.mpc.lifeschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.mpc.lifeschool.modelo.School;

public interface SchoolRepository extends JpaRepository<School, Long>{

	School findByName(String nameSchool);

}

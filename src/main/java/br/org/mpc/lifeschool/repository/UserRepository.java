package br.org.mpc.lifeschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.mpc.lifeschool.modelo.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByName(User nameVoluntary);

}

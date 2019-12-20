package br.org.mpc.lifeschool.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.org.mpc.lifeschool.modelo.Letter;

public interface LetterRepository extends JpaRepository<Letter, Long>{

	Page<Letter> findBySender(String sender, Pageable paginacao);

}

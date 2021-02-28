package com.uniovi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.uniovi.entities.Mark;
import com.uniovi.entities.User;

public interface MarksRepository extends CrudRepository<Mark, Long> {

	@Modifying
	@Transactional
	@Query("UPDATE Mark SET resend = ?1 WHERE id = ?2")
	void updateResend(Boolean resend, Long id);
	
	@Query("SELECT r FROM Mark r WHERE r.user = ?1 ORDER BY r.id ASC ")
	List<Mark> findAllByUser(User user);
	
	@Query("SELECT r FROM Mark r WHERE (LOWER(r.description) LIKE LOWER(?1) OR LOWER(r.user.name) LIKE LOWER(?1))")
	List<Mark> searchByDescriptionAndName(String searchtext);
	
	@Query("SELECT r FROM Mark r WHERE (LOWER(r.description) LIKE LOWER(?1) OR LOWER(r.user.name) LIKE LOWER(?1)) AND r.user = ?2")
	List<Mark> searchByDescriptionNameAndUser(String searchtext, User user);
}

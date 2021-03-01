package com.uniovi.repositories;

import com.uniovi.entities.User;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<User, Long>{

	User findByDni(String dni);

	@Query("SELECT u FROM User u WHERE (LOWER(u.name) LIKE LOWER(?1) OR LOWER(u.lastName) LIKE LOWER(?1))")
	List<User> searchUserByNameAndSurname(String searchText);

}

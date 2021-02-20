package com.uniovi.repositories;

import com.uniovi.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<User, Long>{

}

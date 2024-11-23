package com.dbmodule.repository;

import org.springframework.data.repository.CrudRepository;
import com.dbmodule.model.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}


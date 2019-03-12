package com.roberto.myspringpractice.repositories;

import com.roberto.myspringpractice.model.User;
import org.springframework.data.repository.CrudRepository;

import javax.jws.soap.SOAPBinding;

public interface Users  extends CrudRepository<User,Long>{
    User findByUsername(String username);
    User findUsersById(Long id);
}

package com.companyName.repository;

import org.springframework.data.repository.CrudRepository;

import com.companyName.modelo.User;

public interface UserRepository extends CrudRepository<User, Long> {
  User findByUsername(String nombre);
}

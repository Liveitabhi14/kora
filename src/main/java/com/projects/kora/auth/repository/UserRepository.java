package com.projects.kora.auth.repository;

import com.projects.kora.auth.model.UserDAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserDAO, Integer> {
}

package com.projects.kora.auth.repository;

import com.projects.kora.auth.model.UserDAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;

@Repository
public interface UserRepository extends CrudRepository<UserDAO, Integer> {
    UserDAO findByUsername(String username);

    UserDAO findByUserId(int userId);

}

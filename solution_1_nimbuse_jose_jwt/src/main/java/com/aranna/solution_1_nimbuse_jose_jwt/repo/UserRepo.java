package com.aranna.solution_1_nimbuse_jose_jwt.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aranna.solution_1_nimbuse_jose_jwt.model.User;


public interface UserRepo extends JpaRepository<User,Integer> {
    User findByUserId(Integer userId);

    Optional<User> findByUserName(String userName);
}

package com.restfulproject.dhrubo.repository;

import com.restfulproject.dhrubo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.annotation.Resource;


@Resource
public interface UserRepository extends JpaRepository<User, String> {

    User findByEmail(String email);

}
package com.restfulproject.dhrubo.repository;


import com.restfulproject.dhrubo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    List<User> findByIdIn(List<Long> userIds);
    Boolean existsByEmail(String email);
}
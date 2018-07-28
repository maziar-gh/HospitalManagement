package com.restfulproject.dhrubo.repository;

import com.restfulproject.dhrubo.model.Role;
import com.restfulproject.dhrubo.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByEmail(RoleName roleName);
}
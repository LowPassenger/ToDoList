package com.example.todolist.repository;

import com.example.todolist.model.Role;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String roleName);

    boolean existsByName(String roleName);
}

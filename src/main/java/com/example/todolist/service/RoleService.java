package com.example.todolist.service;

import com.example.todolist.exception.ResourceNotFoundException;
import com.example.todolist.model.Role;
import com.example.todolist.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role getByName(String roleName) {
        return roleRepository.findByName(roleName).orElseThrow(
                () -> new ResourceNotFoundException("Role", "name", roleName)
        );
    }

    public Role create(Role role) {
        return roleRepository.save(role);
    }

    public boolean existByRoleName(String roleName) {
        return roleRepository.existsByName(roleName);
    }
}

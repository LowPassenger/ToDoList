package com.example.todolist.config;

import com.example.todolist.model.Role;
import com.example.todolist.service.RoleService;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DataInitializer {
    private static final String DUMMY_USER_ROLE = "USER";
    private final RoleService roleService;

    @Autowired
    public DataInitializer(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostConstruct
    public void injectData() {
        createDummyUser();
    }

    public void createDummyUser() {
        if (!roleService.existByRoleName(DUMMY_USER_ROLE)) {
            Role user = new Role();
            user.setName("USER");
            roleService.create(user);
            log.info("Role with name " + user + " was created.");
        }
    }
}

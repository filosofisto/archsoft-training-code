package com.archsoft.security;

import com.archsoft.model.Permission;
import com.archsoft.model.User;
import com.archsoft.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Objects;

@Component
public class InitUser implements CommandLineRunner {

    private final UserService userService;

    private final BCryptPasswordEncoder passwordEncoder;

    public InitUser(UserService userService, BCryptPasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        Permission permission = createAdminPermission();
        createAdminUser(permission);
    }

    private void createAdminUser(Permission permission) {
        User user = userService.findByUsername(User.UsersDefault.ADMIN.getUsername());
        if (Objects.isNull(user)) {
            user = userService.create(User.builder()
                    .username(User.UsersDefault.ADMIN.getUsername())
                    .accountNonExpired(true)
                    .accountNonLocked(true)
                    .credentialsNonExpired(true)
                    .enabled(true)
                    .password(passwordEncoder.encode(User.UsersDefault.ADMIN.getPassword()))
                    .permissions(Collections.singleton(permission))
                    .build());
        }
    }

    private Permission createAdminPermission() {
        Permission permission = userService.findPermissionByDescription(Permission.ROLE.ADMIN.getRole());
        if (Objects.isNull(permission)) {
            permission = userService.createPermission(Permission.builder()
                    .description(Permission.ROLE.ADMIN.getRole())
                    .build());
        }

        return permission;
    }
}

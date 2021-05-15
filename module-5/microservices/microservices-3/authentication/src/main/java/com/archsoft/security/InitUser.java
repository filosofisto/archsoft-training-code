package com.archsoft.security;

import com.archsoft.exception.RecordNotFoundException;
import com.archsoft.exception.UserAlreadyExistsException;
import com.archsoft.model.User;
import com.archsoft.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collections;
import java.util.Objects;

//@Component
public class InitUser implements CommandLineRunner {

    private final UserService userService;

    private final BCryptPasswordEncoder passwordEncoder;

    public InitUser(UserService userService, BCryptPasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        createAdminUser();
    }

    private void createAdminUser() throws RecordNotFoundException, UserAlreadyExistsException {
        User user = userService.findByUsername(User.UsersDefault.ADMIN.getUsername());

        if (Objects.isNull(user)) {
            User newUser = new User();

            newUser.setUsername(User.UsersDefault.ADMIN.getUsername());
            newUser.setAccountNonExpired(true);
            newUser.setAccountNonLocked(true);
            newUser.setCredentialsNonExpired(true);
            newUser.setEnabled(true);
            newUser.setPassword(passwordEncoder.encode(User.UsersDefault.ADMIN.getPassword()));
            newUser.setPermissions(Collections.singleton("admin"));

            userService.registerUser(newUser);
        }
    }
}

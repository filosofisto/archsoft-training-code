package com.archsoft.controller;

import com.archsoft.exception.RecordNotFoundException;
import com.archsoft.exception.UserAlreadyExistsException;
import com.archsoft.model.user.User;
import com.archsoft.security.JwtTokenProvider;
import com.archsoft.service.UserService;
import com.archsoft.to.UserTO;
import com.archsoft.util.converter.UserConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;

    private final UserService userService;

    private final UserConverter userConverter;

    public AuthController(AuthenticationManager authenticationManager,
                          JwtTokenProvider jwtTokenProvider,
                          UserService userService, UserConverter userConverter) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
        this.userConverter = userConverter;
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody UserTO userTO) {
        try {
            String username = userTO.getUsername();
            String password = userTO.getPassword();

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

            User user = userService.findByUsername(username);
            String token = jwtTokenProvider.createToken(username, user.getPermissions());

            Map<String, Object> map = new HashMap<>();
            map.put("username", username);
            map.put("token", token);
            map.put("permissions", user.getPermissions());

            return ResponseEntity.ok(map);
        } catch (AuthenticationException | RecordNotFoundException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@Valid @RequestBody UserTO userTO) throws UserAlreadyExistsException {
        User user = userConverter.toEntity(userTO);
        User userSaved = userService.registerUser(user);
        UserTO userTOSaved = userConverter.toTransferObject(userSaved);
        userTOSaved.setPassword(null);

        // TODO: Should return 201 (created)
        return ResponseEntity.ok(userTOSaved);
    }

    @GetMapping("/findByUsername/{username}")
    public ResponseEntity<?> findByUsername(@PathVariable("username") String username) throws RecordNotFoundException {
        User user = userService.findByUsername(username);
        UserTO userTO = userConverter.toTransferObject(user);
        userTO.setPassword(null);
        return ResponseEntity.ok(userTO);
    }
}

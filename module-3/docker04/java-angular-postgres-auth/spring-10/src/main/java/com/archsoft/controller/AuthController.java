package com.archsoft.controller;

import com.archsoft.model.User;
import com.archsoft.security.JwtTokenProvider;
import com.archsoft.service.UserService;
import com.archsoft.to.UserTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/login")
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;

    private final UserService userService;

    public AuthController(AuthenticationManager authenticationManager,
                          JwtTokenProvider jwtTokenProvider,
                          UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody UserTO userTO) {
        try {
            String username = userTO.getUsername();
            String password = userTO.getPassword();

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

            User user = userService.findByUsername(username);
            String token = jwtTokenProvider.createToken(username, user.getRoles());

            Map<String, String> map = new HashMap<>();
            map.put("username", username);
            map.put("token", token);

            return ResponseEntity.ok(map);
        } catch (AuthenticationException e) {
//            throw new BadCredentialsException("Invalid username/password");
//            throw new org.springframework.security.authentication.AuthenticationCredentialsNotFoundException("Invalid username/password");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}

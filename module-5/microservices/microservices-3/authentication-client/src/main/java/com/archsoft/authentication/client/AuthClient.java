package com.archsoft.authentication.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.archsoft.model.user.User;

@FeignClient(value = "Authentication", url = "${security.auth.url}")
public interface AuthClient {

    @GetMapping("/findByUsername/{username}")
    User findByUsername(@PathVariable("username") String username);
}

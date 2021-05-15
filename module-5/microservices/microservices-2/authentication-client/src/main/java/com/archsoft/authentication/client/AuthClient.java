package com.archsoft.authentication.client;

import com.archsoft.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "Authentication", url = "${security.auth.url}")
public interface AuthClient {

    @GetMapping("/findByUsername/{username}")
    User findByUsername(@PathVariable("username") String username);
}

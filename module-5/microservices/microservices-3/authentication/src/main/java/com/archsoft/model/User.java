package com.archsoft.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Document
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class User implements UserDetails, Serializable {

    private static final long serialVersionUID = 2383926832631561286L;

    public enum UsersDefault {
        ADMIN("admin", "password");

        private final String username;
        private final String password;

        UsersDefault(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }

    @Id
    private String id;

    private String username;

    private String email;

    private String password;

    private Set<String> permissions = new HashSet<>();

    private Boolean accountNonExpired;

    private Boolean accountNonLocked;

    private Boolean credentialsNonExpired;

    private Boolean enabled;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return permissions.stream()
                .map(permission -> (GrantedAuthority) () -> permission)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired == null || accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked == null || accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired == null || credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled == null || enabled;
    }
}

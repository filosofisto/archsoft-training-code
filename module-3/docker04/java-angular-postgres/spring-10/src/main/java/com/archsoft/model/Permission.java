package com.archsoft.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB03_PERMISSION")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Permission implements GrantedAuthority, Serializable {

    private static final long serialVersionUID = -4912763052710904297L;

    public enum ROLE {
        ADMIN("admin"),
        USER("user");

        private final String role;

        ROLE(String role) {
            this.role = role;
        }

        public String getRole() {
            return role;
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_permission")
    @Column(name = "PERMISSION_ID")
    private Long id;

    @Column(name = "DESCRIPTION", nullable = false, length = 50)
    private String description;

    @Override
    public String getAuthority() {
        return description;
    }
}

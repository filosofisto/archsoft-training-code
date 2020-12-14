package com.archsoft.to;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class UserTO implements Serializable {

    private static final long serialVersionUID = 4487440933665316943L;

    private String username;

    private String password;

}

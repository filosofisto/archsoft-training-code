package com.archsoft.to;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class PersonTO {

    private Long id;
    private String name;
    private int age;
}

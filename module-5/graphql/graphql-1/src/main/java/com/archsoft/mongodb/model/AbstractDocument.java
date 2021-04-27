package com.archsoft.mongodb.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class AbstractDocument {

    @Id
    private String id;


}

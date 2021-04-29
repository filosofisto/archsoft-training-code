package com.archsoft.mongodb.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
public class AbstractDocument implements Serializable {

    @Id
    private String id;


}

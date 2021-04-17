package com.archsoft.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Document {

    private String number;
    private String emitter;
}

package com.archsoft.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Log {

    private Throwable exception;
}

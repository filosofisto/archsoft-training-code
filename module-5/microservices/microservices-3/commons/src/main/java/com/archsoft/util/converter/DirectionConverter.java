package com.archsoft.util.converter;

import org.springframework.data.domain.Sort.Direction;

import static org.springframework.data.domain.Sort.Direction.ASC;
import static org.springframework.data.domain.Sort.Direction.DESC;

public final class DirectionConverter {

    public static Direction from(String value) {
        return value.equals("asc") ? ASC : DESC;
    }
}

package com.archsoft.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;

public final class JSONUtil {

    private JSONUtil() { }

    public static String toJSON(Object object) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        StringWriter writer = new StringWriter();
        objectMapper.writeValue(writer, object);

        return writer.toString();
    }
}

package com.archsoft.model.product;

import com.archsoft.model.AbstractDocument;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Document
@Data
public class Product extends AbstractDocument {

    private String name;
    private String description;
    private BigDecimal price;
    private String category;
    private Map<String, String> attributes = new HashMap<String, String>();

    public Map<String, String> getAttributes() {
        return Collections.unmodifiableMap(attributes);
    }

    public void setAttribute(String name, String value) {
        if (value == null) {
            this.attributes.remove(value);
        } else {
            this.attributes.put(name, value);
        }
    }
}

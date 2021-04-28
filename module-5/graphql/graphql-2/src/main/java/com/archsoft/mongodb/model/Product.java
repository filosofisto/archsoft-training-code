package com.archsoft.mongodb.model;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Document
@Data
public class Product extends AbstractDocument {

    @GraphQLQuery(name = "name", description = "Product's name")
    private String name;

    @GraphQLQuery(name = "description", description = "Product's description")
    private String description;

    @GraphQLQuery(name = "price", description = "Product's price")
    private BigDecimal price;

    @GraphQLQuery(name = "category", description = "Product's category")
    private String category;

    @GraphQLQuery(name = "attributes", description = "Product's attributes")
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

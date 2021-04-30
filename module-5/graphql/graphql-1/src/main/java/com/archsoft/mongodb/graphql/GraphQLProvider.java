package com.archsoft.mongodb.graphql;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URL;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

@Component
public class GraphQLProvider {

    private final ProductDataFetchers productDataFetchers;

    private final CustomerDataFetchers customerDataFetchers;

    private GraphQL graphQL;

    public GraphQLProvider(ProductDataFetchers productDataFetchers, CustomerDataFetchers customerDataFetchers) {
        this.productDataFetchers = productDataFetchers;
        this.customerDataFetchers = customerDataFetchers;
    }

    @PostConstruct
    public void init() throws IOException {
        URL url = Resources.getResource("schema.graphqls");
        String sdl = Resources.toString(url, Charsets.UTF_8);
        GraphQLSchema graphQLSchema = buildSchema(sdl);
        this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }

    private GraphQLSchema buildSchema(String sdl) {
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(sdl);
        RuntimeWiring runtimeWiring = buildWiring();
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        return schemaGenerator.makeExecutableSchema(typeRegistry, runtimeWiring);
    }

    private RuntimeWiring buildWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type(newTypeWiring("Query")
                        // Product
                        .dataFetcher("readProduct", productDataFetchers.readProductDataFetcher())
                        .dataFetcher("listProducts", productDataFetchers.listProductsDataFetcher())
                        // Customer
                        .dataFetcher("listCustomers", customerDataFetchers.listCustomersDataFetcher()))
                .type(newTypeWiring("Mutation")
                        // Product
                        .dataFetcher("createProduct", productDataFetchers.createProduct())
                        .dataFetcher("updateProduct", productDataFetchers.updateProduct())
                        .dataFetcher("changeProductPrice", productDataFetchers.changeProductPrice())
                        .dataFetcher("deleteProduct", productDataFetchers.deleteProduct())
                        // Customer
                        .dataFetcher("createCustomer", customerDataFetchers.createCustomer()))
                .build();
    }

    @Bean
    public GraphQL graphQL() {
        return graphQL;
    }
}

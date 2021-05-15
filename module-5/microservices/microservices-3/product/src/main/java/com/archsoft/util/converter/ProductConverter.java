package com.archsoft.util.converter;

import com.archsoft.model.Product;
import com.archsoft.to.ProductTO;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter extends Converter<Product, ProductTO> {
}

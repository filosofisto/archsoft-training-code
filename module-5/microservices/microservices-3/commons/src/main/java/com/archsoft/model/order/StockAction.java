package com.archsoft.model.order;

import com.archsoft.model.AbstractDocument;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StockAction extends AbstractDocument {

    private String productId;

    private Integer quantity;
}

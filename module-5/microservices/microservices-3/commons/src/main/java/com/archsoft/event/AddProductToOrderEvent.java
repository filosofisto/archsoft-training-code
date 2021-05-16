package com.archsoft.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddProductToOrderEvent implements Serializable {

    private EventType eventType;

    private String productId;

    private Integer quantity;
}

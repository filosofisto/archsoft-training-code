package com.archsoft.to;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class CheckAvailabilityResponseTO implements Serializable {

    private BigDecimal price;

    private boolean available;
}

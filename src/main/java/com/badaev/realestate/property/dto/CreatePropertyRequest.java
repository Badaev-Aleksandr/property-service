package com.badaev.realestate.property.dto;

import java.math.BigDecimal;

public record CreatePropertyRequest(String title,
                                    String description,
                                    BigDecimal price,
                                    String city,
                                    String address) {

}

package com.mic.product.dto;

import java.math.BigDecimal;

public record ProductResponse(String id, String name, String description, BigDecimal price) {
}

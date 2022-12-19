package com.learning.s2s.shared;

import lombok.Data;

@Data
public class Car {
    private Long id;
    private String name;
    private String brand;
    private Integer modelNo;
    private Long inventoryId;
}

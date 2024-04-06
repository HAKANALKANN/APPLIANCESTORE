package com.finalProject.applianceStore.applianceStore.dtos.responses.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProductResponse {
    private Integer id;
    private Integer categoriesId;
    private String name;
    private Integer quantity;
    private String description;
    private long price;
}

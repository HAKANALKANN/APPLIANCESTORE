package com.finalProject.applianceStore.applianceStore.dtos.requests.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductRequest {
    private Integer categoriesId;
    private Integer id;
    private String name;
    private Integer quantity;
    private String description;
    private long price;
}

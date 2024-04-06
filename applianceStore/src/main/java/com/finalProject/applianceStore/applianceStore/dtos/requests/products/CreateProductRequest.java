package com.finalProject.applianceStore.applianceStore.dtos.requests.products;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductRequest {

    private Integer categoriesId;
    private String name;
    private Integer quantity;
    private String description;
    private long price;


}

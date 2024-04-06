package com.finalProject.applianceStore.applianceStore.dtos.responses.categories;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCategoriesResponse {
    private Integer id;
    private String name;
}

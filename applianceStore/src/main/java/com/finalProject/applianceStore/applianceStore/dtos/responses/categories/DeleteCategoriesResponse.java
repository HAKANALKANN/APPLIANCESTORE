package com.finalProject.applianceStore.applianceStore.dtos.responses.categories;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteCategoriesResponse {
    private Integer id;
}

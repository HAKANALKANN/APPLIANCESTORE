package com.finalProject.applianceStore.applianceStore.controllers;


import com.finalProject.applianceStore.applianceStore.business.abstracts.CategoriesService;
import com.finalProject.applianceStore.applianceStore.dtos.requests.categories.CreateCategoriesRequest;
import com.finalProject.applianceStore.applianceStore.dtos.requests.categories.DeleteCategoriesRequest;
import com.finalProject.applianceStore.applianceStore.dtos.requests.categories.UpdateCategoriesRequest;
import com.finalProject.applianceStore.applianceStore.dtos.responses.categories.CreateCategoriesResponse;
import com.finalProject.applianceStore.applianceStore.dtos.responses.categories.DeleteCategoriesResponse;
import com.finalProject.applianceStore.applianceStore.dtos.responses.categories.GetAllCategoriesResponse;
import com.finalProject.applianceStore.applianceStore.dtos.responses.categories.UpdateCategoriesResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/categories")
@AllArgsConstructor
public class CategoriesController {
    CategoriesService categoriesService;
    @PostMapping
    public CreateCategoriesResponse add(@RequestBody @Valid CreateCategoriesRequest request){
        return categoriesService.add(request);
    }
    @PutMapping
    public UpdateCategoriesResponse updated(@RequestBody @Valid UpdateCategoriesRequest request){
        return categoriesService.update(request);
    }
    @DeleteMapping
    public DeleteCategoriesResponse delete(@RequestBody @Valid DeleteCategoriesRequest request){return categoriesService.delete(request.getId());}
    @GetMapping
  public ResponseEntity<List<GetAllCategoriesResponse>> getAll(){return ResponseEntity.ok(this.categoriesService.getAll());}
}





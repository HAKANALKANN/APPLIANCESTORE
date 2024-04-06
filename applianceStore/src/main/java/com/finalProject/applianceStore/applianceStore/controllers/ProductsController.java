package com.finalProject.applianceStore.applianceStore.controllers;


import com.finalProject.applianceStore.applianceStore.business.abstracts.ProductService;
import com.finalProject.applianceStore.applianceStore.dtos.requests.products.CreateProductRequest;
import com.finalProject.applianceStore.applianceStore.dtos.requests.products.DeleteProductRequest;
import com.finalProject.applianceStore.applianceStore.dtos.requests.products.UpdateProductRequest;
import com.finalProject.applianceStore.applianceStore.dtos.responses.product.CreatedProductResponse;
import com.finalProject.applianceStore.applianceStore.dtos.responses.product.DeleteProductResponse;
import com.finalProject.applianceStore.applianceStore.dtos.responses.product.GetAllProductResponse;
import com.finalProject.applianceStore.applianceStore.dtos.responses.product.UpdateProductResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/products")
@AllArgsConstructor
public class ProductsController {
    private ProductService productService;
    @GetMapping()
    public ResponseEntity<List<GetAllProductResponse>> getAll(){
        return ResponseEntity.ok(this.productService.getAll());
    }
    @PostMapping
    public CreatedProductResponse add(@RequestBody @Valid CreateProductRequest request) throws Exception {return productService.add(request);}

    @DeleteMapping
    public DeleteProductResponse delete(@RequestBody @Valid DeleteProductRequest request){return productService.delete(request.getId());}

    @PutMapping
    public UpdateProductResponse update(@RequestBody @Valid UpdateProductRequest request){return productService.update(request);}
}

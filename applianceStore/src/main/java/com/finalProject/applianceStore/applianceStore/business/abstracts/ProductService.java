package com.finalProject.applianceStore.applianceStore.business.abstracts;

import com.finalProject.applianceStore.applianceStore.dtos.requests.categories.CreateCategoriesRequest;
import com.finalProject.applianceStore.applianceStore.dtos.requests.categories.UpdateCategoriesRequest;
import com.finalProject.applianceStore.applianceStore.dtos.requests.products.CreateProductRequest;
import com.finalProject.applianceStore.applianceStore.dtos.requests.products.UpdateProductRequest;
import com.finalProject.applianceStore.applianceStore.dtos.responses.categories.CreateCategoriesResponse;
import com.finalProject.applianceStore.applianceStore.dtos.responses.categories.DeleteCategoriesResponse;
import com.finalProject.applianceStore.applianceStore.dtos.responses.categories.GetAllCategoriesResponse;
import com.finalProject.applianceStore.applianceStore.dtos.responses.categories.UpdateCategoriesResponse;
import com.finalProject.applianceStore.applianceStore.dtos.responses.product.CreatedProductResponse;
import com.finalProject.applianceStore.applianceStore.dtos.responses.product.DeleteProductResponse;
import com.finalProject.applianceStore.applianceStore.dtos.responses.product.GetAllProductResponse;
import com.finalProject.applianceStore.applianceStore.dtos.responses.product.UpdateProductResponse;

import java.util.List;

public interface ProductService {

    List<GetAllProductResponse> getAll();
    CreatedProductResponse add(CreateProductRequest request) throws Exception;
    DeleteProductResponse delete(Integer id);
    UpdateProductResponse update(UpdateProductRequest request);
}

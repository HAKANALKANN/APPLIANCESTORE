package com.finalProject.applianceStore.applianceStore.business.concretes;

import com.finalProject.applianceStore.applianceStore.business.abstracts.ProductService;
import com.finalProject.applianceStore.applianceStore.core.utilities.mapping.ModelMapperService;
import com.finalProject.applianceStore.applianceStore.dataaccess.CategoriesRepository;
import com.finalProject.applianceStore.applianceStore.dataaccess.ProductRepository;
import com.finalProject.applianceStore.applianceStore.dtos.requests.products.CreateProductRequest;
import com.finalProject.applianceStore.applianceStore.dtos.requests.products.UpdateProductRequest;
import com.finalProject.applianceStore.applianceStore.dtos.responses.product.CreatedProductResponse;
import com.finalProject.applianceStore.applianceStore.dtos.responses.product.DeleteProductResponse;
import com.finalProject.applianceStore.applianceStore.dtos.responses.product.GetAllProductResponse;
import com.finalProject.applianceStore.applianceStore.dtos.responses.product.UpdateProductResponse;
import com.finalProject.applianceStore.applianceStore.entities.Categories;
import com.finalProject.applianceStore.applianceStore.entities.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ProductManager implements ProductService {
    ModelMapperService modelMapperService ;
    ProductRepository productRepository;
    CategoriesRepository categoriesRepository;
    @Override
    public List<GetAllProductResponse> getAll() {
        List<Product> products = productRepository.findAll();
        List<GetAllProductResponse> result = products.stream().map(product ->this.modelMapperService.forResponse().map(product, GetAllProductResponse.class) ).collect(Collectors.toList());
        return result;
    }

    @Override
    public CreatedProductResponse add(CreateProductRequest request) throws Exception{
        Product product = modelMapperService.forRequest().map(request, Product.class);
Categories categories = categoriesRepository.findById(request.getCategoriesId()).orElseThrow(()->new Exception("Category not found"));


           Product createdProduct = new Product();
           createdProduct.setQuantity(request.getQuantity());
           createdProduct.setProductName(request.getName());
           createdProduct.setPrice(request.getPrice());
           createdProduct.setDescription(request.getDescription());
           createdProduct.setCategories(categories);
        productRepository.save(createdProduct);

           CreatedProductResponse createdProductResponse = modelMapperService.forResponse().map(createdProduct, CreatedProductResponse.class);

           return createdProductResponse;

    }

    @Override
    public DeleteProductResponse delete(Integer id) {
        Product productToDelete = new Product();
        productToDelete.setProductId(id);
        productRepository.delete(productToDelete);

        DeleteProductResponse response = new DeleteProductResponse();
        response.setId(id);
        return response;
    }


    @Override
    public UpdateProductResponse update(UpdateProductRequest request) {
        Product product = modelMapperService.forRequest().map(request,Product.class);
        Product updateProduct = productRepository.save(product);
        UpdateProductResponse updateProductResponse = modelMapperService.forResponse().map(updateProduct,UpdateProductResponse.class);
        return updateProductResponse;
    }

}

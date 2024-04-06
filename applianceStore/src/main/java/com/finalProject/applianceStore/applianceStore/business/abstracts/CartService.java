package com.finalProject.applianceStore.applianceStore.business.abstracts;


import com.finalProject.applianceStore.applianceStore.dtos.requests.Cart.*;
import com.finalProject.applianceStore.applianceStore.dtos.responses.cart.*;

import java.util.List;

public interface CartService {
    AddProductToCartResponse addProductToCart(AddProductToCartRequest request) throws Exception;


    GetCartResponse getCarts(GetCartRequest request) throws Exception;

    UpdateProductInCartResponse updateProductInCart(UpdateProductInCartRequest request) throws Exception;

    DeleteProductFromCartResponse deleteProductFromCart(DeleteProductFromCartRequest request) throws Exception;

    List<UpdateProductQuantityInCartResponse> updateProductQuantityInCart(UpdateProductQuantityInCartRequest request) throws Exception;





}

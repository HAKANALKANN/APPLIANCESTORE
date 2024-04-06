package com.finalProject.applianceStore.applianceStore.business.concretes;

import com.finalProject.applianceStore.applianceStore.business.abstracts.CartService;
import com.finalProject.applianceStore.applianceStore.core.utilities.mapping.ModelMapperService;
import com.finalProject.applianceStore.applianceStore.dataaccess.CartItemRepository;
import com.finalProject.applianceStore.applianceStore.dataaccess.CartRepository;
import com.finalProject.applianceStore.applianceStore.dataaccess.ProductRepository;
import com.finalProject.applianceStore.applianceStore.dataaccess.UserRepository;
import com.finalProject.applianceStore.applianceStore.dtos.requests.Cart.*;
import com.finalProject.applianceStore.applianceStore.dtos.responses.cart.*;
import com.finalProject.applianceStore.applianceStore.dtos.responses.product.UpdateProductResponse;
import com.finalProject.applianceStore.applianceStore.entities.Cart;
import com.finalProject.applianceStore.applianceStore.entities.CartItem;
import com.finalProject.applianceStore.applianceStore.entities.Product;
import com.finalProject.applianceStore.applianceStore.entities.User;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CartManager implements CartService{
    CartRepository cartRepository;
    ModelMapperService modelMapperService;
    ProductRepository productRepository;
    CartItemRepository cartItemRepository;
    UserRepository userRepository;
    @Transactional
    @Override
    public AddProductToCartResponse addProductToCart(AddProductToCartRequest request) throws Exception {
        Cart cart1 = modelMapperService.forRequest().map(request,Cart.class);
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new Exception("User not found."));
        Cart cart = user.getCart();

        if (cart == null) {
            cart = new Cart();
            cart.setUser(user);
            user.setCart(cart);
        }

   Product product = productRepository.findById(request.getProductId()).orElseThrow(()->new Exception("Product not found."));

        for (CartItem cartItem : cart.getCartItems()) {
            if (cartItem.getProduct().getProductId().equals(request.getProductId())) {
                throw new Exception("Product " + product.getProductName() + " already exists in the cart");
            }
        }

   if (product.getQuantity()==0){
       throw new Exception(product.getProductName() + " is not available");
   }
        if (product.getQuantity() < request.getQuantity()) {
            throw new Exception("Please, make an order of the " + product.getProductName()
                    + " less than or equal to the quantity " + product.getQuantity() + ".");

        }

        CartItem newCartItem = new CartItem();

        newCartItem.setProduct(product);
        newCartItem.setCart(cart);
        newCartItem.setQuantity(request.getQuantity());
        newCartItem.setDiscount(product.getDiscount());
        newCartItem.setProductPrice(product.getSpecialPrice());

        cartItemRepository.save(newCartItem);

        product.setQuantity(product.getQuantity() - request.getQuantity());

        cart.setTotalPrice(cart.getTotalPrice() + (product.getSpecialPrice() * request.getQuantity()));

        AddProductToCartResponse addProductToCartResponse = modelMapperService.forResponse().map(cart, AddProductToCartResponse.class);

        List<UpdateProductResponse> updateProductResponse = cart.getCartItems().stream().map(p->modelMapperService.forResponse().map(p.getProduct(),UpdateProductResponse.class)).collect(Collectors.toList());
        addProductToCartResponse.setUpdateProductResponse(updateProductResponse);
    return addProductToCartResponse;
}

    @Override
    public GetCartResponse getCarts(GetCartRequest request) throws Exception {
        Cart cart = modelMapperService.forRequest().map(request,Cart.class);
        Cart getCart = cartRepository.findCartByEmailAndCartId(request.getEmail(), request.getCartId());
        if (getCart==null){
            throw new Exception("Cart not found");
        }

        GetCartResponse getCartResponse = modelMapperService.forResponse().map(getCart, GetCartResponse.class);
        return getCartResponse;
    }

    @Override
    public UpdateProductInCartResponse updateProductInCart(UpdateProductInCartRequest request) throws Exception {
        Cart cart = modelMapperService.forRequest().map(request,Cart.class);
        cart = cartRepository.findById(request.getGetCartResponse().getCartId())
                .orElseThrow(() -> new Exception(" "));
        CartItem cartItem = cartItemRepository.findById(request.getProductId())
                .orElseThrow(() -> new Exception("ürün bulunamadı."));


        if (cartItem.getCart() == null || !cartItem.getCart().equals(cart)) {
            throw new Exception("Product not available in the cart!!!");
        }


        double newCartItemPrice = cartItem.getProductPrice() * cartItem.getQuantity();
        double totalPriceDifference = newCartItemPrice - (cartItem.getProductPrice() * cartItem.getQuantity());
        cart.setTotalPrice(cart.getTotalPrice() + totalPriceDifference);


        cartItemRepository.save(cartItem);
        cartRepository.save(cart);


        UpdateProductInCartResponse response = modelMapperService.forResponse().map(cart, UpdateProductInCartResponse.class);
        return response;
    }

    @Override
    public DeleteProductFromCartResponse deleteProductFromCart(DeleteProductFromCartRequest request) throws Exception {
        Cart cart = modelMapperService.forRequest().map(request,Cart.class);
     Cart cart1 = cartRepository.findById(request.getCartId()).orElseThrow(() -> new Exception("Cart not found."));

        CartItem cartItem = cartItemRepository.findCartItemByProductIdAndCartId(request.getCartId(), request.getProductId());

        if (cartItem ==null){
            throw new Exception("Product not found.");
        }
        cart1.setTotalPrice(cart1.getTotalPrice()-(cartItem.getProductPrice()*cartItem.getQuantity()));
        Product product = cartItem.getProduct();
        product.setQuantity(product.getQuantity() - cartItem.getQuantity());
        cartItemRepository.deleteCartItemByProductIdAndCartId(request.getCartId(), request.getProductId());

        DeleteProductFromCartResponse response =new DeleteProductFromCartResponse();

        return response;
    }

    @Override
    public List<UpdateProductQuantityInCartResponse> updateProductQuantityInCart(UpdateProductQuantityInCartRequest request) throws Exception {
       Cart cart = modelMapperService.forRequest().map(request,Cart.class);
      // Cart cart1 = cartRepository.findById(request.getCartId()).orElseThrow(() -> new Exception("Cart not found."));
cartRepository.save(cart);
       Product product = productRepository.findById(request.getProductId()).orElseThrow(()-> new Exception("Product not found"));

        if (product.getQuantity() == 0) {
            throw new Exception( product.getProductName() + " is not available");
        }

        if (product.getQuantity() < request.getQuantity()) {
            throw new Exception("Please, make an order of the " + product.getProductName()
                    + " less than or equal to the quantity " + product.getQuantity() + ".");
        }

        CartItem cartItem = cartItemRepository.findCartItemByProductIdAndCartId(request.getCartId(), request.getProductId());

        if (cartItem == null) {
            throw new Exception("Product " + product.getProductName() + " not available in the cart!!!");
        }

        double cartPrice = cart.getTotalPrice() - (cartItem.getProductPrice()*cartItem.getQuantity());

        product.setQuantity(product.getQuantity()+cartItem.getQuantity() - request.getQuantity());

        cartItem.setProductPrice(product.getSpecialPrice());
        cartItem.setQuantity(cartItem.getQuantity());
        cartItem.setDiscount(product.getDiscount());

        cart.setTotalPrice(cartPrice + (cartItem.getProductPrice()*request.getQuantity()));
        cartItemRepository.save(cartItem);

        UpdateProductQuantityInCartResponse result = modelMapperService.forResponse().map(request,UpdateProductQuantityInCartResponse.class);

        List<UpdateProductResponse> updateProductResponse = cart.getCartItems().stream().map(p->modelMapperService.forResponse().map(p.getProduct(),UpdateProductResponse.class)).collect(Collectors.toList());

        result.setUpdateProductResponse( updateProductResponse);

        return (List<UpdateProductQuantityInCartResponse>) result;

    }
}

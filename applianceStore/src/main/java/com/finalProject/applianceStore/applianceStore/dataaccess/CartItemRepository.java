package com.finalProject.applianceStore.applianceStore.dataaccess;

import com.finalProject.applianceStore.applianceStore.entities.CartItem;
import com.finalProject.applianceStore.applianceStore.entities.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem,Integer> {
    @Query("SELECT ci.product FROM CartItem ci WHERE ci.product.id = ?1")
    Product findProductById(Integer productId);
    @Query("SELECT ci FROM CartItem ci WHERE ci.cart.id = ?1 AND ci.product.id = ?2")
    CartItem findCartItemByProductIdAndCartId(Integer cartId, Integer productId);
    @Modifying
    @Transactional
    @Query("DELETE FROM CartItem ci WHERE ci.cart.id = ?1 AND ci.product.id = ?2")
    void deleteCartItemByProductIdAndCartId(@Param("cartId") Integer cartId, @Param("productId") Integer productId);


}

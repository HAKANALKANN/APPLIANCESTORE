package com.finalProject.applianceStore.applianceStore.dataaccess;

import com.finalProject.applianceStore.applianceStore.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart,Integer> {
    @Query("SELECT c FROM Cart c WHERE c.user.email = ?1 AND c.id = ?2")
    Cart findCartByEmailAndCartId(String email, Integer cartId);
    @Query("SELECT c FROM Cart c WHERE c.user.userId=:userId")
    Cart findByUserId(Integer userId);
}

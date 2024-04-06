package com.finalProject.applianceStore.applianceStore.dataaccess;

import com.finalProject.applianceStore.applianceStore.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
    @Query("SELECT o FROM Order o WHERE o.email = ?1 AND o.id = ?2")
    Order findOrderByEmailAndOrderId(String email, Integer cartId);


    List<Order> findAllByEmail(String emailId);
}

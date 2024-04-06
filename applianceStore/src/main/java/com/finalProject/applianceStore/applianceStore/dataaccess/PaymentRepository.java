package com.finalProject.applianceStore.applianceStore.dataaccess;

import com.finalProject.applianceStore.applianceStore.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}

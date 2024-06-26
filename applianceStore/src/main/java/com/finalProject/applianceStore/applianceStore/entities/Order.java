package com.finalProject.applianceStore.applianceStore.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    @Email
    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "order", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<OrderItem> orderItems = new ArrayList<>();

    @Column
    private LocalDate orderDate;

    @OneToOne(mappedBy = "order",cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    //@JoinColumn(name = "payment_id")
    private Payment payment;

    @Column
    private Double totalAmount;
    @Column
    private String orderStatus;

}

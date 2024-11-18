package com.swp_group4.back_end.entities;

import com.swp_group4.back_end.enums.PaymentMethods;
import com.swp_group4.back_end.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class PaymentOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String paymentId;
    String paymentTitle;
    LocalDateTime paidDate;
    LocalDateTime dueDate;
    PaymentMethods paymentMethods;
    Long total;
    @Enumerated(EnumType.STRING)
    PaymentStatus status;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    Customer customer;

    @ManyToOne
    @JoinColumn(name = "construction_order_id")
    ConstructionOrder constructionOrder;

    @OneToOne
    @JoinColumn(name = "maintenance_order_id")
    MaintenanceOrder maintenanceOrder;
}

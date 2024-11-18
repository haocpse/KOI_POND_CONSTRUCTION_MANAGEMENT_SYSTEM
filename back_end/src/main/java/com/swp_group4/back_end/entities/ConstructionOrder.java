package com.swp_group4.back_end.entities;

import com.swp_group4.back_end.enums.ConstructionOrderStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ConstructionOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String constructionOrderId;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    Customer customer;

    String customerRequest;
    double total;
    LocalDateTime startDate;
    LocalDateTime endDate;
    Date constructionStartDate;
    Date constructionEndDate;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "quotation_id")
    Quotation quotation;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "design_id")
    Design design;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "consultant_id")
    Staff consultant;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "designer_id")
    Staff designer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "constructor_id")
    Staff constructorLeader;

    @Enumerated(EnumType.STRING)
    ConstructionOrderStatus status;

}

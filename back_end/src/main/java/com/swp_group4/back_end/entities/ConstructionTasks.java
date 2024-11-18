package com.swp_group4.back_end.entities;

import com.swp_group4.back_end.enums.ConstructStatus;
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
public class ConstructionTasks {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String taskId;
    @Enumerated(EnumType.STRING)
    ConstructStatus status;
    LocalDateTime startDate;
    LocalDateTime endDate;

    @ManyToOne
    @JoinColumn(name = "construction_order_id", nullable = false)
    ConstructionOrder constructionOrder;

    @ManyToOne
    @JoinColumn(name = "package_construction_id", nullable = false)
    PackageConstruction packageConstruction;

}

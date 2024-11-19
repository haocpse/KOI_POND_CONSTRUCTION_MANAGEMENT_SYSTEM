package com.swp_group4.back_end.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ConstructionTaskStaff {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @ManyToOne
    @JoinColumn(name = "staff_id", nullable = false)
    Staff staff;

    @ManyToOne
    @JoinColumn(name = "task_id", nullable = false)
    ConstructionTasks task;

}

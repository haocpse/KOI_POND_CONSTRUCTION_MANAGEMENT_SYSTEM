package com.swp_group4.back_end.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String staffId;
    String staffName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", nullable = false)
    Account account;

    @OneToMany(mappedBy = "staff", cascade = CascadeType.ALL)
    List<ConstructionTaskStaff> staffTasks;
}

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
public class PackageConstruction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String packageConstructionId;
    String content;
    double price;

    @ManyToOne
    @JoinColumn(name = "package_id", nullable = false)
    Packages packages;

    @OneToMany(mappedBy = "packageConstruction", cascade = CascadeType.ALL, orphanRemoval = true)
    List<ConstructionTasks> tasks;
}

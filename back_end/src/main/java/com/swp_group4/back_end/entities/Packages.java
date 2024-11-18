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
public class Packages {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String packageId;
    String packageType;

    @OneToMany(mappedBy = "packages", cascade = CascadeType.ALL, orphanRemoval = true)
    List<PackageConstruction> packageConstructions;

    @OneToMany(mappedBy = "packages", cascade = CascadeType.ALL, orphanRemoval = true)
    List<PackagePrice> packagePrices;
}

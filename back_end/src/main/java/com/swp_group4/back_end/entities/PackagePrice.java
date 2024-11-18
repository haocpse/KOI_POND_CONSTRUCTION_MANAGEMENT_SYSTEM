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
public class PackagePrice {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String packagePriceId;
    double minVolume;
    double maxVolume;
    double price;

    @ManyToOne
    @JoinColumn(name = "package_id", nullable = false)
    Packages packages;
}

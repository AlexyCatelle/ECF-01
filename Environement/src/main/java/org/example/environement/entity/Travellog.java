package org.example.environement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.environement.dto.travellogs.TravellogDtoResponse;
import org.example.environement.entity.enums.TravelMode;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Travellog {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private Double distanceKm;
    @Column(nullable = false)
    private TravelMode mode;
    @Column(nullable = false)
    private Double estimateCo2Kg;

    @ManyToOne
    @JoinColumn(name = "observation_id")
    private Observation observation;


    public void calculateCO2() {

        this.estimateCo2Kg = this.distanceKm * this.mode.getCo2PerKm();

   }

    public TravellogDtoResponse entityToDto() {
        return TravellogDtoResponse.builder()
                .id(this.id)
                .distanceKm(this.distanceKm)
                .mode(this.mode.name())
                .estimatedCo2Kg(this.estimateCo2Kg)
                .build();
    }
}

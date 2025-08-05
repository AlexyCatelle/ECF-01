package org.example.environement.entity.enums;

public enum TravelMode {
    WALKING(0.0),
    BIKE (0.0),
    CAR (0.22),
    BUS(0.11),
    TRAIN(0.03),
    PLANE(0.259);

    private final double co2PerKm;

    TravelMode(double co2PerKm) {
        this.co2PerKm = co2PerKm;
    }

    public double getCo2PerKm() {
        return co2PerKm;
    }
}

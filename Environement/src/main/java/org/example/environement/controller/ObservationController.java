package org.example.environement.controller;


import org.example.environement.service.ObservationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/observations")
public class ObservationController {
    private final ObservationService observationService;

    public ObservationController(ObservationService observationService) {
        this.observationService = observationService;
    }

//    * `GET /observations` → Toutes les observations (avec filtres possibles)
//* `POST /observations` → Ajouter une observation
//* `GET /observations/{id}` → Voir une observation
//* `GET /observations/by-location?location=Paris` → Filtrer par lieu
//* `GET /observations/by-species/{speciesId}` → Filtrer par espèce

}

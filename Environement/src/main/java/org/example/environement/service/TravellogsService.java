package org.example.environement.service;

import org.example.environement.dto.travellogs.TravellogDtoResponse;
import org.example.environement.dto.travellogs.TravellogDtoStat;
import org.example.environement.entity.Travellog;
import org.example.environement.repository.TravellogRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TravellogsService {

    private final TravellogRepository travellogRepository;

    public TravellogsService(TravellogRepository travellogRepository) {
        this.travellogRepository = travellogRepository;
    }

    public Map<String, TravellogDtoStat> getStatForUserLastMonth(String name) {
    return null;
    }

    public TravellogDtoStat getStat(long id) {
        return null;
    }

    public List<TravellogDtoResponse> get(int limit) {
    return travellogRepository.findAll().stream()
            .limit(limit)
            .map(Travellog::entityToDto)
            .collect(Collectors.toList());
    }

}

package org.example.environement.service;

import org.example.environement.dto.specie.SpecieDtoReceive;
import org.example.environement.dto.specie.SpecieDtoResponse;
import org.example.environement.entity.Specie;
import org.example.environement.exception.NotFoundException;
import org.example.environement.repository.SpecieRepository;
import org.example.environement.repository.SpecieRepositoryPaginate;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpecieService {

    private final SpecieRepository specieRepository;


    public SpecieService(SpecieRepository specieRepository) {
        this.specieRepository = specieRepository;
    }

    public SpecieDtoResponse create (SpecieDtoReceive specieDtoReceive){
        return specieRepository.save(specieDtoReceive.dtoToEntity()).entityToDto() ;
    }

    public List<SpecieDtoResponse> get (int pageSize, int pageNumber){
        return specieRepository.findAll(PageRequest.of(pageNumber, pageSize)).stream().map(Specie::entityToDto).collect(Collectors.toList());
    }

    public SpecieDtoResponse get(long id){
        return specieRepository.findById(id).orElseThrow(NotFoundException::new).entityToDto();
    }

}

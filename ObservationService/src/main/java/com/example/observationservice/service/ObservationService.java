package com.example.observationservice.service;

import com.example.observationservice.entity.Observation;
import com.example.observationservice.repository.ObservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ObservationService {

    @Autowired
    ObservationRepository observationRepository;

    public Observation createObservation(int userId, int celesteId, String description, LocalDate publishedDate){
        Observation observation = Observation.builder().userId(userId).celestelId(celesteId).description(description).publishedDate(publishedDate).build();
        observationRepository.save(observation);
        return observation;
    }


    public List<Observation> getByCelesteId (int id){
        List<Observation> observationList = observationRepository.findByCelesteId(id);
        List<Observation> sortedObservationList = new ArrayList<>();


        return sortedObservationList;
    }
    public List<Observation> getByDate (LocalDate date){
        List<Observation> observationList = observationRepository.findByPublishedDate(date);
        List<Observation> sortedObservationList = new ArrayList<>();


        return sortedObservationList;
    }


}

package com.example.observationservice.controller;

import com.example.observationservice.entity.Observation;
import com.example.observationservice.service.ObservationService;
import com.example.observationservice.tool.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("observation")
public class ObservationController {

    @Autowired
    private ObservationService observationService;

    @PostMapping("")
    public ResponseEntity<Observation> postObservation (@RequestParam int userId, @RequestParam int celestelId, @RequestParam LocalDate publishedDate, @RequestParam String description, @RequestHeader(HttpHeaders.AUTHORIZATION) String token){
        Observation observation = observationService.createObservation(userId,celestelId,description,publishedDate);
        return ResponseEntity.ok().body(observation);
    }

    @GetMapping("user/{userid}")
    public ResponseEntity<List<Observation>> getByUser(@PathVariable int userid, @RequestHeader(HttpHeaders.AUTHORIZATION) String token){
        try {
            RestClient<String, String> restClient = new RestClient<>();
            if (restClient.testToken(token,String.class)){
                return ResponseEntity.ok(observationService.getByUserId(userid));
            }
            return ResponseEntity.status(401).body(null);
        }catch (Exception ex) {
            return ResponseEntity.status(401).body(null);
        }
    }
    @GetMapping("celestial/{celestialId}")
    public ResponseEntity<List<Observation>> getBycelestialId(@PathVariable int celestelId, @RequestHeader(HttpHeaders.AUTHORIZATION) String token){
        try {
            RestClient<String, String> restClient = new RestClient<>();
            if (restClient.testToken(token,String.class)){
                return ResponseEntity.ok(observationService.getByCelesteId(celestelId));
            }
            return ResponseEntity.status(401).body(null);
        }catch (Exception ex) {
            return ResponseEntity.status(401).body(null);
        }
    }

    @GetMapping("date/{date}")
    public ResponseEntity<List<Observation>> getByDate(@PathVariable LocalDate date, @RequestHeader(HttpHeaders.AUTHORIZATION) String token){
        try {
            RestClient<String, String> restClient = new RestClient<>();
            if (restClient.testToken(token,String.class)){
                return ResponseEntity.ok(observationService.getByDate(date));
            }
            return ResponseEntity.status(401).body(null);
        }catch (Exception ex) {
            return ResponseEntity.status(401).body(null);
        }
    }




}
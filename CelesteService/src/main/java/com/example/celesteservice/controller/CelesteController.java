package com.example.celesteservice.controller;

import com.example.celesteservice.dto.CelesteResponseDTO;
import com.example.celesteservice.entity.Celeste;
import com.example.celesteservice.service.CelesteService;
import com.example.celesteservice.tool.RestClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/celeste")
public class CelesteController {

    private final CelesteService celesteService;

    public CelesteController(CelesteService orderService) {
        this.celesteService = orderService;
    }

    @PostMapping("")
    public ResponseEntity<Celeste> post(@RequestParam String productName,@RequestParam String diametre,@RequestParam String kilometre, @RequestParam int userId, @RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        Celeste celeste = celesteService.createCeleste(userId, productName,diametre,kilometre);
        return ResponseEntity.ok(celeste);
    }

    @GetMapping("{userId}")
    public ResponseEntity<CelesteResponseDTO> get(@PathVariable int userId, @RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        try {
            RestClient<String, String> restClient = new RestClient<>();
            if(restClient.testToken(token, String.class)) {
                return ResponseEntity.ok(celesteService.getCelesteByUserId(userId));
            }
            return ResponseEntity.status(401).body(null);
        }catch (Exception ex) {
            return ResponseEntity.status(401).body(null);
        }



    }
}

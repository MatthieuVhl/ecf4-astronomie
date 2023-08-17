package com.example.celesteservice.service;

import com.example.celesteservice.dto.CelesteResponseDTO;
import com.example.celesteservice.dto.UserDTO;
import com.example.celesteservice.entity.Celeste;
import com.example.celesteservice.repository.CelesteRepository;
import com.example.celesteservice.tool.RestClient;
import org.springframework.stereotype.Service;

@Service
public class CelesteService {
    private final CelesteRepository celesteRepository;


    public CelesteService(CelesteRepository orderRepository) {
        this.celesteRepository = orderRepository;
    }

    public Celeste createCeleste(int userId, String name) {
        Celeste celeste = Celeste.builder().userId(userId).name(name).build();
        celesteRepository.save(celeste);
        return celeste;
    }

    public CelesteResponseDTO getCelesteByUserId(int userId) {
        RestClient<UserDTO, String> restClient = new RestClient<>();
        CelesteResponseDTO orderResponseDTO = CelesteResponseDTO.builder()
                .celestes(celesteRepository.findAllByUserId(userId))
                .userDTO(restClient.get("user/"+userId, UserDTO.class))
                .build();
        return orderResponseDTO;
    }
}

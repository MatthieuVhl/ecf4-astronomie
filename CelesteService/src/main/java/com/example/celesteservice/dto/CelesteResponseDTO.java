package com.example.celesteservice.dto;

import com.example.celesteservice.entity.Celeste;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CelesteResponseDTO {
    private List<Celeste> celestes;
    private UserDTO userDTO;
}

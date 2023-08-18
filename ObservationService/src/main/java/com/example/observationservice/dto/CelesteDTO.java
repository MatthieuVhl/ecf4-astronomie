package com.example.observationservice.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CelesteDTO {
    private int id;
    private String name;
    private String diametre;
    private String kilometres;
}



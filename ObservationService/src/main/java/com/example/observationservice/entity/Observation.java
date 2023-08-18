package com.example.observationservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Observation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int userId;
    private int celestelId;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate publishedDate;

    String description;



    public Observation(int userId, int celestelId, LocalDate publishedDate, String description) {
        this.userId = userId;
        this.celestelId = celestelId;
        this.publishedDate = publishedDate;
        this.description = description;


}
}

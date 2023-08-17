package com.example.celesteservice.repository;

import com.example.celesteservice.entity.Celeste;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CelesteRepository extends CrudRepository<Celeste, Integer> {
List<Celeste>findAllByUserId(int userId);
}

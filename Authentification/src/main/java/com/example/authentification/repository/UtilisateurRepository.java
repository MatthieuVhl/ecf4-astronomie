package com.example.authentification.repository;

import com.example.authentification.entity.Utilisateur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurRepository extends CrudRepository<Utilisateur, Long> {
    Optional<Utilisateur> findByUsername(String username);
}
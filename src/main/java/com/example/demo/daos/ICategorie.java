package com.example.demo.daos;

import com.example.demo.models.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategorie extends JpaRepository<Categorie , Long> {
}

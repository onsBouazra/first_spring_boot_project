package com.example.demo.daos;


import com.example.demo.models.ProduitAlimentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProduitAlimentaire extends JpaRepository<ProduitAlimentaire, Long> {
}



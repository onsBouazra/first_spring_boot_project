package com.example.demo.daos;

import com.example.demo.models.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProduit extends JpaRepository<Produit, Long> {

    @Query("select p from Produit p where p.prix = :x")
    public List<Produit> getAllByprix(@Param("x") double prix);

}








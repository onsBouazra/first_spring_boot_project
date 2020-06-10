package com.example.demo.daos;


import com.example.demo.models.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository


public interface IFournisseur extends JpaRepository<Fournisseur,Long>
{

}

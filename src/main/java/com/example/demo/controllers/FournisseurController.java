package com.example.demo.controllers;

import com.example.demo.daos.IFournisseur;
import com.example.demo.models.Fournisseur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController// les methodes utiliserons put et les autres et autres et type retour json
@RequestMapping("/fournisseur")
public class FournisseurController {
    @Autowired
    private IFournisseur iFournisseur;

    @GetMapping("/all")
    public List<Fournisseur> getallFournisseur(){
        return iFournisseur.findAll();
    }
    @PostMapping("/save")
    private Fournisseur ajoutFournisseur(@RequestBody Fournisseur fournisseur){
//Categorie categorie=iCategorie.getOne(idCategorie)
        return  iFournisseur.save(fournisseur);}

    @PutMapping("/modif/{id}")
    private Fournisseur modifFournisseur(@RequestBody Fournisseur fournisseur, @PathVariable Long id)
    {fournisseur.setId(id);
        return iFournisseur.saveAndFlush(fournisseur);}
    @DeleteMapping("/delete/{id}")
    private HashMap<String,String>   deleteFournisseur(@PathVariable Long id) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            iFournisseur.deleteById(id);
            hashMap.put("etat", "Fournisseur suprimee");
            return hashMap;

        }
        catch (Exception e ){

            hashMap.put("etat", "Fournisseur non  suprimee");
            return hashMap;
        }
    }

}

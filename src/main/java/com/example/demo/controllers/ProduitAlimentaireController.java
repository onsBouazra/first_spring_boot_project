package com.example.demo.controllers;
import com.example.demo.daos.ICategorie;
import com.example.demo.daos.IProduitAlimentaire;

import com.example.demo.models.ProduitAlimentaire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
@RestController
@RequestMapping("/ProduitAlimentaire")
public class ProduitAlimentaireController {
    @Autowired
    private IProduitAlimentaire iProduitAlimentaire;
    @Autowired
    private ICategorie iCategorie ;
    @GetMapping("/all")
    public List<ProduitAlimentaire> getallProduitAlimentaire(){
        return iProduitAlimentaire.findAll();
    }
    @PostMapping("/save/{idCategorie}")
    private ProduitAlimentaire ajoutProduitAlimentaire(@RequestBody ProduitAlimentaire produitAlimentaire, @PathVariable Long idCategorie){
//Categorie categorie=iCategorie.getOne(idCategorie)
        produitAlimentaire.setCategorie(iCategorie.getOne(idCategorie));

        return  iProduitAlimentaire.save(produitAlimentaire);}
    @PutMapping("/modif/{id}")
    ProduitAlimentaire modifProduitAlimentaire(@RequestBody ProduitAlimentaire produitAlimentaire, @PathVariable Long id)
    {produitAlimentaire.setId(id);
        return iProduitAlimentaire.saveAndFlush(produitAlimentaire);}
    @DeleteMapping("/delete/{id}")
    private HashMap<String,String>   deleteProduitAlimentaire(@PathVariable Long id) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            iProduitAlimentaire.deleteById(id);
            hashMap.put("etat", "ProduitAlimentaire suprimee");
            return hashMap;

        }
        catch (Exception e ){

            hashMap.put("etat", "ProduitAlimentaire non  suprimee");
            return hashMap;
        }
    }


}

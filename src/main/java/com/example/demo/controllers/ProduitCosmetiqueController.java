package com.example.demo.controllers;
import com.example.demo.daos.ICategorie;
import com.example.demo.daos.IProduitCosmetique;

import com.example.demo.models.ProduitCosmetique;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
@RestController
@RequestMapping("/ProduitCosmetique")
public class ProduitCosmetiqueController {
    @Autowired
    private IProduitCosmetique iProduitCosmetique;
    @Autowired
    private ICategorie iCategorie ;
    @GetMapping("/all")
    public List<ProduitCosmetique> getallProduitCosmetique(){
        return iProduitCosmetique.findAll();
    }
    @PostMapping("/save/{idCategorie}")
    private ProduitCosmetique ajoutProduitCosmetique(@RequestBody ProduitCosmetique produitCosmetique, @PathVariable Long idCategorie){
//Categorie categorie=iCategorie.getOne(idCategorie)
        produitCosmetique.setCategorie(iCategorie.getOne(idCategorie));

        return  iProduitCosmetique.save(produitCosmetique);}
    @PutMapping("/modif/{id}")
    ProduitCosmetique modifProduitCosmetique(@RequestBody ProduitCosmetique produitCosmetique, @PathVariable Long id)
    {produitCosmetique.setId(id);
        return iProduitCosmetique.saveAndFlush(produitCosmetique);}
    @DeleteMapping("/delete/{id}")
    private HashMap<String,String>   deleteProduitCosmetique(@PathVariable Long id) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            iProduitCosmetique.deleteById(id);
            hashMap.put("etat", "ProduitCosmetique suprimee");
            return hashMap;

        }
        catch (Exception e ){

            hashMap.put("etat", "ProduitCosmetique non  suprimee");
            return hashMap;
        }
    }


}

package com.example.demo.controllers;

import com.example.demo.daos.ICategorie;
import com.example.demo.daos.IProduit;
import com.example.demo.models.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController// les methodes utiliserons put et les autres et autres et type retour json
@RequestMapping("/produit")
public class ProduitController {
        @Autowired
    private IProduit iProduit;
    @Autowired
    private ICategorie iCategorie ;


    @GetMapping("/all")
    public List<Produit> getallproduit(){
return iProduit.findAll();
        }


     @PostMapping("/save/{idCategorie}")
    private Produit ajoutproduit(@RequestBody Produit produit, @PathVariable Long idCategorie){
//Categorie categorie=iCategorie.getOne(idCategorie)
       produit.setCategorie(iCategorie.getOne(idCategorie));

    return  iProduit.save(produit);}
    @PostMapping("/add")
    public Produit addProduit(@RequestBody Produit produit){
        iProduit.save(produit);
        return produit;
    }


    /* @PutMapping("/modif/{id}")
    Produit modifproduit(@RequestBody Produit produit, @PathVariable Long id)
    {produit.setId(id);
        return iProduit.saveAndFlush(produit);}*/
     @DeleteMapping("/delete/{id}")
private HashMap<String,String>   deleteproduit(@PathVariable Long id) {
         HashMap<String, String> hashMap = new HashMap<>();
         try {
             iProduit.deleteById(id);
             hashMap.put("etat", "produit suprimee");
             return hashMap;

         }
         catch (Exception e ){

             hashMap.put("etat", "produit non  suprimee");
             return hashMap;
         }
     }


     @GetMapping("/recherchebyprix/{prix}")
    public List<Produit>  recherchebyprix(@PathVariable String prix){

         return iProduit.getAllByprix(Double.parseDouble(prix));
     }
}

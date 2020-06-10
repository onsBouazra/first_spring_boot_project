package com.example.demo.controllers;

import com.example.demo.daos.ICategorie;
import com.example.demo.models.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/categorie")


public class CategorieController {
    @Autowired
    private ICategorie iCategorie ;
    @GetMapping("/all")
    public List<Categorie> getallCategorie(){
        return iCategorie.findAll();
    }
    @PostMapping("/save")
    private Categorie ajoutCategorie(@RequestBody Categorie Categorie){
        return  iCategorie.save(Categorie);}
    @PutMapping("/modif/{id}")
    Categorie modifCategorie(@RequestBody Categorie Categorie, @PathVariable Long id)
    {Categorie.setId(id);
        return iCategorie.saveAndFlush(Categorie);}
    @DeleteMapping("/delete/{id}")
    private HashMap<String,String> deleteCategorie(@PathVariable Long id) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {

            iCategorie.deleteById(id);
            hashMap.put("etat", "Categorie suprimee");
            return hashMap;

        }
        catch (Exception e ){

            hashMap.put("etat", "Categorie non  suprimee");
            return hashMap;
        }
    }


}

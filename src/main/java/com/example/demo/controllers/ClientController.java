package com.example.demo.controllers;

import com.example.demo.daos.IClient;
import com.example.demo.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController// les methodes utiliserons put et les autres et autres et type retour json
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private IClient iClient;

    @GetMapping("/all")
    public List<Client> getallClient(){
        return iClient.findAll();
    }
    @PostMapping("/save")
    private Client ajoutClient(@RequestBody Client client){
//Categorie categorie=iCategorie.getOne(idCategorie)
        return  iClient.save(client);}

    @PutMapping("/modif/{id}")
   private Client modifclient(@RequestBody Client client, @PathVariable Long id)
    {client.setId(id);
        return iClient.saveAndFlush(client);}
    @DeleteMapping("/delete/{id}")
    private HashMap<String,String>   deleteClient(@PathVariable Long id) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            iClient.deleteById(id);
            hashMap.put("etat", "Client suprimee");
            return hashMap;

        }
        catch (Exception e ){

            hashMap.put("etat", "Client non  suprimee");
            return hashMap;
        }
    }

}

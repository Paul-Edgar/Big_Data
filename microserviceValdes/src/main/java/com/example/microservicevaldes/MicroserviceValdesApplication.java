package com.example.microservicevaldes;

import com.example.microservicevaldes.dao.AnimauxRepository;
import com.example.microservicevaldes.model.Animaux;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@SpringBootApplication
@RestController
@RequestMapping("/animaux")
public class MicroserviceValdesApplication {

    @Autowired
    private AnimauxRepository repository;

    //POST : pour ajouter des champs à notre base de données
    @PostMapping
    public Animaux saveAnimaux(@RequestBody Animaux animaux){
        return repository.save(animaux);
    }

    //GET : afficher le contenu de notre table
    @GetMapping
    public List<Animaux> getAnimaux(){
        return repository.findAll();
    }

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceValdesApplication.class, args);
    }

}

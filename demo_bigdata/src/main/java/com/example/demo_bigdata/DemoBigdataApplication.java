package com.example.demo_bigdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.NoRepositoryBean;

@SpringBootApplication
public class DemoBigdataApplication {

    @Autowired
    private ProduitInterface produitInterface;

    public static void main(String[] args) {
        SpringApplication.run(DemoBigdataApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(ProduitInterface produitInterface) {
        return args -> {
            produitInterface.save(new Produit(1, "Tablette", 1200));
            produitInterface.save(new Produit(2, "Ordinateur", 2000));
            produitInterface.save(new Produit(3, "Telephone", 800));
        };
    }
}

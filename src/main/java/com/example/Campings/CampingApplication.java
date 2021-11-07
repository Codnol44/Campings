package com.example.Campings;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.Campings.bo.Etoile;
import com.example.Campings.bo.Ville;
import com.example.Campings.controller.CampingContextApplication;
import com.example.Campings.dal.EtoileRepository;
import com.example.Campings.dal.VilleRepository;
import com.example.Campings.service.CampingService;

@SpringBootApplication
public class CampingApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CampingApplication.class, args);
	}
	
	@Bean
	public CampingContextApplication campingContextApplication(CampingService campingService) {
		return new CampingContextApplication(campingService);
	}
	
	//Enregistrement choix villes
	@Bean
	public CommandLineRunner initVille(VilleRepository villeRepo ) {
		return (args) -> {
			villeRepo.save(new Ville("Nantes", "44"));
			villeRepo.save(new Ville("Paris", "75"));
			villeRepo.save(new Ville("Nice", "06"));
			villeRepo.save(new Ville("Ajaccio", "01"));
			villeRepo.save(new Ville("Rennes", "35"));
			villeRepo.save(new Ville("Marseille", "06"));
			villeRepo.save(new Ville("Cannes", "06"));
			villeRepo.save(new Ville("Toulon", "06"));
		};
	}
	
	//Enregistrement choix étoiles
	@Bean
	public CommandLineRunner initEtoile(EtoileRepository etoileRepo) {
		return (args) -> {
			etoileRepo.save(new Etoile(1));
			etoileRepo.save(new Etoile(2));
			etoileRepo.save(new Etoile(3));
			etoileRepo.save(new Etoile(4));
			etoileRepo.save(new Etoile(5));	
		};
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

}

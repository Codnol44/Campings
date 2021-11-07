package com.example.Campings.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.Campings.bo.Etoile;
import com.example.Campings.bo.Ville;
import com.example.Campings.service.CampingService;

public class CampingContextApplication {

	//Lien avec couche service
	private CampingService campingService;
	
	//Création des listes
	private List<Ville> villes;
	private List<Etoile> etoiles;
	
	@Autowired
	public CampingContextApplication(CampingService campingService) {
		this.campingService = campingService;
	}
	
	public List<Ville> getVilles() {
		if(this.villes==null) {
			villes = campingService.getVilles();
		}
		return villes;
	}
	
	public List<Etoile> getEtoiles() {
		if(this.etoiles==null) {
			etoiles = campingService.getEtoiles();
		}
		return etoiles;
	}
	
}





















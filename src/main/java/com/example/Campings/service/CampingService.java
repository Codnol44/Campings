package com.example.Campings.service;

import java.util.List;
import com.example.Campings.bo.Camping;
import com.example.Campings.bo.Etoile;
import com.example.Campings.bo.Ville;

public interface CampingService {
	
	void ajouterCamping(Camping camping);
	
	public List<Camping> getCampings();
	
	List<Ville> getVilles();
	
	List<Etoile> getEtoiles();

	void deleteCamping(Long idC);

}

package com.example.Campings.service;

import java.util.List;
import java.util.Optional;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import com.example.Campings.bo.Camping;
import com.example.Campings.bo.Etoile;
import com.example.Campings.bo.Login;
import com.example.Campings.bo.Ville;
import com.example.Campings.dal.CampingRepository;
import com.example.Campings.dal.EtoileRepository;
import com.example.Campings.dal.LoginRepository;
import com.example.Campings.dal.VilleRepository;

@Service
@Scope("singleton")
public class CampingServiceImpl implements CampingService {

	//Lien avec couche DAL
	private CampingRepository campingRepo;
	private VilleRepository villeRepo;
	private EtoileRepository etoileRepo;
	private LoginRepository loginRepo;
	
	
	public CampingServiceImpl(CampingRepository campingRepo, VilleRepository villeRepo, EtoileRepository etoileRepo, LoginRepository loginRepo) {
		super();
		this.campingRepo = campingRepo;
		this.villeRepo = villeRepo;
		this.etoileRepo = etoileRepo;
		this.loginRepo = loginRepo;
		
	}
	
	//Login
	public Login login(String username, String password) {
	  Login user = loginRepo.findByUsernameAndPassword(username, password);
	   return user;
	  }
	 
	
	//Methode C du CRUD
	@Override
	public void ajouterCamping(Camping camping) {
		campingRepo.save(camping);	
	}

	//Methode R du CRUD
	@Override
	public List<Camping> getCampings() {
		return campingRepo.findAll();
	}

	//Ajout ville
	@Override
	public List<Ville> getVilles() {
		return villeRepo.findAll();
	}

	//Ajout étoile
	@Override
	public List<Etoile> getEtoiles() {
		return etoileRepo.findAll();
	}

	//Methode D du CRUD
	@Override
	public void deleteCamping(Long idC) {
		campingRepo.deleteById(idC);
	}


}

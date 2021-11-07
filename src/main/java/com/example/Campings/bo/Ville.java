package com.example.Campings.bo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ville implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idV;
	private String nom;
	private String departement;
		
	public Ville() {
		super();
	}
	
	public Ville(String nom, String departement) {
		super();
		this.nom = nom;
		this.departement = departement;
	}
	
	public Ville(Long idV, String nom, String departement) {
		super();
		this.idV = idV;
		this.nom = nom;
		this.departement = departement;
	}

	public Long getIdV() {
		return idV;
	}

	public void setIdV(Long idV) {
		this.idV = idV;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}
	
}

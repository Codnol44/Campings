package com.example.Campings.bo;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Camping implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idC;
	private String nom;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateArrivee;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateDepart;
	
	@Column(nullable = true, length = 64)
	private String photo;
	
	@ManyToOne
	private Ville ville;
	
	@ManyToOne
	private Etoile etoile;

	public Camping(Long idC, String nom, LocalDate dateArrivee, LocalDate dateDepart, String photo) {
		super();
		this.idC = idC;
		this.nom = nom;
		this.dateArrivee = dateArrivee;
		this.dateDepart = dateDepart;
		this.photo = photo;
	}
	
	public Camping(String nom, LocalDate dateArrivee, LocalDate dateDepart, String photo) {
		super();
		this.nom = nom;
		this.dateArrivee = dateArrivee;
		this.dateDepart = dateDepart;
		this.photo = photo;
	}
	
	public Camping() {
		super();
	}
	
	@Transient
	public String getPhotosImagePath() {
	    return "/bp/" + idC + "/" + photo;
	}

	public Long getIdC() {
		return idC;
	}

	public void setIdC(Long idC) {
		this.idC = idC;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public LocalDate getDateArrivee() {
		return dateArrivee;
	}

	public void setDateArrivee(LocalDate dateArrivee) {
		this.dateArrivee = dateArrivee;
	}

	public LocalDate getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(LocalDate dateDepart) {
		this.dateDepart = dateDepart;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	public Etoile getEtoile() {
		return etoile;
	}

	public void setEtoile(Etoile etoile) {
		this.etoile = etoile;
	}
	
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "Camping [idC=" + idC + ", nom=" + nom + ", dateArrivee=" + dateArrivee + ", dateDepart=" + dateDepart
				+ ", photo=" + photo + ", ville=" + ville + ", etoile=" + etoile + "]";
	}
	
}

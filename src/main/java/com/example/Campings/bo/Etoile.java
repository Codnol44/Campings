package com.example.Campings.bo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Etoile implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idE;
	private int nombre;
	
	public Etoile(Long idE, int nombre) {
		super();
		this.idE = idE;
		this.nombre = nombre;
	}
	
	public Etoile(int nombre) {
		super();
		this.nombre = nombre;
	}
	
	public Etoile() {
		super();
	}

	public Long getIdE() {
		return idE;
	}

	public void setIdE(Long idE) {
		this.idE = idE;
	}

	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}
	
	

}

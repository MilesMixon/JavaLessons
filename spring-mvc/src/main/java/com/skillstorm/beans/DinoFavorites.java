package com.skillstorm.beans;

import java.util.LinkedList;
import java.util.List;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope //the same as @Scope("Session")
public class DinoFavorites {

	private LinkedList<Dinosaur> dinos = new LinkedList<>();
	
	//method lvl access
	//have to enable method lvl access
	@PreAuthorize("hasRole('ADMIN')") //say whether a method is allowed to be envoked
	//@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
	//@PostAuthorize("hasRole('ADMIN')") //same as preauthorize but after the method runs
	//@Secured("ROLE_ADMIN")
	public List<Dinosaur> getDinos() {
		return dinos;
	}

	public void setDinos(LinkedList<Dinosaur> dinos) {
		this.dinos = dinos;
	}
	
	public void add(Dinosaur dino) {
		this.dinos.add(dino);
	}
}

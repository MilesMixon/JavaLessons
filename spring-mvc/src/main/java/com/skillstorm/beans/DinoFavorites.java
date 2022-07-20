package com.skillstorm.beans;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope //the same as @Scope("Session")
public class DinoFavorites {

	private LinkedList<Dinosaur> dinos = new LinkedList<>();
	
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

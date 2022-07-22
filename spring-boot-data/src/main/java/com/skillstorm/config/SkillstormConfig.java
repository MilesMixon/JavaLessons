package com.skillstorm.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

//better for config properties you will reuse a lot
@ConfigurationProperties(prefix = "skillstorm.classroom")
public class SkillstormConfig {

	private ChampionConfig champion;
	private String firstLoser;
	private String favTrainer;
	private String mascot;
	
	public ChampionConfig getChampion() {
		return champion;
	}

	public void setChampion(ChampionConfig champion) {
		this.champion = champion;
	}

	public String getFirstLoser() {
		return firstLoser;
	}
	
	public void setFirstLoser(String firstLoser) {
		this.firstLoser = firstLoser;
	}
	
	public String getFavTrainer() {
		return favTrainer;
	}
	
	public void setFavTrainer(String favTrainer) {
		this.favTrainer = favTrainer;
	}
	
	public String getMascot() {
		return mascot;
	}
	
	public void setMascot(String mascot) {
		this.mascot = mascot;
	}
}

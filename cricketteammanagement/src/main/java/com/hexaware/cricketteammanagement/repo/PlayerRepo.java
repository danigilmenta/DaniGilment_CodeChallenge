package com.hexaware.cricketteammanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.cricketteammanagement.entity.Player;



public interface PlayerRepo  extends JpaRepository<Player ,Integer> {

	
	
}

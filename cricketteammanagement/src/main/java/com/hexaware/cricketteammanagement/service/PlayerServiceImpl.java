package com.hexaware.cricketteammanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.cricketteammanagement.dto.PlayerDto;
import com.hexaware.cricketteammanagement.entity.Player;
import com.hexaware.cricketteammanagement.exception.PlayerNotFoundException;
import com.hexaware.cricketteammanagement.repo.PlayerRepo;
@Service
public class PlayerServiceImpl implements IPlayerService {

	@Autowired
	PlayerRepo repo;
	public Player dto2Entity(PlayerDto dto) {
		
		
		
		    Player p = new Player();

		    p.setPlayerId(dto.getPlayerId());
		    p.setPlayerName(dto.getPlayerName());
		    p.setJerseyNumber(dto.getJerseyNumber());
		    p.setRole(dto.getRole());
		    p.setTeamName(dto.getTeamName());
		    p.setStateName(dto.getStateName());
		    p.setDescriptionOfPlayer(dto.getDescriptionOfPlayer());
		    p.setTotalMatches(dto.getTotalMatches());

		   return p;
	
		
	}
	
	public  PlayerDto entity2Dto(Player p) {
		
		
		PlayerDto dto =new PlayerDto();
		
		dto.setPlayerId(p.getPlayerId());
		dto.setPlayerName(p.getPlayerName());
		dto.setJerseyNumber(p.getJerseyNumber());
		dto.setRole(p.getRole());
		dto.setTeamName(p.getTeamName());
		dto.setStateName(p.getStateName());
		dto.setDescriptionOfPlayer(p.getDescriptionOfPlayer());
		
		return dto;
		
	}
	
	@Override
	public List<PlayerDto> getall() {

	    List<Player> players = repo.findAll();   
	    List<PlayerDto> dtoList = new ArrayList<>(); 

	    for(Player p : players) {

	        PlayerDto dto = entity2Dto(p);  
	        dtoList.add(dto);                
	    }

	    return dtoList;

	}

	@Override
	public PlayerDto getById(int playerId) {
		

		 Player p = repo.findById(playerId)
		            .orElseThrow(() -> new PlayerNotFoundException("Player not found with id " + playerId));

		    return entity2Dto(p);		
	}

	@Override
	public PlayerDto addPlayer(PlayerDto dto) {
		

		Player p= dto2Entity(dto);
		

		    Player savedPlayer = repo.save(p);

		    return entity2Dto(savedPlayer);
	}

	@Override
		public PlayerDto update( PlayerDto dto) {

		 Player p = dto2Entity(dto);
		

		    Player updatedPlayer = repo.save(p);

		    return entity2Dto(updatedPlayer);
		    

		   
		}
	

	@Override
	public void deleteById(int playerId) {
		

		    repo.deleteById(playerId);

		

	}

}

package com.hexaware.cricketteammanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hexaware.cricketteammanagement.dto.PlayerDto;

public interface IPlayerService {

	public List<PlayerDto> getall();
	public PlayerDto getById(int playerId);
	public PlayerDto addPlayer(PlayerDto dto);
	public PlayerDto update(PlayerDto dto) ;
	public void deleteById(int playerId);
	
	
	
	
}

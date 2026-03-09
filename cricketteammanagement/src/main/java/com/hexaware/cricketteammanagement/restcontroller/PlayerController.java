package com.hexaware.cricketteammanagement.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.cricketteammanagement.dto.PlayerDto;
import com.hexaware.cricketteammanagement.service.IPlayerService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/player")
public class PlayerController {
	@Autowired
	IPlayerService service;
	
	
	@GetMapping("/getall")
	public List<PlayerDto> getAll() {
		return service.getall();
	}
	
	
	 @GetMapping("/get/{id}")
	    public PlayerDto getPlayerById(@PathVariable int id) {

	        return service.getById(id);

	    }
	 
	 @PostMapping("/addplayer")
	  public PlayerDto addplayer(@RequestBody   PlayerDto dto) {
		 
		 return service.addPlayer(dto);
		 
		 
		 
	 }
	 @PutMapping("/update")
	 public PlayerDto updatePlayer( @RequestBody PlayerDto dto) {

	     return service.update(dto);

	 }
	 @DeleteMapping("/delete/{id}")
	 public String deletePlayer(@PathVariable int id) {

	     service.deleteById(id);
	     return "Deleted";

	 }
	
	

}

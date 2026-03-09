package com.hexaware.cricketteammanagement.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class PlayerDto {
	

	  private int playerId;

	    @NotBlank(message = "Player name cannot be empty")
	    private String playerName;

	    @Min(value = 1, message = "Jersey number must be greater than 0")
	    private int jerseyNumber;

	    @NotBlank(message = "Role cannot be empty")
	    @Pattern(regexp = "Batsman|Bowler|Allrounder|Wicketkeeper",
	             message = "Role must be Batsman, Bowler, Allrounder or Wicketkeeper")
	    private String role;

	    @NotBlank(message = "Team name cannot be empty")
	    private String teamName;

	    @NotBlank(message = "State name cannot be empty")
	    private String stateName;

	    @NotBlank(message = "Description cannot be empty")
	    private String descriptionOfPlayer;

	    @Min(value = 0, message = "Total matches cannot be negative")
	    private int totalMatches;
		public PlayerDto() {
			
		}
		
		
		public PlayerDto(int playerId, String playerName, int jerseyNumber, String role, int totalMatches,
				String teamName, String stateName, String descriptionOfPlayer) {
			super();
			this.playerId = playerId;
			this.playerName = playerName;
			this.jerseyNumber = jerseyNumber;
			this.role = role;
			this.totalMatches = totalMatches;
			this.teamName = teamName;
			this.stateName = stateName;
			this.descriptionOfPlayer = descriptionOfPlayer;
		}
		public int getPlayerId() {
			return playerId;
		}
		public void setPlayerId(int playerId) {
			this.playerId = playerId;
		}
		public String getPlayerName() {
			return playerName;
		}
		public void setPlayerName(String playerName) {
			this.playerName = playerName;
		}
		public int getJerseyNumber() {
			return jerseyNumber;
		}
		public void setJerseyNumber(int jerseyNumber) {
			this.jerseyNumber = jerseyNumber;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		public int getTotalMatches() {
			return totalMatches;
		}
		public void setTotalMatches(int totalMatches) {
			this.totalMatches = totalMatches;
		}
		public String getTeamName() {
			return teamName;
		}
		public void setTeamName(String teamName) {
			this.teamName = teamName;
		}
		public String getStateName() {
			return stateName;
		}
		public void setStateName(String stateName) {
			this.stateName = stateName;
		}
		public String getDescriptionOfPlayer() {
			return descriptionOfPlayer;
		}
		public void setDescriptionOfPlayer(String descriptionOfPlayer) {
			this.descriptionOfPlayer = descriptionOfPlayer;
		}
		@Override
		public String toString() {
			return "PlayerEntity [playerId=" + playerId + ", playerName=" + playerName + ", jerseyNumber=" + jerseyNumber
					+ ", role=" + role + ", totalMatches=" + totalMatches + ", teamName=" + teamName + ", stateName="
					+ stateName + ", descriptionOfPlayer=" + descriptionOfPlayer + "]";
		}
		
		
		
		
		
		
	}



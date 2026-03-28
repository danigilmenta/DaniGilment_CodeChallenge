import React, { useState } from "react";
import { addPlayer } from "./PlayerServices";


const AddPlayerForm = ({ loadPlayers }) => {
  const [player, setPlayer] = useState({
    playerName: "",
    jerseyNumber: "",
    role: "",
    teamName: "",
    stateName: "",
    totalMatches: "",
    descriptionOfPlayer: ""
  });

  const handleChange = (e) => {
    const { name, value } = e.target;

    setPlayer({
    ...player,
    [name]: value
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    addPlayer(player)
      .then(() => {
        loadPlayers();
        setPlayer({
          playerName: "",
          jerseyNumber: "",
          role: "",
          teamName: "",
          stateName: "",
          totalMatches: "",
          descriptionOfPlayer: ""
        });
      })
      .catch(err => console.log(err.response?.data));
  };

  return (
    <form onSubmit={handleSubmit}>
      <h3>Add Player</h3>

      <input name="playerName" placeholder="Name" onChange={handleChange} />

      <input name="jerseyNumber" type="number" placeholder="Jersey" onChange={handleChange} />

      {/* 🔥 ROLE DROPDOWN */}
      <select name="role" onChange={handleChange}>
        <option value="">Select Role</option>
        <option value="Batsman">Batsman</option>
        <option value="Bowler">Bowler</option>
        <option value="Allrounder">Allrounder</option>
        <option value="Wicketkeeper">Wicketkeeper</option>
      </select>

      <input name="teamName" placeholder="Team" onChange={handleChange} />

      <input name="stateName" placeholder="State" onChange={handleChange} />

      <input name="totalMatches" type="number" placeholder="Matches" onChange={handleChange} />

      <input name="descriptionOfPlayer" placeholder="Description" onChange={handleChange} />

      <button type="submit">Add</button>
    </form>
  );
};

export default AddPlayerForm;
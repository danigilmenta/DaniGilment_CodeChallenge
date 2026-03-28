import React, { useState, useEffect } from "react";
import { updatePlayer } from "./PlayerServices";


const UpdatePlayerForm = ({ player, loadPlayers, clearEdit }) => {
  const [updatedPlayer, setUpdatedPlayer] = useState(player);

  useEffect(() => {
    setUpdatedPlayer(player);
  }, [player]);

  const handleChange = (e) => {
    const { name, value } = e.target;

    setUpdatedPlayer({
      ...updatedPlayer,
      [name]:value
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    updatePlayer(updatedPlayer)
      .then(() => {
        loadPlayers();
        clearEdit();
      })
      .catch(err => console.log(err.response?.data));
  };

  return (
    <form onSubmit={handleSubmit}>
      <h3>Update Player</h3>

      <input value={updatedPlayer.playerName} name="playerName" onChange={handleChange} />

      <input value={updatedPlayer.jerseyNumber} name="jerseyNumber" type="number" onChange={handleChange} />

      <select name="role" value={updatedPlayer.role} onChange={handleChange}>
        <option value="Batsman">Batsman</option>
        <option value="Bowler">Bowler</option>
        <option value="Allrounder">Allrounder</option>
        <option value="Wicketkeeper">Wicketkeeper</option>
      </select>

      <input value={updatedPlayer.teamName} name="teamName" onChange={handleChange} />

      <input value={updatedPlayer.stateName} name="stateName" onChange={handleChange} />

      <input value={updatedPlayer.totalMatches} name="totalMatches" type="number" onChange={handleChange} />

      <input value={updatedPlayer.descriptionOfPlayer} name="descriptionOfPlayer" onChange={handleChange} />

      <button type="submit">Update</button>
      <button type="button" onClick={clearEdit}>Cancel</button>
    </form>
  );
};

export default UpdatePlayerForm;
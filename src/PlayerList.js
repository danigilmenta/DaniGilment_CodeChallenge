import React, { useEffect, useState } from "react";
import {
  getAllPlayers,
  deletePlayer,
  getPlayerByJersey
} from "./PlayerServices";

import AddPlayerForm from "./AddPlayerForm";
import UpdatePlayerForm from "./UpdatePlayerForm";

const PlayerList = () => {
  const [players, setPlayers] = useState([]);
  const [editPlayer, setEditPlayer] = useState(null);

  const [jerseyNumber, setJerseyNumber] = useState("");
  const [searchedPlayer, setSearchedPlayer] = useState(null);

  useEffect(() => {
    loadPlayers();
  }, []);

  const loadPlayers = () => {
    getAllPlayers().then((res) => setPlayers(res.data));
  };

  const handleDelete = (id) => {
    deletePlayer(id).then(() => loadPlayers());
  };

  const handleEdit = (player) => {
    setEditPlayer(player);
  };

  const handleSearch = () => {
    if (!jerseyNumber) {
      alert("Enter jersey number");
      return;
    }

    getPlayerByJersey(jerseyNumber)
      .then((res) => {
        setSearchedPlayer(res.data);
      })
      .catch(() => {
        alert("Player not found");
        setSearchedPlayer(null);
      });
  };

  return (
    <div className="container mt-4">

      <h2 className="text-center mb-4">Cricket Team Management</h2>

     
      <div className="card p-3 mb-3">
        <AddPlayerForm loadPlayers={loadPlayers} />
      </div>

    
      {editPlayer && (
        <div className="card p-3 mb-3">
          <UpdatePlayerForm
            player={editPlayer}
            loadPlayers={loadPlayers}
            clearEdit={() => setEditPlayer(null)}
          />
        </div>
      )}

      <div className="card p-3 mb-3">
        <h5>Search by Jersey Number</h5>

        <div className="d-flex gap-2">
          <input
            type="number"
            className="form-control"
            placeholder="Enter Jersey Number"
            value={jerseyNumber}
            onChange={(e) => setJerseyNumber(e.target.value)}
          />

          <button className="btn btn-primary" onClick={handleSearch}>
            Search
          </button>

          <button
            className="btn btn-secondary"
            onClick={() => {
              setSearchedPlayer(null);
              setJerseyNumber("");
            }}
          >
            Clear
          </button>
        </div>
      </div>

   
      {searchedPlayer && (
        <div className="card p-3 mb-3">
          <h5>Search Result</h5>

          <table className="table table-bordered table-striped">
            <thead className="table-dark">
              <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Jersey</th>
                <th>Role</th>
              </tr>
            </thead>

            <tbody>
              <tr>
                <td>{searchedPlayer.playerId}</td>
                <td>{searchedPlayer.playerName}</td>
                <td>{searchedPlayer.jerseyNumber}</td>
                <td>{searchedPlayer.role}</td>
              </tr>
            </tbody>
          </table>
        </div>
      )}

 
      <div className="card p-3">
        <h5>All Players</h5>

        <table className="table table-bordered table-hover">
          <thead className="table-primary">
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Jersey</th>
              <th>Role</th>
              <th>Actions</th>
            </tr>
          </thead>

          <tbody>
            {players.map((p) => (
              <tr key={p.playerId}>
                <td>{p.playerId}</td>
                <td>{p.playerName}</td>
                <td>{p.jerseyNumber}</td>
                <td>{p.role}</td>
                <td>
                  <button
                    className="btn btn-warning btn-sm me-2"
                    onClick={() => handleEdit(p)}
                  >
                    Edit
                  </button>

                  <button
                    className="btn btn-danger btn-sm"
                    onClick={() => handleDelete(p.playerId)}
                  >
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>

    </div>
  );
};

export default PlayerList;
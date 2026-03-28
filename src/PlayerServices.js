import axios from "axios";

const API_URL = "http://localhost:8080/api/player";

export const getAllPlayers = () => {
  return axios.get(`${API_URL}/getall`);
};

export const getPlayerById = (id) => {
  return axios.get(`${API_URL}/get/${id}`);
};

export const addPlayer = (player) => {
  return axios.post(`${API_URL}/addplayer`, player);
};

export const updatePlayer = (player) => {
  return axios.put(`${API_URL}/update`, player);
};

export const deletePlayer = (id) => {
  return axios.delete(`${API_URL}/delete/${id}`);
};
export const getPlayerByJersey = (number) => {
  return axios.get(`${API_URL}/jersey/${number}`);
};
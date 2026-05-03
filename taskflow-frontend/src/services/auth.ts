import axios from "axios";

const API = "http://localhost:8080/api/auth";

export const loginUser = async (email: string, password: string) => {
  const res = await axios.post(`${API}/login`, {
    email,
    password,
  });

  localStorage.setItem("token", res.data.token);
  return res.data;
};
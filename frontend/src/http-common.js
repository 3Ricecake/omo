import axios from "axios";

export default axios.create({
  // baseURL: "http://j3a509.p.ssafy.io/api",
  baseURL: "http://localhost:8080",
  // headers: {
  //   "Content-type": "application/json",
  // }
});
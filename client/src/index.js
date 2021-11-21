import React from "react";
import ReactDOM from "react-dom";
import "./index.css";

import { gql } from "@apollo/client";

import client from "./state/Client";

import App from "./components/App";

client
  .query({
    query: gql`
      query {
        allLinks {
          id
          url
          description
        }
      }
    `
  })
  .then(result => console.log(result));

ReactDOM.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>,
  document.getElementById("root")
);

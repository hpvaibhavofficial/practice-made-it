import React, { useState } from "react";
import FoodItem from "./components/FoodItem";
import "bootstrap/dist/css/bootstrap.min.css";
import ErrorMessage from "./components/ErrorMessage";
import "./App.css";
import Container from "./components/Container";
import FoodInput from "./components/FoodInput";

export default function App() {
  let arr = ["Dal", "Chapati", "Matar Paneer", "Mix Veg", "Salad", "Milk"];

  // let [tts,setTTs] = useState("Here content will display.")
  const handleChange = (e) => {
    // setTTs(e.target.value)
  };

  return (
    <>
      <Container>
        <ErrorMessage items={arr} />
        <FoodInput handleChange={handleChange} />
        {/* <p>{tts}</p> */}
        <FoodItem items={arr} />
      </Container>

      <Container>
        <p>This is list of tonight's menu.</p>
      </Container>
    </>
  );
}

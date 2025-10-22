import React, { useState } from "react";
import FoodItem from "./components/FoodItem";
import "bootstrap/dist/css/bootstrap.min.css";
import ErrorMessage from "./components/ErrorMessage";
import "./App.css";
import Container from "./components/Container";
import FoodInput from "./components/FoodInput";

export default function App() {
  //let arr = ["Dal", "Chapati", "Matar Paneer", "Mix Veg", "Salad", "Milk"];
  // let [tts,setTTs] = useState("Here content will display.")
  
  let [foodItems , setFoodItems] = useState(["Ghee","Paneer"]);
  const onKeyDown = (e) => {
    // setTTs(e.target.value)
    if(e.key === 'Enter'){
      let newItem = e.target.value;
      setFoodItems([...foodItems,newItem]);
    }   
  };

  

  return (
    <>
      <Container>
        <ErrorMessage items={foodItems} />
        <FoodInput handleChange={onKeyDown} />
        {/* <p>{tts}</p> */}
        <FoodItem items={foodItems} />
      </Container>

      <Container>
        <p>This is list of tonight's menu.</p>
      </Container>
    </>
  );
}

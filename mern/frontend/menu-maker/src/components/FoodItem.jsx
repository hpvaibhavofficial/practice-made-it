import { useState } from "react";
import Item from "./Item";

function FoodItem({ items }) {
  let [activeItems,setActiveItems] = useState([]);
  const handleBuyButton = (e,item) =>{
      let newItems = [...activeItems,item];
      setActiveItems(newItems)
  }
  return (
    <>
      <ul className="list-group">
        {items.map((item) => (
          <Item
            key={item}
            fooditem={item}
            bought ={activeItems.includes(item)}
            handleBuyButton={(event) => (handleBuyButton(event,item))}
          />
        ))}
      </ul>
    </>
  );
}

export default FoodItem;

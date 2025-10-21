import Item from "./Item";

function FoodItem({ items }) {
  return (
    <>
      <ul className="list-group">
        {items.map((item) => (
          <Item
            key={item}
            fooditem={item}
            handleBuyButton={() => console.log(`Item Bought ${item}`)}
          />
        ))}
      </ul>
    </>
  );
}

export default FoodItem;

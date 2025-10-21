import styles from "./FoodInput.module.css";

const FoodInput = ({ handleChange }) => {
  return (
    <input
      type="text"
      placeholder="Enter food item here"
      className={styles.foodInput}
      onChange={handleChange}
    />
  );
};
export default FoodInput;

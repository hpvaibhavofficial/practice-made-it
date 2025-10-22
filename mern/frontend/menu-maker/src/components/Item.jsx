import styles from "./Item.module.css";

function Item({ fooditem, bought, handleBuyButton }) {
  //console.log("Loaded styles:", styles);
  return (
    <li className={`${styles["vb-item"]} list-group-item ${bought && 'active' }`}>
      <span className={styles["vb-span"]}>{fooditem}</span>
      <button
        className={` ${styles.button} btn btn-success`}
        onClick={handleBuyButton}
      >
      Buy
      </button>
    </li>
  );
}

export default Item;

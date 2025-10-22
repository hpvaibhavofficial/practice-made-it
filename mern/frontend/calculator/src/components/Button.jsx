import styles from "./Button.module.css";
function Button({ btn , onButtonClick}) {
  return (
    <>
      <button className={styles.button} onClick={() => onButtonClick(btn)}>{btn}</button>
    </>
  );
}
export default Button;

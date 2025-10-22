import Button from "./Button";
import styles from "./ButtonsContainer.module.css";

function ButtonsContainer({ btns , handleDisplay }) {
  return (
    <>
      <div className={styles.buttonsContainer}>
        {btns.map((btn) => (
          <Button key={btn} btn={btn} onButtonClick = {handleDisplay} />
        ))}
      </div>
    </>
  );
}
export default ButtonsContainer;

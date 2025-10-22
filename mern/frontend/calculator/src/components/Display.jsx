import { useState } from "react";
import ButtonsContainer from "./ButtonsContainer";
import styles from "./Display.module.css";

function Display() {
  const [displayTxt, setDisplay] = useState("");
  const handleDisplay = (btnTxt) => {
    if(btnTxt === 'C'){
        setDisplay("")
    } else if(btnTxt === '='){
      let res = eval(displayTxt)
      setDisplay(res)
    } else{
      setDisplay(displayTxt + btnTxt);
    }
    
  }

  const buttons = [
    "C",
    "1",
    "2",
    "+",
    "3",
    "4",
    "-",
    "5",
    "6",
    "*",
    "7",
    "8",
    "/",
    "9",
    "0",
    ".",
    "=",
  ];
  return (
    <>
      <div className={styles.calculator}>
        <input className={styles.display} type="text" value = {displayTxt} readOnly/>
        <ButtonsContainer btns={buttons} handleDisplay= {handleDisplay}/>
      </div>
    </>
  );
}
export default Display;

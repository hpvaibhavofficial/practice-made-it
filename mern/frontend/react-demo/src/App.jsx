import Menu from './components/Menu'
import 'bootstrap/dist/css/bootstrap.min.css';
import Container from './components/Container';
import { useState } from 'react';

/*state represents the data that changes over time.
Every component has its own state.
State can only be changed with its updater function. We cannot change state of a var using normal js in  react as it do not tells react to re render component automatically.
*/



function App() {
  let [tts , updater] = useState("This text will be shown there.s");
  const updaterFun = (e) =>{
    console.log(e.target.value);
    updater(e.target.value)
  }

  return (

    <Container>
      <Menu handleOnChange={updaterFun} />
      <p>{tts}</p>
    </Container>


  ) 
}

export default App

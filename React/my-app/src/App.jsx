import Header from './Header.jsx'; 
import Footer from './Footer.jsx'; 
import Cond from './Cond.jsx';
import Card from './Card.jsx';
import Button from './Button.jsx';
import List from './List.jsx';

function App() {
    return (
        <>
            <Header title="Tournament Hub" />
            <Card title="Mega Tournament - 01" />
            <Card title="4 vs 4 Series Tournament" />
            <Card title="Mega Tournament - 02" />
            <Card title="BR Tournament - 001" />
            <Button />
            <Cond isEnabled = {false} username ="Vaibhav Bhardwaj"/>
            <List />
            <Footer />
        
        </>
    );
}

export default App;


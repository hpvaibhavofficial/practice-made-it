function Food(){
    const food1 = "Apple"
    const food2 = "Banana"
    const food3 = "Mango"
    const food4 = "PineApple"

    return(
        <ul>
            <li>Guava</li>
            <li>{food1}</li>
            <li>{food2}</li>
            <li>{food3.toLowerCase()}</li>
            <li>{food4.toUpperCase()}</li>
        </ul>
    );
}
export default Food;
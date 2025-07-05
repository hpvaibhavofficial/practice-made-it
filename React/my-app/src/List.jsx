function List(){
    const fruits =["Apple","Mango","Banana","Pineapple","Oranges"]
    fruits.sort();
    const listItems = fruits.map(fruit => <li>{fruit}</li>)
    
    return (
        <ol>{listItems}</ol>
    );
}
export default List;
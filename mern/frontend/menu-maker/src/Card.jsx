function Card({ name = "Alice", description = "This is the description." }) {
  return (
    <div className="card">
      <img
        className="card-image"
        src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTrCXtELPLwJFnq4sdWbvL5F-HAxQspRqwZyA&s"
        alt="Profile"
      />
      <h3 className="card-title">Name: {name}</h3>
      <p className="card-text">{description}</p>
    </div>
  );
}

export default Card;

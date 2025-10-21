import styles from "./MenuItem.module.css";

function MenuItem({ image, name, model, fuelType, mileage,handleCLicks }) {
  return (
    <div className={styles.card}>
      <img src={image} alt={`${name} ${model}`} className={styles.image} />
      <div className={styles.content}>
        <h3 className={styles.title}>
          {name} <span className={styles.model}>{model}</span>
        </h3>
        <p className={styles.detail}>
          <strong>Fuel Type:</strong> {fuelType}
        </p>
        <p className={styles.detail}>
          <strong>Mileage:</strong> {mileage.toLocaleString()} km
        </p>
        <button onClick={handleCLicks} className="btn btn-primary">Rent Now</button>
      </div>
    </div>
  );
}

export default MenuItem;

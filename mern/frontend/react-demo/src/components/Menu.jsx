import MenuItem from "./MenuItem";
import styles from "./Menu.module.css"
function Menu({handleOnChange}) {
const vehicleInventory = [
  {
    id: 1,
    image: "https://images.unsplash.com/photo-1555215695-3004980ad54e?auto=format&fit=crop&w=800&q=80",
    name: "Audi",
    model: "A4",
    fuelType: "Gasoline",
    mileage: 8000,
  },
  {
    id: 2,
    image: "https://images.unsplash.com/photo-1555215695-3004980ad54e?auto=format&fit=crop&w=800&q=80",
    name: "Tesla",
    model: "Model Y",
    fuelType: "Electric",
    mileage: 200,
  },
  {
    id: 3,
    image: "https://images.unsplash.com/photo-1555215695-3004980ad54e?auto=format&fit=crop&w=800&q=80",
    name: "Volkswagen",
    model: "Golf GTI",
    fuelType: "Gasoline",
    mileage: 18000,
  },
  {
    id: 4,
    image: "https://images.unsplash.com/photo-1555215695-3004980ad54e?auto=format&fit=crop&w=800&q=80",
    name: "Ford",
    model: "Ranger",
    fuelType: "Diesel",
    mileage: 35000,
  },
  {
    id: 5,
    image: "https://images.unsplash.com/photo-1555215695-3004980ad54e?auto=format&fit=crop&w=800&q=80",
    name: "Ducati",
    model: "Panigale V4",
    fuelType: "Gasoline",
    mileage: 150,
  },
  {
    id: 6,
    image: "https://images.unsplash.com/photo-1555215695-3004980ad54e?auto=format&fit=crop&w=800&q=80",
    name: "Chevrolet",
    model: "Corvette Stingray",
    fuelType: "Gasoline",
    mileage: 99000,
  },
  {
    id: 7,
    image: "https://images.unsplash.com/photo-1555215695-3004980ad54e?auto=format&fit=crop&w=800&q=80",
    name: "Mercedes-Benz",
    model: "Sprinter Cargo",
    fuelType: "Diesel",
    mileage: 65000,
  },
  {
    id: 8,
    image: "https://images.unsplash.com/photo-1555215695-3004980ad54e?auto=format&fit=crop&w=800&q=80",
    name: "Mazda",
    model: "MX-5 Miata",
    fuelType: "Gasoline",
    mileage: 500,
  },
];

 return (
    <div className={styles.menuWrapper}>
      <input
        onChange={handleOnChange}
        className={styles.search}
        type="text"
        placeholder="Search Cars by name"
      />

      <div className={styles.menuContainer}>
        {vehicleInventory.map((v) => (
          <MenuItem
            key={v.id}
            image={v.image}
            name={v.name}
            fuelType={v.fuelType}
            model={v.model}
            mileage={v.mileage}
            handleCLicks={() =>
              console.log(`Details \nModel = ${v.model}\nName = ${v.name}`)
            }

          />
        ))}
      </div>
    </div>
  );
}

export default Menu;

//   return (
//     <div className={styles.menuContainer}>
//       <input className="search" type="text" placeholder="Search Cars by name" />
//       {vehicleInventory.map((v) => (
//         <MenuItem
//           key={v.id}
//           image={v.image}
//           name = {v.name}
//           fuelType= {v.fuelType}
//           model = {v.model}
//           mileage = {v.mileage}
//           handleCLicks={() => (console.log(`Details \n model = ${v.model} \n Name = ${v.name}`))}
//         />
//       ))}
//     </div>
//   );
// }

// export default Menu;

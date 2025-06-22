

function Button() {
    const styles = {
    backgroundColor: "hsl(0, 99%, 49%",
    color: "white",
    padding: "10px 10px",
    alignItems: "center",
    borderRadius: "5px",
    cursor: "pointer",
    border:" none"
    }

    return (
        <button style={styles}>
            Click Me
        </button>
    );
}

export default Button;

function ErrorMessage({ items }) {
  return (
    <>
      {items.length === 0 ? (
        <h2>Something went wrong fetching details.</h2>
      ) : null}
    </>
  );
}
export default ErrorMessage;

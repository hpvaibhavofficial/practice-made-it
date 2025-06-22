
import PropTypes from "prop-types";

function Cond(props) {

    const welcomeText = <h2 className="logged">Welcome {props.username}</h2>;
    const logoutText = <h2 className="tryy">Login first</h2>;

    return props.isEnabled ? welcomeText : logoutText;
}

Cond.propTypes = {
    username: PropTypes.string,
    isEnabled: PropTypes.bool.isRequired,
};

Cond.defaultProps = {
    username: "Guest",
};

export default Cond;

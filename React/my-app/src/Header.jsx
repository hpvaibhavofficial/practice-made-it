import PropTypes from 'prop-types';

function Header({title ='svshshsh'}) {
    return (
        <header className="header">
            <h1 className="logo">{title}</h1>
            <nav>
                <ul className="nav-menu">
                    <li><a href="/">Home</a></li>
                    <li><a href="/">About</a></li>
                    <li><a href="/">Services</a></li>
                    <li><a href="/">Contact</a></li>
                </ul>
            </nav>
        </header>
    );
}

Header.defaultProps = {
    title: "Website Name Here",
};

Header.propTypes = {
    title: PropTypes.string,
};

export default Header;

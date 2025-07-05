import logx from './assets/logo.jpg';
import PropTypes from 'prop-types'

function Card(props) {
    return (
        <div className="card">
            <img className='card-img' src={logx} alt="profile picture" />
            <h3 className='card-title'>{props.title}</h3>
            <p className='card-text'>
                This is a mega Free Fire tournament in which more than 25 teams are taking part.
            </p>
        </div>
    );
}
Card.propTypes = {
    title: PropTypes.string,
}

export default Card;

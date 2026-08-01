import './Popup.css'

function PopUp({selectedDay, onClose})
{
    return(
        <div className="pop-up-placement">
            <div className="pop-up">
            <h3>Day: {selectedDay.day}</h3>
                <p>Info: {selectedDay.info}</p>
                <p>Details:{selectedDay.details}</p>
                <button onClick={(e) =>{
                    e.stopPropagation(); //if my close button overlaps with any day of the week
                    //this prevents it from activing for example if my Close button is on top 
                    //of monday when I click close monday pop up will not open
                    //Basically prevents the click from travelling upwards
                    onClose();
                }}>
                    Close
                </button>
            </div>
        </div>
    )
}

export default PopUp
import './Popup.css'

function HomePopUp({onClose})
{
    return(
        <div className="pop-up-placement">
            <div className="home-pop-up">
                <div>
                    <label>Meal Name: </label>
                    <input />
                </div>
                <div>
                    <label>Select Meal: </label>
                    <input/>
                </div>
                <div>
                    <label>Create new Meal:</label>
                    <input />
                </div>
                <div>
                    <label>Calories:</label>
                    <input />
                </div>
                <div>
                    <button>
                        Save
                    </button>
                    <button onClick={(e)=>{
                        e.stopPropagation();
                        onClose();
                    }}>
                        Close
                </button>
                </div>
                
            </div>
        </div>
    )
}

export default HomePopUp

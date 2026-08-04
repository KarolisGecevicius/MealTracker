import { useState } from "react"
import HomePopUp from "../components/HomePopup";


function Home()
{
    const [expandedHomePopUp, setExpandedHomePopUp]=useState(false);
    function closeHomePopUp()
    {
        setExpandedHomePopUp(false)
    }

    return (
        <div>
            <h1> Home</h1>
            <p> Welcome</p>
            <button onClick={() => setExpandedHomePopUp(true)}>
                Add Meal
            </button>


            {expandedHomePopUp && (
                <HomePopUp
                    onClose={closeHomePopUp}
                />
            )}
        </div>
    )
}
export default Home
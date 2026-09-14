import './Popup.css'
import { useEffect, useState } from 'react';


function HomePopUp({onClose})
{
    const [foods, setFoods] = useState([]);
    const [search, setSearch] = useState("");
    const [showOptions, setShowOptions] = useState(false);
    const [selectedFood, setSelectedFood] = useState(null);

    useEffect(() => {
    fetch("http://localhost:8080/foods")
        .then(response => response.json())
        .then(data => {
            console.log("Foods received:", data);
            setFoods(data);
        })
        .catch(error => {
            console.error("Error fetching foods:", error);
        });
}, []);

    return(
        <div className="pop-up-placement">
            <div className="home-pop-up">
                <div>
                    <label>Select Meal: </label>
                    <input
                        type="text"
                        placeholder='Search'
                        value={search}
                        onFocus={() => setShowOptions(true)}
                        onChange={(e) => {
                            setSearch(e.target.value);
                            setSelectedFood(null)
                            setShowOptions(true);
                        }}
                    />
                    {showOptions && (
                        <div className = "food-selection">
                            {foods
                            .filter(food =>
                                food.name.toLowerCase().includes(search.toLowerCase())
                            )
                            .map(food => (
                                <div 
                                    key = {food.id}
                                    onClick={() => {
                                        setSelectedFood(food)
                                        setSearch("")
                                        setShowOptions(false)
                                    }}
                                >
                                    {food.name}
                                </div>
                            ))
                        }
                        </div>
                    )}
                </div>
                <div>
                    <label>Meal type:</label>
                    <select>
                        <option value="Breakfast">Breakfast</option>
                        <option value="Lunch">Lunch</option>
                        <option value="Dinner">Dinner</option>
                    </select>
                </div>
                <div>
                    <label>Calories:</label>
                    <input />
                </div>
                <div>
                    <label>Carbs:</label>
                    <input />
                </div>
                <div>
                    <label>Protein:</label>
                    <input />
                </div>
                <div>
                    <label>Fat:</label>
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

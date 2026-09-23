import './Popup.css'
import { useEffect, useState } from 'react';


function HomePopUp({onClose})
{
    const [foods, setFoods] = useState([]);
    const [search, setSearch] = useState("");
    const [showOptions, setShowOptions] = useState(false);
    const [selectedFood, setSelectedFood] = useState(null);
    const [amountGrams, setAmountGrams] = useState(100);
    const [manualChange, setManualChange] = useState(false);

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
                        value={selectedFood ? selectedFood.name : search}
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
                    <label>Grams:</label>
                    <input 
                        value={amountGrams}
                        onBlur={(e)=>
                            setAmountGrams(e.target.value)
                        }
                        onChange={(e)=>{
                            setAmountGrams(e.target.value)
                        }}
                        type="number"
                    />
                </div>
                <div>
                    <label>Calories:</label>
                    <input 
                        type = "number"
                        value = {selectedFood ? selectedFood.calories*(amountGrams/100) :  "" }
                        onBlur={(e) => {
                            setSelectedFood({...selectedFood, calories:e.target.value})
                        }}
                        onChange={(e)=>{
                            const num = e.target.value
                            setSelectedFood({...selectedFood, calories: num})
                            setManualChange(true)
                        }}
                    />

                </div>
                <div>
                    <label>Carbs:</label>
                    <input 
                        type = "number"
                        value = {selectedFood ?  selectedFood.carbs*(amountGrams/100) : ""}
                        onBlur={(e) => {
                            setSelectedFood({...selectedFood, carbs: e.target.value})
                        }}
                        onChange={(e)=>{
                            const num = e.target.value
                            setSelectedFood({...selectedFood, carbs: num})
                            setManualChange(true)
                        }}
                    />
                </div>
                <div>
                    <label>Protein:</label>
                    <input 
                        type = "number"
                        value = {selectedFood ? selectedFood.protein*(amountGrams/100) : ""}
                        onBlur={(e) => {
                            setSelectedFood({...selectedFood, protein: e.target.value})
                        }}
                        onChange={(e)=>{
                            const num = e.target.value
                            setSelectedFood({...selectedFood, protein: num})
                            setManualChange(true)
                        }}
                    />
                </div>
                <div>
                    <label>Fat:</label>
                    <input 
                        type = "number"
                        value = {selectedFood ? selectedFood.fat*(amountGrams/100):  ""}
                        onBlur={(e) => {
                            setSelectedFood({...selectedFood, fat: e.target.value})
                        }}
                        onChange={(e)=>{
                            const num = e.target.value
                            setSelectedFood({...selectedFood, fat: num})
                            setManualChange(true)
                        }}
                    />
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

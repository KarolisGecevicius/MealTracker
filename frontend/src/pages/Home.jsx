import { useState } from "react"
import HomePopUp from "../components/HomePopUp";


function Home()
{
    const[mealData, addMeals] = useState([]);
    const [expandedHomePopUp, setExpandedHomePopUp]=useState(false);    
    const breakfastMeals =[];
    const lunchMeals =[];
    const dinnerMeals =[];
    const formatter = (n) => parseFloat(n.toFixed(4))

     function closeHomePopUp()
    {
        setExpandedHomePopUp(false)
    }

    function MealAdder(meal)
    {
        addMeals([...mealData, meal])
    }
    

    for(let i=0; i<mealData.length; i++)
    {
        console.log(mealData.at(i).time)
        if(mealData.at(i).time=="Breakfast")
        {
            breakfastMeals.push(mealData.at(i))
        }
        if(mealData.at(i).time=="Lunch")
        {
            lunchMeals.push(mealData.at(i))
        }
        if(mealData.at(i).time=="Dinner")
        {
            dinnerMeals.push(mealData.at(i))
        }
    }
   

    return (
        <div className="home-page">
            <h1> Home</h1>
            <p> Welcome</p>
            <button className= "add-meal-button" onClick={() => setExpandedHomePopUp(true)}>
                +Add Meal
            </button>

            <div className="meals-container">
                <h2>Breakfast</h2>
                <div className="meal-list">
                    {breakfastMeals.map((breakFastItem,index) => (
                    <div
                        key={index}
                        className="meal-card"
                    >
                        <h3>{breakFastItem.name}</h3>
                        <p className="meal-type">{breakFastItem.type}</p>
                        <p className="meal-calories">Calories: {formatter(breakFastItem.calories*(breakFastItem.grams/100))}</p>
                        <p className="meal-grams">Grams: {breakFastItem.grams}</p>
                    </div>
                    ))}
                </div>
                <h2>Lunch</h2>
                <div className="meal-list">
                    {lunchMeals.map((lunchItem,index) => (
                    <div
                        key={index}
                        className="meal-card"
                    >
                        <h3>{lunchItem.name}</h3>
                        <p className="meal-type">{lunchItem.type}</p>
                        <p className="meal-calories">Calories: {lunchItem.calories}</p>
                        <p className="meal-grams">Grams: {lunchItem.grams}</p>
                    </div>
                    ))}
                </div>
                <h2>Dinner</h2>
                <div className="meal-list">
                    {dinnerMeals.map((dinnerItem,index) => (
                    <div
                        key={index}
                        className="meal-card"
                    >
                        <h3>{dinnerItem.name}</h3>
                        <p className="meal-type">{dinnerItem.type}</p>
                        <p className="meal-calories">Calories: {dinnerItem.calories}</p>
                        <p className="meal-grams">Grams: {dinnerItem.grams}</p>
                    </div>
                    ))}
                </div>
            </div>


            {expandedHomePopUp && (
                <HomePopUp
                    mealAdd={MealAdder}
                    onClose={closeHomePopUp}
                />
            )}
        </div>
    )
}
export default Home
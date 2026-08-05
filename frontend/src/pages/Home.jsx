import { useState } from "react"
import HomePopUp from "../components/HomePopup";


function Home()
{
    const mealData = [
        { name: "Chicken", type: "Lunch", calories: "500" },
        { name: "Yogurt", type: "Breakfast", calories: "200" },
        { name: "Fruits", type: "Dinner", calories: "400" },
        { name: "Eggs", type: "Breakfast", calories: "300" }
    ];

    const breakfastMeals =[];
    const lunchMeals =[];
    const dinnerMeals =[];


    for(let i=0; i<mealData.length; i++)
    {
        if(mealData.at(i).type=="Breakfast")
        {
            breakfastMeals.push(mealData.at(i))
        }
        if(mealData.at(i).type=="Lunch")
        {
            lunchMeals.push(mealData.at(i))
        }
        if(mealData.at(i).type=="Dinner")
        {
            dinnerMeals.push(mealData.at(i))
        }
    }
    const [expandedHomePopUp, setExpandedHomePopUp]=useState(false);
    function closeHomePopUp()
    {
        setExpandedHomePopUp(false)
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
                        <p className="meal-calories">{breakFastItem.calories}</p>
                    </div>
                    ))}
                </div>
                <h2>Lunch</h2>
                <div>
                    {lunchMeals.map((lunchItem,index) => (
                    <div
                        key={index}
                        className="meal-card"
                    >
                        <h3>{lunchItem.name}</h3>
                        <p className="meal-type">{lunchItem.type}</p>
                        <p className="meal-calories">{lunchItem.calories}</p>
                    </div>
                    ))}
                </div>
                <h2>Dinner</h2>
                <div>
                    {dinnerMeals.map((dinnerItem,index) => (
                    <div
                        key={index}
                        className="meal-card"
                    >
                        <h3>{dinnerItem.name}</h3>
                        <p className="meal-type">{dinnerItem.type}</p>
                        <p className="meal-calories">{dinnerItem.calories}</p>
                    </div>
                    ))}
                </div>
            </div>


            {expandedHomePopUp && (
                <HomePopUp
                    onClose={closeHomePopUp}
                />
            )}
        </div>
    )
}
export default Home
import { useState } from "react"
import '../App.css'

function Calendar()
{
    const [date, setDate] = useState("This week");
    function handleChange(event)
    {
        setDate(event.target.value);
    }

    const weekData =[
        {day:"Monday", info:"calories", details:"What you ate that day"},
        {day:"Tuesday", info:"calories", details:"What you ate that day"},
        {day:"Wednesday", info:"calories", details:"What you ate that day"},
        {day:"Thursday", info:"calories", details:"What you ate that day"},
        {day:"Friday", info:"calories", details:"What you ate that day"},
        {day:"Saturday", info:"calories", details:"What you ate that day"},
        {day:"Sunday", info:"calories", details:"What you ate that day"},
    ];
    const [expandedDay, setExpandedDay]=useState(null);


    return (
        <div>
            <h1>Calendar</h1>
            <label>Period of time:</label>

            <select value = {date} onChange={handleChange}> 
                <option value ="This week"> This week </option>
                <option value = "This month"> This month </option>
                <option value = "This year"> This year </option>
            </select>

            <div>
                {date=="This week" && (
                    <div style={{display: "flex", gap:"10px", marginTop:"20px", justifyContent:"center"}}>
                        {weekData.map((dayItem) => (
                        <div
                            key={dayItem.day}
                            onClick={() => setExpandedDay(dayItem)}
                            className="default-week-day"
                        >
                        
                        <h3>{dayItem.day}</h3>
                        <p>{dayItem.info}</p>

                    </div>
                ))}
            </div>
                
                )}
                {date=="This month" && <p>Showing data for this month</p>}
                {date=="This year" && <p>Showing data for this year</p>}
            </div>
             <div>
                    {expandedDay && (
                            <div className="pop-up-placement">
                                <div className="pop-up">
                                <h3>Day: {expandedDay.day}</h3>
                                    <p>Info: {expandedDay.info}</p>
                                    <p>Details:{expandedDay.details}</p>
                                    <button onClick={(e) =>{
                                        e.stopPropagation(); //if my close button overlaps with any day of the week
                                        //this prevents it from activing for example if my Close button is on top 
                                        //of monday when I click close monday pop up will not open
                                        //Basically prevents the click from travelling upwards
                                        setExpandedDay(null);
                                    }}>
                                        Close
                                    </button>
                                </div>
                            </div>
                        )}
                </div>
            

        </div>
    )
}
export default Calendar
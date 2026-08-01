import { useState } from "react"
import '../App.css'
import PopUp from "../components/Popup";

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

    const weekDays = ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"];
    

    const monthData = [];
    const today = new Date();
    const days = new Date(today.getFullYear(), today.getMonth()+1, 0).getDate()
    const firstDayOfTheMonth = (new Date(today.getFullYear(), today.getMonth(), 1).getDay()+6)%7
    const emptyCells = [];
    for(let i=0; i<firstDayOfTheMonth; i++)
    {
        emptyCells.push(null);
    }
    for(let i=0; i<days; i++)
    {
        monthData.push({
            day:i+1, 
            info:"calories",
            details:"What you ate at this day of the month",
        });
    }
    
    const [expandedDay, setExpandedDay]=useState(null);


    function ClosePopUp()
    {
        setExpandedDay(null);
    }

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
                    {date=="This month" && (
                        <div className="month-view">
                            <div className="weekdays">
                                {weekDays.map((weekDay) => (
                                    <h3 className="days-of-the-week" key = {weekDay}>{weekDay}</h3>
                            
                                ))}
                            </div>

                            <div className="calendar-overlay">
                                {emptyCells.map((emptySpace, index) => (
                                    <div 
                                        className="empty-cells"
                                        key={index}
                                    />
                                ))}
                                {monthData.map((monthItem) => (
                                    <div 
                                        className="default-month-day"
                                        key={monthItem.day}
                                        onClick={()=>setExpandedDay(monthItem)}
                                    >
                                    <h3>{monthItem.day}</h3>
                                    <p>{monthItem.info}</p>               
                            </div>
                        ))}
                        </div>
                    </div>
                )}
                {date=="This year" && <p>Showing data for this year</p>}

             
                {expandedDay && (
                    <PopUp 
                        selectedDay={expandedDay}
                        onClose={ClosePopUp}
                    />
                )}
            </div>
            

        </div>
    )
}

export default Calendar
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
        {title:"Monday", info:"calories", details:"What you ate that day"},
        {title:"Tuesday", info:"calories", details:"What you ate that day"},
        {title:"Wednesday", info:"calories", details:"What you ate that day"},
        {title:"Thursday", info:"calories", details:"What you ate that day"},
        {title:"Friday", info:"calories", details:"What you ate that day"},
        {title:"Saturday", info:"calories", details:"What you ate that day"},
        {title:"Sunday", info:"calories", details:"What you ate that day"},
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
            title:i+1, 
            info:"calories",
            details:"What you ate at this day of the month",
        });
    }

    const months = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"]
    const yearData = []
    for(let i=0; i<12; i++)
    {
        yearData.push({
            title: months[i],
            info:"calories",
            details:"Details about this month",
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
                    <div className="week-view">
                        {weekData.map((dayItem) => (
                        <div
                            key={dayItem.title}
                            onClick={() => setExpandedDay(dayItem)}
                            className="default-week-day"
                        >
                        
                        <h3>{dayItem.title}</h3>
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
                                        key={monthItem.title}
                                        onClick={()=>setExpandedDay(monthItem)}
                                    >
                                    <h3>{monthItem.title}</h3>
                                    <p>{monthItem.info}</p>               
                            </div>
                        ))}
                        </div>
                    </div>
                )}
                {date=="This year" && (
                    <div className="year-view">
                        {yearData.map((yearItem) => (
                            <div
                                className="default-year-day"
                                key={yearItem.title}
                                onClick={()=>setExpandedDay(yearItem)}
                            >
                            <h3>{yearItem.title}</h3>
                            <p>{yearItem.info}</p>
                            </div>
                        ))}
                    </div>
                )}

             
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
import { use, useState } from "react"

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
                    <div style={{display: "flex", gap:"10px", marginTop:"20px"}}>
                        {weekData.map((dayItem) => (
                        <div
                            key={dayItem.day}
                            onClick={() => setExpandedDay(dayItem.day)}
                            style = {{border: "1px solid black", padding: "10px"}}
                        >
                        
                        <h3>{dayItem.day}</h3>
                        <p>{dayItem.info}</p>

                        {expandedDay == dayItem.day && <p>Details: {dayItem.details}</p>}
                    </div>
                ))}
            </div>
                
                )}
                {date=="This month" && <p>Showing data for this month</p>}
                {date=="This year" && <p>Showing data for this year</p>}
            </div>

            

        </div>
    )
}
export default Calendar
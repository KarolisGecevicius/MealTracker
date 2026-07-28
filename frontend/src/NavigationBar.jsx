import { NavLink } from "react-router-dom";
import './App.css'

function NavigationBar()
{
    return (
        <nav>
            <NavLink to="/" className="nav-link">Home</NavLink>
            <NavLink to="/calendar" className="nav-link">Calendar</NavLink>
            <NavLink to="/statistics" className="nav-link">Statistics</NavLink>
        </nav>
    )
}
export default NavigationBar;
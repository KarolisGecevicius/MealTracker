import {BrowserRouter, Routes, Route, NavLink} from 'react-router-dom'
import './App.css'
import Home from "./pages/Home.jsx";
import Statistics from "./pages/Statistics.jsx";
import Calendar from "./pages/Calendar.jsx";
import Navigationbar from "./NavigationBar.jsx";


function App() {

  return (
    <BrowserRouter>
      <Navigationbar/>

      <Routes>
        <Route path='/' element={<Home />} />
        <Route path='/statistics' element = {<Statistics/>}/>
        <Route path='/calendar' element ={<Calendar/>}/>
      </Routes>
    </BrowserRouter>
  )
}

export default App

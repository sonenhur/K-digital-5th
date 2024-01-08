import './App.css';
import Home from './Component/Home';
import Login from './Component/Login';
import MainNav from './UI/MainNav';
import { BrowserRouter, Routes, Route } from 'react-router-dom';

function App() {
  return (
    <BrowserRouter>
      <div className="flex flex-col w-full max-w-screen-xl h-screen mx-auto bg-sky-200">
        <div className='items-center justify-center content-center '>
          <MainNav />
        </div>
        <div className='grow overflow-y-auto '>
          <Routes>
            <Route path='/' element={<Home />} />
            <Route path='/home' element={<Home />} />
            <Route path='/login' element={<Login />} />
          </Routes>
        </div>
      </div>
    </BrowserRouter>
  );
}

export default App;

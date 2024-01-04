import React from 'react';
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';
import './App.css';
import LogoMain from './01/LogoMain';
import ClockMain from './02/ClockMain';
import FrontEnd from './03/FrontEnd';
import Lotto from './05/Lotto';
// import BoxOffice from './06/BoxOffice';
// import Frcst from './07/Frcst';
// import RefTest from './08/RefTest';
// import Traffic from './09/Traffic';
// import Gallery from './10/Gallery';
// import Festival from './11/Festival' ;
// import Rmain from './12/Rmain';
// import Frcst from './13/Frcst';
// import FrcstMain from './13/FrcstMain';
import DivMain from './14/DivMain';
import DivRecoilMain from './15/DivRecoilMain';
// import Ex01 from './90/Ex01';

function App() {
    return (
        <BrowserRouter>
            <div>
                <nav className="flex items-center justify-between h-20 flex-wrap bg-green-400">
                    <Link to="/logo">LogoMain</Link>
                    <Link to="/clock">ClockMain</Link>
                    <Link to="/front">FrontEnd</Link>
                    <Link to="/lotto">Lotto</Link>
                    <Link to="/divmain">DivMain</Link>
                    <Link to="/recoilmain">Recoil</Link>
                </nav>
                <main className='grow'>
                    <Routes>
                        <Route path='/logo' element={<LogoMain />} />
                        <Route path='/clock' element={<ClockMain />} />
                        <Route path='/front' element={<FrontEnd />}/>
                        <Route path='/lotto' element={<Lotto />}/>
                        <Route path='/divmain' element={<DivMain />}/>
                        <Route path='/recoilmain' element={<DivRecoilMain />}/>
                    </Routes>
                    </main>
            </div>
        </BrowserRouter>
        // <LogoMain />    
        // <ClockMain />
        // <FrontEnd />  
        // <Lotto />
        // <BoxOffice />
        // <Frcst />
        // <RefTest />
        // <Traffic />
        // <Gallery />
        // <Festival />
        // <Rmain />
        // <Frcst />
        // <FrcstMain />
        // <Ex01 />
    );
}

export default App;
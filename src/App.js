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
            <div className='flex flex-col w-full max-w-screen-xl mx-auto h-screen'>
                <nav className="flex items-center justify-between flex-wrap bg-teal-700 p-6">
                    <div className="flex items-center flex-shrink-0 text-white mr-6">
                        <svg className="fill-current h-8 w-8 mr-2" width="54" height="54" viewBox="0 0 54 54" xmlns="http://www.w3.org/2000/svg"><path d="M13.5 22.1c1.8-7.2 6.3-10.8 13.5-10.8 10.8 0 12.15 8.1 17.55 9.45 3.6.9 6.75-.45 9.45-4.05-1.8 7.2-6.3 10.8-13.5 10.8-10.8 0-12.15-8.1-17.55-9.45-3.6-.9-6.75.45-9.45 4.05zM0 38.3c1.8-7.2 6.3-10.8 13.5-10.8 10.8 0 12.15 8.1 17.55 9.45 3.6.9 6.75-.45 9.45-4.05-1.8 7.2-6.3 10.8-13.5 10.8-10.8 0-12.15-8.1-17.55-9.45-3.6-.9-6.75.45-9.45 4.05z" /></svg>
                        <span className="font-semibold text-xl tracking-tight">K-Digital 5기</span>
                    </div>

                    <div className="w-full block flex-grow lg:flex lg:items-center lg:w-auto">
                        <div className="text-sm lg:flex-grow">
                            <Link to="/logo" className="block mt-4 lg:inline-block lg:mt-0 text-teal-200 hover:text-white mr-4"> LogoMain</Link>
                            <Link to="/clock" className="block mt-4 lg:inline-block lg:mt-0 text-teal-200 hover:text-white mr-4">ClockMain</Link>
                            <Link to="/front" className="block mt-4 lg:inline-block lg:mt-0 text-teal-200 hover:text-white mr-4">FrontEnd</Link>
                            <Link to="/lotto" className="block mt-4 lg:inline-block lg:mt-0 text-teal-200 hover:text-white mr-4">Lotto</Link>
                            <Link to="/divmain" className="block mt-4 lg:inline-block lg:mt-0 text-teal-200 hover:text-white mr-4">DivMain</Link>
                            <Link to="/recoilmain" className="block mt-4 lg:inline-block lg:mt-0 text-teal-200 hover:text-white mr-4">Recoil</Link>
                        </div>
                        <div>
                            {/* <a href="#" className="inline-block text-sm px-4 py-2 leading-none border rounded text-white border-white hover:border-transparent hover:text-teal-500 hover:bg-white mt-4 lg:mt-0">김경민</a> */}
                        </div>
                    </div>
                </nav>
                <main className='grow'>
                    <Routes>
                        <Route path='/logo' element={<LogoMain />} />
                        <Route path='/clock' element={<ClockMain />} />
                        <Route path='/front' element={<FrontEnd />} />
                        <Route path='/lotto' element={<Lotto />} />
                        <Route path='/divmain' element={<DivMain />} />
                        <Route path='/recoilmain' element={<DivRecoilMain />} />
                    </Routes>
                </main>
            </div>
        </BrowserRouter >
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
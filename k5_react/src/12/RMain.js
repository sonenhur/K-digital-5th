import { BrowserRouter, Route, Routes } from "react-router-dom"
import RHome from "./RHome"
import RNav from "./RNav"
import RPage1 from "./RPage1"
import RPage2 from "./RPage2"
export default function RMain() {
    return (
        <main className="container mx-auto">
            <BrowserRouter>
                <RNav />
                <Routes>
                    <Route path="/" element={<RHome />} />
                    <Route path="/Page1" element={<RPage1 />} />
                    <Route path="/Page2" element={<RPage2 />} />
                </Routes>
            </BrowserRouter>
        </main>
    )
}

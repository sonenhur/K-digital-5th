import { Link } from "react-router-dom"
export default function RNav() {
    return (
        <div><ul>
            <li><Link to='/'>Home</Link></li>
            <li><Link to='/page1'>Page1</Link></li>
            <li><Link to='/page2'>Page2</Link></li>
        </ul></div>
    )
}

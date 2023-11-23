import LogoImg from './LogoImg';
import LogoP from './LogoP';
import LogoA from './LogoA';

function LogoHeader() {
    return (
        <header className="App-header">
            <LogoImg />
            <LogoP msg={"부산대학교 "} />
            <LogoP msg={"K-Digital 5기"} />
            <LogoP msg={"허선행"} />
            <LogoA />
        </header>
    )
}
export default LogoHeader;
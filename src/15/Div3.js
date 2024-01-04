import TailButton from '../UI/TailButton';
import { useRecoilState } from 'recoil';
import { divn } from './DivAtoms';
export default function Div3() {
    const [n, setN] = useRecoilState(divn);
    const handleUp = () => {
        setN(n + 1);
    }
    const handleDown = () => {
        setN(n - 1);
    }
    return (
        <div className='w-4/6 h-4/6 rounded-xl bg-teal-800  flex flex-col justify-center items-center'>
            <div className='text-xl text-white'>Div3</div>
            <TailButton caption="증가" bcolor="lime" handleClick={handleUp} />
            <TailButton caption="감소" bcolor="lime" handleClick={handleDown} />
        </div>
    )
}

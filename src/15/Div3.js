import TailButton from '../UI/TailButton';
import { useRecoilState, useRecoilValue } from 'recoil';
import { divn, divn4 } from './DivAtoms';
export default function Div3() {
    const [n, setN] = useRecoilState(divn);
    const handleUp = () => {
        setN(n + 1);
    }
    const handleDown = () => {
        setN(n - 1);
    }
    const n4 = useRecoilValue(divn4)
    return (
        <div className='w-4/6 h-4/6 rounded-xl bg-teal-800  flex flex-col justify-center items-center'>
            <div className='text-xl text-white'>Div3={n4}</div>
            <TailButton caption="증가" bcolor="lime" handleClick={handleUp} />
            <TailButton caption="감소" bcolor="lime" handleClick={handleDown} />
        </div>
    )
}

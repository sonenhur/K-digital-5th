import Div3 from './Div3';
import { useRecoilValue } from 'recoil';
import { divn3 } from './DivAtoms';
export default function Div2() {
    const n3 = useRecoilValue(divn3)
    return (
        <div className='w-3/5 h-3/5 rounded-xl bg-teal-600  flex flex-col justify-center items-center'>
            <div className='text-xl text-white'>Div2={n3} </div>
            <Div3 />
        </div>
    )
}

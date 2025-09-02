import { useRecoilValue } from 'recoil';
import { divn } from "./DivAtoms";

import Div1 from './Div1';

export default function DivMain() {
    const n = useRecoilValue(divn)

    return (
        <div className='w-full h-screen flex justify-center items-center flex-col bg-teal-300'>
            <div className='text-xl text-white'>
                RecoilMain n={n}
            </div>
            <Div1 />
        </div>

    )
}

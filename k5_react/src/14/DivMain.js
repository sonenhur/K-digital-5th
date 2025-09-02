import { useEffect, useState } from 'react';
import Div1 from './Div1';

export default function DivMain() {
    const [n, setN] = useState(0);

    const [n2, setN2] = useState(0);
    useEffect(() => {
        setN2(n * 2);
    }, [n])

    return (
        <div className='w-full h-screen flex justify-center items-center flex-col bg-teal-300'>
            <div className='text-xl text-white'>
                DivMain n={n}, n2={n2}
            </div>
            <Div1 n={n} setN={setN} />
        </div>

    )
}

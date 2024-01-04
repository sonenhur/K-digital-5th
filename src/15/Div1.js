import Div2 from './Div2';
export default function Div1() {
    return (
        <div className='w-3/5 h-3/5 rounded-xl bg-teal-400  flex flex-col justify-center items-center'>
            <div className='text-xl text-white'>Div1</div>
            <Div2 />
        </div>
    )
}

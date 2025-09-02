import Div3 from './Div3';
export default function Div2({ n, setN }) {
    return (
        <div className='w-3/5 h-3/5 rounded-xl bg-teal-600  flex flex-col justify-center items-center'>
            <div className='text-xl text-white'>Div2</div>
            <Div3 n={n} setN={setN} />
        </div>
    )
}

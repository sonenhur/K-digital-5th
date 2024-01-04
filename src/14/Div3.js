import TailButton from '../UI/TailButton';

export default function Div3({ n, setN }) {
    const handleUp = () => {
        setN(n + 1);
    }

    return (
        <div className='w-4/6 h-4/6 rounded-xl bg-teal-800  flex flex-col justify-center items-center'>
            <div className='text-xl text-white'>Div3</div>
            <TailButton caption="증가" bcolor="lime" handleClick={handleUp} />
        </div>
    )
}

import TailButton from '../UI/TailButton';

export default function TrafficNav({ title, carr, sel, setSel }) {
    const handleBtClick = (item) => {
        setSel(item);
    };

    const tags = carr.map((item, idx) => (
        <TailButton
            caption={item}
            key={`bt${idx}`}
            bcolor={item === sel ? 'orange' : 'lime'}
            handleClick={() => handleBtClick(item)}
        />
    ));

    return (
        <div className='flex w-full bg-gray-100 shadow-md rounded-md p-4'>
            <div className='flex justify-center items-center text-xl w-1/6 text-gray-800'>
                {title}
            </div>
            <div className='flex justify-end items-center w-5/6 space-x-4'>
                {tags}
            </div>
        </div>
    );
}

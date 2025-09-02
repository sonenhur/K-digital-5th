export default function TailButton({ caption, bcolor, handleClick }) {
    const tailColor = {
        sky: 'hover:bg-blue-500 hover:text-white bg-blue-600',
        orange: 'hover:bg-orange-400 hover:text-orange-800 bg-orange-500',
        lime: 'hover:bg-lime-400 hover:text-lime-800 bg-lime-600',
        teal: 'bg-teal-600 hover:bg-teal-700 text-white',
        transparent: 'border-transparent border-4 text-teal-500 hover:text-teal-800',
    };

    return (
        <button
            className={`flex-shrink-0 py-2 px-4 rounded-md m-1
                        ${tailColor[bcolor]}
                        font-medium text-white focus:outline-none focus:ring focus:border-blue-300`}
            onClick={handleClick}
        >
            {caption}
        </button>
    );
}

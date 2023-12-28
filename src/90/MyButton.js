export default function MyButton({ caption, bcolor, handleOnClick }) {
    const bcolorlt = {
        'purpletoblue': 'from-purple-600 to-blue-500',
        'purpletopink': 'from-purple-500 to-pink-500',
        'pinktoorange': 'from-pink-500 to-orange-400',
    }
    return (
        <div>
            <button className={
                `text-white bg-gradient-to-br
                 ${bcolorlt[bcolor]} 
                 hover:bg-gradient-to-bl
                focus:ring-4 focus:outline-none focus:ring-blue-300 dark:focus:ring-blue-800
                font-medium rounded-lg text-sm px-5 py-2.5 text-center me-2 mb-2    `}
                onClick={handleOnClick}>
                {caption}
            </button>
        </div>
    )
}

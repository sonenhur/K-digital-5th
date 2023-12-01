export default function TailButton({ caption, handleClick }) {
    return (
        <button className="inline-flex justify-center items-center overflow-auto p-5 m-5 rounded-lg
        bg-green-500
        hover:bg-white hover:text-green-500" onClick={handleClick}>
            {caption}
        </button>

    )
}

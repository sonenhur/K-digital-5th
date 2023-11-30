export default function TailBlueButton({ caption, onClick }) {
    return (
        <button
            className="inline-flex justify-center items-center p-5 h-10 rounded-md m-1 bg-blue-600 text-white hover:bg-blue-900"
            onClick={onClick}
        >
            {caption}
        </button>
    )
}

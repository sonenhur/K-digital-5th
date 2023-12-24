export default function TailSelect({ opItem, handleChange }) {
    const ops = opItem.map((item, idx) =>
        <option key={`op${idx}`} value={item}>{item}</option>
    );

    return (
        <select onChange={handleChange}
            className='bg-gray-50 border border-gray-300 text-gray-900'>
            <option value=''>--선택--</option>
            {ops}
        </select>
    )
}

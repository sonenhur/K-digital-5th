export default function TailSelect({ opItem, handleChange }) {
    const ops = opItem.map((item, idx) =>
        <option key={`op${idx}`} value={item}>{item}</option>
    );

    return (
        <select
            onChange={handleChange}
            className="appearance-none border rounded-md py-2 px-4 bg-white text-gray-700 leading-tight focus:outline-none focus:border-teal-500">
            <option value="">-- 선택 --</option>
            {ops}
        </select>
    );
}

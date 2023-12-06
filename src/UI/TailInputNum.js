export default function TailInputNum({ id, name, rf, isOnly }) {
    return (
        <input
            type="number"
            id={id}
            name={name}
            ref={rf}
            readOnly={isOnly}
            className="bg-gray-50 border-gray-300"
        />
    );
}

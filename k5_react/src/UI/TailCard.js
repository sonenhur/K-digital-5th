export default function TailCard({ imgSrc, title, subtitle, tags }) {
    let sps = tags.split(',');
    sps = sps.map((item, idx) =>
        <span key={`sp${idx}`} className="inline-block bg-teal-600 rounded-full px-3 py-1 text-white text-sm font-medium mr-2 mb-2">
            {item}
        </span>
    )

    sps = sps.length === 0 ? '' : sps

    return (
        <div className="max-w-lg overflow-hidden shadow-lg bg-teal-200 rounded-3xl text-teal-600">
            <img className="w-full" src={imgSrc} alt={title} />
            <div className="px-6 py-4">
                <div className="font-bold text-xl mb-2">
                    {title}
                </div>
                <p className="font-medium text-teal-600">
                    {subtitle}
                </p>
                <div className="mt-4">
                    {sps}
                </div>
            </div>
        </div>
    );
}
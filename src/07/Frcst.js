import { useEffect, useState } from "react";
import TailH1 from "../UI/TailH1";
import TailBlueButton from "../UI/TailBlueButton";
import data from "./dataFrcst.json";

export default function Frcst() {
    const [dtTags, setDtTags] = useState();
    const dtKey = ["frcstOneDt", "frcstTwoDt", "frcstThreeDt", "frcstFourDt"];
    const cnKey = ["frcstOneCn", "frcstTwoCn", "frcstThreeCn", "frcstFourCn"];

    let dtcn = {}
    for (let i = 0; i < dtKey.length; i++) {
        dtcn[data[dtKey[i]]] = data[cnKey[i]]
    }

    const handleClick = (dt) => {
        console.log(dt, dtcn[dt])
    }
    useEffect(() => {
        setDtTags(
            dtKey.map((k, idx) =>
                <TailBlueButton key={`dt${idx}`} caption={data[k]} onClick={() => handleClick(data[k])} />
            )
        );
    }, []);
    return (
        <div className="container mx-auto h-screen">
            <div className="flex justify-center items-center h-1/6 bg-blue-200">
                <TailH1 title={"초미세먼지 주간예보"} />
            </div>
            <div className="grow flex flex-col justify-center items-center">
                <div className="flex justify-center items-center p-5">
                    {dtTags}
                </div>
            </div>
        </div>
    )
}
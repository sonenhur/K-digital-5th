import React, { useEffect, useState, useRef } from 'react';
import TailH1 from '../UI/TailH1';
import TailSelect from '../UI/TailSelect';
import TailButton from '../UI/TailButton';
import TailCard from '../UI/TailCard';
import { FcLandscape, FcNightLandscape } from "react-icons/fc";

export default function Festival() {
    const selRef = useRef();
    const [tdata, setTdata] = useState([]);
    const [gu, setGu] = useState([]);
    const [ops, setOps] = useState([]);
    const [selectedValue, setSelectedValue] = useState('');
    const [tmData, setTmData] = useState([]); // Add this line to define the mapped data

    let apikey = process.env.REACT_APP_APIKEY;

    const getData = async () => {
        let url = `https://apis.data.go.kr/6260000/FestivalService/getFestivalKr`;
        url = `${url}?serviceKey=${apikey}`
        url = `${url}&pageNo=1`;
        url = `${url}&numOfRows=40`;
        url = `${url}&resultType=json`;

        const resp = await fetch(url);
        const data = await resp.json();
        setTdata(data.getFestivalKr.item);
        console.log(data.getFestivalKr.item);
    }

    const handleChange = (e) => {
        console.log(e.target.value);
        setSelectedValue(e.target.value);
        let tm = tdata.filter(item => item.GUGUN_NM === e.target.value);
        setTmData(tm); // Set the state for the mapped data
        console.log(tm);
    }

    useEffect(() => {
        getData();
    }, []);

    useEffect(() => {
        let tm = tdata.map((item) => item.GUGUN_NM);
        tm = [...new Set(tm)].sort();
        setGu(tm);
    }, [tdata]);

    useEffect(() => {
        let tm = gu.map((item, idx) => <option key={`op${idx}`} value={item}>{item}</option>);
        setOps(tm);
    }, [gu]);

    useEffect(() => {
        let tm = tmData.map((item, idx) => (
            <TailCard key={`tc${idx}`}
                imgSrc={item.MAIN_IMG_THUMB}
                title={item.TITLE}
                subtitle={item.TRFC_INFO}
                tags={item.USAGE_DAY_WEEK_AND_TIME}
            />
        ));
        // Use 'tm' as needed
    }, [tmData]);

    return (
        <div className="container mx-auto h-screen">
            <div className="flex flex-col items-center w-full my-8">
                <div className="flex items-center">
                    <FcLandscape className="text-5xl mx-4" />
                    <TailH1 title={'부산지역 축제정보'} />
                    <FcNightLandscape className="text-5xl mx-4" />
                    <form name="kform" className="mt-10 my-8 w-4/5 flex justify-center items-center">
                        <select ref={selRef} onChange={handleChange}>
                            <option value=''>--선택--</option>
                            {ops}
                        </select>
                    </form>
                </div>
                <div>
                    {selectedValue && <p>Selected Value: {selectedValue}</p>}
                </div>
                <div className="grid grid-cols-1 gap-4 md:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4">
                    {selData}
                </div>
            </div>
        </div>
    )
}

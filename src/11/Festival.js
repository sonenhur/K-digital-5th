import React, { useEffect, useState, useRef } from 'react';
import TailH1 from '../UI/TailH1';
import TailCard from '../UI/TailCard';
import { GiPartyPopper } from "react-icons/gi";
import TailSelect from '../UI/TailSelect';

export default function Festival() {
    const kwInput = useRef();
    const [tdata, setTdata] = useState([]);
    const [gu, setGu] = useState([]);
    const [tags, setTags] = useState([]);
    const [seldata, setSelData] = useState([]);

    let apikey = process.env.REACT_APP_APIKEY;

    const handleChange = (e) => {
        let tm = tdata.filter(item => item.GUGUN_NM === e.target.value);
        setSelData(tm);
    }

    const handleGetData = async () => {
        let url = `https://apis.data.go.kr/6260000/FestivalService/getFestivalKr?`;
        url = `${url}serviceKey=${apikey}`;
        url = `${url}&pageNo=1`;
        url = `${url}&numOfRows=40`;
        url = `${url}&resultType=json`;

        const resp = await fetch(url);
        const data = await resp.json();

        setTdata(data.getFestivalKr.item);
    }

    useEffect(() => {
        handleGetData();
    }, []);

    useEffect(() => {
        let tm = tdata.map((item) => item.GUGUN_NM);
        tm = [...new Set(tm)].sort();
        setGu(tm);
    }, [tdata]);

    useEffect(() => {
        let tm = seldata.map((item, idx) => (
            <TailCard
                key={`tc${idx}`}
                imgSrc={item.MAIN_IMG_THUMB}
                title={item.MAIN_TITLE}
                subtitle={item.SUBTITLE}
                tags={item.USAGE_DAY_WEEK_AND_TIME}
            />
        ));
        setTags(tm);
    }, [seldata]);

    return (
        <div className="container mx-auto w-full min-h-screen p-8 bg-gray-100">
            <div className="flex flex-col items-center my-8">
                <div className="flex items-center">
                    <TailH1 title={'부산광역시 축제정보'} />
                    <GiPartyPopper className="text-4xl mx-5 text-teal-600" />
                </div>
                <form className="my-8 w-4/5 flex justify-around items-center">
                    <TailSelect opItem={gu} handleChange={handleChange} />
                </form>
                <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4">
                    {tags}
                </div>
            </div>
        </div>
    );
}
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
        console.log(e.target.value);
        let tm = tdata.filter(item => item.GUGUN_NM === e.target.value);
        console.log(tm);
        setSelData(tm);
    }

    const handleGetData = async () => {
        let url = `https://apis.data.go.kr/6260000/FestivalService/getFestivalKr?`;
        url = `${url}serviceKey=${apikey}`;
        url = `${url}&pageNo=1`;
        url = `${url}&numOfRows=40`;
        url = `${url}&resultType=json`;

        console.log(url);

        const resp = await fetch(url);
        const data = await resp.json();

        console.log(data);
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
        let tm = seldata.map((item, idx) =>
            <TailCard key={`tc${idx}`}
                imgSrc={item.MAIN_IMG_THUMB}
                title={item.MAIN_TITLE}
                subtitle={item.SUBTITLE}
                tags={item.USAGE_DAY_WEEK_AND_TIME}
            />
        );
        setTags(tm);
    }, [seldata]);

    return (
        <div className="container mx-auto w-full h-screen">
            <div className="flex flex-col justify-top items-center w-full my-8">
                <div className='flex'>
                    <TailH1 title={'부산광역시 축제정보'} />
                    <GiPartyPopper className='text-4xl mx-5' />
                </div>
                <form name="kform" className="my-8 w-4/5 flex justify-center items-center">
                    <div className="block text-sm font-medium leading-6 text-gray-900">
                        <div className="relative mt-2 rounded-md shadow-sm">
                            <div className="pointer-events-none absolute inset-y-0 left-0 flex items-center pl-3">
                                <span className="text-gray-500 sm:text-sm"></span>
                            </div>
                            <input type="text" name="local" id="local" className="block w-full rounded-md border-0 py-1.5 pl-7 pr-20 text-gray-900 ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6" placeholder="입력 또는 선택" />
                            <div className="absolute inset-y-0 right-0 flex items-center">
                                <TailSelect opItem={gu} handleChange={handleChange} />
                            </div>
                        </div>
                    </div>
                </form>
            </div>
            <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4">
                {tags}
            </div>
        </div>
    )
}

import { useEffect, useState } from 'react';
import { GiPartyPopper } from "react-icons/gi";
import TailCard from '../UI/TailCard';
import TailH1 from '../UI/TailH1';
import TailSelect from '../UI/TailSelect';

export default function Festival() {
    const [tdata, setTdata] = useState([]);   // 축제 데이터를 저장
    const [gu, setGu] = useState([]);         // 구 이름을 저장
    const [seldata, setSelData] = useState([]);  // 선택된 구의 축제 데이터를 저장
    const [tags, setTags] = useState([]);     // 선택된 구의 축제 데이터를 표시

    let apikey = process.env.REACT_APP_APIKEY;

    // 구 선택 시 호출
    const handleChange = (e) => {
        let selectedGu = e.target.value;
        console.log("선택된 구:", selectedGu);

        let tm = tdata.filter(item => item.GUGUN_NM === selectedGu);
        setSelData(tm);
    }

    // 처음 실행될때 축제 데이터를 가져옴
    useEffect(() => {
        console.log("축제 데이터 가져오는 중...");
        handleGetData();
    }, []);

    // 축제 데이터를 가져오는 함수
    const handleGetData = async () => {
        let url = `https://apis.data.go.kr/6260000/FestivalService/getFestivalKr?`;
        url = `${url}serviceKey=${apikey}`;
        url = `${url}&pageNo=1`;
        url = `${url}&numOfRows=40`;
        url = `${url}&resultType=json`;

        const resp = await fetch(url);
        const data = await resp.json();

        setTdata(data.getFestivalKr.item);
        console.log("축제 데이터 가져오기 완료:", data.getFestivalKr.item);
    }

    // 축제 데이터가 업데이트되면 구 이름을 추출하여 중복을 제거하고 정렬
    useEffect(() => {
        // 축제 데이터에서 구 이름만 추출
        let guNames = tdata.map((item) => item.GUGUN_NM);
        // 중복된 이름 제거하고 정렬
        let uniqueGuNames = [...new Set(guNames)].sort();
        // 구 state 업데이트
        setGu(uniqueGuNames);
        console.log("업데이트된 구 이름:", uniqueGuNames);
    }, [tdata]);

    // 선택한 구의 축제 데이터가 업데이트되면 TailCard 컴포넌트를 생성해서 화면에 표시
    useEffect(() => {
        // 선택된 구의 축제 데이터를 사용해서 TailCard 컴포넌트 생성
        let tm = seldata.map((item, idx) => (
            <TailCard
                key={`tc${idx}`}
                imgSrc={item.MAIN_IMG_THUMB}
                title={item.MAIN_TITLE}
                subtitle={item.SUBTITLE}
                tags={item.USAGE_DAY_WEEK_AND_TIME}
            />
        ));

        // 화면에 표시할 TailCard 업데이트
        setTags(tm);
        console.log("업데이트된 태그:", tm);
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
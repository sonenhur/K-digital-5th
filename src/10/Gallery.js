import React, { useEffect, useRef, useState } from 'react';
import TailH1 from '../UI/TailH1';
import TailButton from '../UI/TailButton';
import TailCard from '../UI/TailCard';
import { FcLandscape } from "react-icons/fc";
import { FcNightLandscape } from "react-icons/fc";

export default function Gallery() {
    // const [tdata, setTdata] = useState();
    // 환경변수값 가져오기
    let apikey = process.env.REACT_APP_APIKEY;

    //fetch 데이터 저장
    const [tdata, setTdata] = useState();

    //키워드 입력
    const kwInput = useRef();

    const handleGetData = async (e) => {
        if (e.key !== "Enter") e.preventDefault();
        //키워드 인코딩
        let enkw = encodeURI(kwInput.current.value);
        if (enkw === '') {
            alert('키워드를 입력하세요')
            kwInput.current.focus();
            return;
        }
        let url = `https://apis.data.go.kr/B551011/PhotoGalleryService1/gallerySearchList1?`
        url = url + `serviceKey=${apikey}`
        url = url + `&numOfRows=10&pageNo=1&MobileOS=ETC&MobileApp=AppTest&arrange=A`
        url = url + `&keyword=${enkw}`
        url = url + `&_type=json`;


        const resp = await fetch(url);
        const data = await resp.json();

        setTdata(data.response.body.items.item);
    };

    const handleResetData = (e) => {
        e.preventDefault();
        kwInput.current.value = '';
    };

    // tdata변경시
    useEffect(() => {
        console.log("tdata = ", tdata)

    }, [tdata])

    return (
        <div className="container mx-auto h-screen">
            <div className="flex flex-col items-center w-full my-8">
                <div className="flex items-center">
                    <FcLandscape className="text-5xl mx-4" />
                    <TailH1 title={'한국관광공사 사진정보'} />
                    <FcNightLandscape className="text-5xl mx-4" />
                </div>
                <form name="kform" className="mt-10 my-8 w-4/5 flex justify-center items-center">
                    <div className="w-fit flex items-center border-b border-teal-500">
                        <input
                            ref={kwInput}
                            className="appearance-none bg-transparent border-none w-full text-gray-700 mr-3 py-1 px-2 leading-tight focus:outline-none"
                            type="text"
                            placeholder="키워드 입력"
                        />
                        <TailButton caption='확인' bcolor='teal' handleClick={(e) => handleGetData(e)} />
                        <TailButton caption='취소' bcolor='transparent' handleClick={(e) => handleResetData(e)} />
                    </div>
                </form>
            </div>
            <div className="flex justify-center items-center">
                <TailCard
                    imgSrc={"https://tong.visitkorea.or.kr/cms2/website/61/2952361.jpg"}
                    title={"광안리해수욕장"}
                    subtitle={"부산광역시 수영구 광안동"}
                    tags={"광안리해수욕장, 부산광역시 수영구, 광안리해변, 바닷가, 바다, 부산 광안대교, 다이아몬드 브릿지, 별바다부산, 부산야간관광"}
                />
            </div>
        </div>
    );
}

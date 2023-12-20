import React, { useEffect, useRef, useState } from 'react';
import TailH1 from '../UI/TailH1';
import TailButton from '../UI/TailButton';
import TailCard from '../UI/TailCard';
import { FcLandscape, FcNightLandscape } from "react-icons/fc";

const apikey = process.env.REACT_APP_APIKEY;

export default function Gallery() {
    // 키워드 입력
    const kwInput = useRef();

    // 태그 상태 변수 정의와 초기화
    const [tags, setTags] = useState([]);

    // tdata 상태 변수 정의와 초기화
    const [tdata, setTData] = useState([]);

    // 키워드 입력 이벤트 처리
    const handleGetData = async (e) => {
        if (e.key !== "Enter") e.preventDefault();
        // 키워드 인코딩
        let enkw = encodeURI(kwInput.current.value);
        if (enkw === '') {
            alert('키워드를 입력하세요');
            kwInput.current.focus();
            return;
        }

        let url = `https://apis.data.go.kr/B551011/PhotoGalleryService1/gallerySearchList1?`;
        url = `${url}serviceKey=${apikey}`
        url = `${url}&numOfRows=10`;
        url = `${url}&pageNo=1`;
        url = `${url}&MobileOS=ETC`;
        url = `${url}&MobileApp=AppTest`;
        url = `${url}&arrange=A`;
        url = `${url}&keyword=${enkw}`;
        url = `${url}&_type=json`;

        try {
            const resp = await fetch(url);
            const data = await resp.json();

            if (data.response && data.response.body && data.response.body.items && data.response.body.items.item) {
                setTData(data.response.body.items.item);
            } else {
                alert('데이터를 불러오는데 문제가 발생했습니다.');
            }
        } catch (error) {
            console.error('Error fetching data:', error);
        }
    }

    // 데이터 초기화 이벤트 처리
    const handleResetData = (e) => {
        e.preventDefault();
        kwInput.current.value = '';
        setTags([]); // 입력값 초기화 시 태그도 초기화
    };

    useEffect(() => {
        // tdata를 사용하여 태그 업데이트 로직 추가
        let tm = tdata.map((item, idx) => (
            <TailCard
                key={`card${idx}`}
                imgSrc={item.galWebImageUrl.replace('http://', 'https://')}
                title={item.galTitle}
                subtitle={item.galPhotographyLocation}
                tags={item.galSearchKeyword}
            />
        ));

        // 태그 업데이트
        setTags(tm);
    }, [tdata]);

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
                            type="text"
                            ref={kwInput}
                            className="appearance-none bg-transparent border-none w-full text-gray-700 mr-3 py-1 px-2 leading-tight focus:outline-none"
                            placeholder="키워드 입력"
                            required
                        />
                        <TailButton caption='확 인' bcolor='teal' handleClick={(e) => handleGetData(e)} />
                        <TailButton caption='취 소' bcolor='transparent' handleClick={(e) => handleResetData(e)} />
                    </div>
                </form>
            </div>
            <div className="grid grid-cols-1 gap-4 md:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4">
                {tags}
            </div>
        </div>
    );
}

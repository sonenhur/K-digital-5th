import React, { useState, useEffect } from 'react';
import TailH1 from '../UI/TailH1';
import TrafficNav from './TrafficNav';


export default function Traffic() {
    // 상태변수
    const [tdata, setTdata] = useState([]); // 전체 데이터
    const [c1, setC1] = useState([]);       // 대분류
    const [c2, setC2] = useState([]);       // 중분류
    const [selC1, setSelC1] = useState();   // 선택된 대분류
    const [selC2, setSelC2] = useState();   // 선택된 중분류
    const [detail, setDetail] = useState(); // 상세 정보

    // 데이터 불러오기
    const getData = async () => {
        try {
            // 환경변수값 가져오기
            let apikey = process.env.REACT_APP_APIKEY;

            let url = `https://api.odcloud.kr/api/15070282/v1/uddi:00e5cb5a-ecdf-4190-a499-ba3a6b2a8db9?`
            url = url + `page=1&perPage=20&returnType=JSON`
            url = url + `&serviceKey=${apikey}`;

            const resp = await fetch(url);
            const data = await resp.json();

            setTdata(data.data);
        } catch (error) {
            console.error('Error fetching data:', error);
        }
    };

    // 컴포넌트 시작시 한번 실행
    useEffect(() => {
        getData();
    }, []);

    // 상태변수가 변경되었을때 실행
    useEffect(() => {
        if (tdata === undefined) return;
        console.log(tdata);

        // 대분류 생성
        // 1. tdata를 순회하면서 대분류 자료만 추출
        let tm = tdata.map(item => item['사고유형_대분류']);
        console.log(tm);

        // 2. 중복제거
        tm = new Set(tm);

        // 3. set => array 변경
        tm = [...tm];

        // 4. state변수에 저장
        setC1(tm);
    }, [tdata]);

    useEffect(() => {
        if (tdata === undefined) return;
        console.log("selC1 = ", selC1);

        // 중분류 만들기
        let tm = tdata.filter((item) => item.사고유형_대분류 === selC1).map((item) => item.사고유형_중분류);
        console.log("c2 = ", c2);
        setC2(tm);
        setSelC2('');
        setDetail('');
    }, [selC1])

    useEffect(() => {
        if (tdata === undefined) return;

        // 상세정보 출력하기
        let tm = tdata.filter((item) => item.사고유형_대분류 === selC1
            && item.사고유형_중분류 === selC2);
        tm = tm[0];
        console.log(tm)
    }, [selC2])

    return (
        <div className='container mx-auto h-screen'>
            <div className='flex flex-col justify-normal items-center w-full h-full my-8'>
                <TailH1 title={'도로교통공단_사고유형별 교통사고 통계'} />
                <div className='w-5/6 my-10'>
                    {c1 && <TrafficNav title={'대분류'} carr={c1} sel={selC1} setSel={setSelC1} />}
                    {c2 && <TrafficNav title={'중분류'} carr={c2} sel={selC2} setSel={setSelC2} />}
                </div>
            </div>
        </div>
    );
}

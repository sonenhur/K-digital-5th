import { useEffect, useState } from "react";
import TailH1 from "../UI/TailH1";
import TailButton from "../UI/TailButton";

export default function Frcst() {
    // 상태 변수
    const [dataF, setDataF] = useState(null); // API로부터 받아온 데이터 저장
    const [dtTags, setDtTags] = useState([]); // 날짜 버튼 태그 저장
    const [cnTags, setCnTags] = useState([]); // 클릭한 날짜에 해당하는 내용물 태그 저장

    // 키 배열
    const dtKey = ["frcstOneDt", "frcstTwoDt", "frcstThreeDt", "frcstFourDt"]; // 날짜 키 배열
    const cnKey = ["frcstOneCn", "frcstTwoCn", "frcstThreeCn", "frcstFourCn"]; // 내용물 키 배열

    // API로 데이터를 가져오는 사용자 정의 함수
    const getData = () => {
        //fetch 주소
        let url =
            "https://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMinuDustWeekFrcstDspth?";
        url = url + `serviceKey=${process.env.REACT_APP_APIKEY}`;
        url = url + `&returnType=json&numOfRows=100&pageNo=1`;
        url = url + `&searchDate=2023-11-30`;

        // .then에 지정된 순서대로 실행 (이전 작업이 완료된 후에 다음 작업이 실행됨)
        fetch(url)
            .then((resp) => resp.json())
            .then((data) => {
                setDataF(data.response.body.items[0]); // 받아온 데이터를 상태 변수에 저장
                console.log("가져온 데이터:", data); // 가져온 데이터를 콘솔에 출력
            })
            .catch((err) => console.log(err));
    };

    // 날짜를 선택했을 때 실행되는 사용자 정의 함수
    const handleDtClick = (idx) => {
        const cnContent = dataF[cnKey[idx]]?.split(",") || []; // 클릭한 날짜에 해당하는 내용물을 콤마로 나누어 배열로 저장
        setCnTags(cnContent); // 배열로 저장된 내용물을 상태 변수에 저장
        console.log("클릭한 항목:", cnContent); // 클릭한 내용물을 콘솔에 출력
    };

    // 컴포넌트가 생성될 때 처음 한 번 실행
    useEffect(() => {
        // API 키 확인
        // console.log(process.env.REACT_APP_APIKEY);
        // fetch 해오는 사용자 정의 함수 호출
        getData();
    }, []);

    // state 변수 dataF가 변경되었을 때 실행
    useEffect(() => {
        if (!dataF) return; // 데이터가 없으면 아무 작업도 하지 않음

        // 날짜 버튼 태그를 생성하여 상태 변수에 저장
        const tm = dtKey.map((k, idx) => (
            <TailButton
                key={`dt${idx}`}
                caption={dataF[k]}
                handleClick={() => handleDtClick(idx)}
            />
        ));

        setDtTags(tm); // 날짜 버튼 태그를 상태 변수에 저장
    }, [dataF]);

    return (
        <div className="flex flex-col w-full max-w-screen-xl mx-auto h-screen overflow-y-auto font-bold">
            <div className="flex justify-center items-center bg-green-500 h-20">
                <TailH1 title={"초미세먼지예보"} className="text-white" />
            </div>
            <div className="grow flex flex-col justify-top items-center bg-rose-300">
                <div>
                    {dtTags}
                </div>
                <div className="grid grid-rows-4 grid-flow-col gap-4 text-center">
                    {cnTags.map((content, idx) => (
                        <div className="mx-2 bg-green-400">
                            <div key={`cn${idx}`} className="grid grid-rows-2 grid-flow-col gap">
                                {content}
                            </div>
                        </div>
                    ))}
                </div>
            </div>
        </div>
    );
}
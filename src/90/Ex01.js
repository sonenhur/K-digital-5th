import MyButton from "./MyButton";
import { useState, useEffect, useRef } from "react";
export default function Ex01() {

    const arr = ['안녕하세요', '반갑습니다', '추워요'];
    //배열의 갯수만큼 버튼을 만들려고 함 (map: 하나씩 돌면서 순회)
    // const tagArr = arr.map(()=>{return}); //{return}만 있을때는 생략 가능
    // const tagArr = arr.map((item) => {
    //     return <button>{item}</button>
    // });
    const arrColor = ['purpletoblue', 'purpletopink', 'pinktoorange']
    const tagArr = arr.map((item, idx) =>
        <MyButton key={`mb${idx}`}
            caption={item}
            bcolor={arrColor[idx]}
            handleOnClick={() => handleClick(item)} />
    );

    // const handleClick = ()=>{
    //     alert("안녕하세요");
    // }
    // const handleClick2 = ()=>{
    //     alert("반갑습니다");
    // }
    // const handleClick3 = ()=>{
    //     alert("추워요");
    // }
    //      ↑ 패턴을 발견해서 단축 ↓
    // const handleClick = (msg) => {
    //    tagMsg = msg;
    //    console.log("tagMsg", tagMsg)     //로그에는 찍히는데 화면은 갱신 안됨.
    //                                      // 그래서 state, useState 가 필요함 (바뀌면 다시 그려낸다)
    // }
    // let tagMsg = '안녕하세요';
    const inRef = useRef();

    const handleClick = (msg) => {
         // setTagMsg(`${inRef.current.value}님 ${msg}`)

        inRef.current.value === ''? setTagMsg(msg) : setTagMsg(`${inRef.current.value}님 ${msg}`)
        //삼항연산 A === '' ? B : C (A가 ''이면 B, 아니면 C)
    }
    const [tagMsg, setTagMsg] = useState(arr[0]);

    useEffect(() => {
        console.log(tagMsg)
    }, [tagMsg]);


    return (
        <div className="container mx-auto px-4">
            <h1 className="text-gray-900 bg-gradient-to-r from-teal-200 to-lime-200 hover:bg-gradient-to-l hover:from-teal-200 hover:to-lime-200
            focus:ring-4 focus:outline-none focus:ring-lime-200 dark:focus:ring-teal-700
            font-medium rounded-lg text-xl px-5 py-2.5 text-center me-2 mb-2
            flex justify-center items-center">
                리액트
            </h1>
            {/* <button onClick={handleClick}>안녕하세요</button>
            <button onClick={handleClick2}>반갑습니다</button>
            <button onClick={handleClick3}>추워요</button> */}
            {/*     ↑ 패턴을 발견해서 단축 ↓       */}
            {/* <button onClick={() => handleClick(arr[0])}>arr[0]</button>
            <button onClick={() => handleClick(arr[1])}>arr[1]</button>
            <button onClick={() => handleClick(arr[2])}>arr[2]</button> */}
            {/*     본문에 변수를 쓰고싶을때는 중괄호로 감싸기   */}
            {/* <div className="flex justify-center items-center w-full">
                <button className="text-white bg-gradient-to-br from-purple-600 to-blue-500 hover:bg-gradient-to-bl
                focus:ring-4 focus:outline-none focus:ring-blue-300 dark:focus:ring-blue-800
                font-medium rounded-lg text-sm px-5 py-2.5 text-center me-2 mb-2"
                    onClick={() => handleClick(arr[0])}>
                    {arr[0]}
                </button>
                <button className="text-white bg-gradient-to-r from-purple-500 to-pink-500 hover:bg-gradient-to-l
                focus:ring-4 focus:outline-none focus:ring-purple-200 dark:focus:ring-purple-800
                font-medium rounded-lg text-sm px-5 py-2.5 text-center me-2 mb-2"
                    onClick={() => handleClick(arr[1])}>
                    {arr[1]}
                </button>
                <button className="text-white bg-gradient-to-br from-pink-500 to-orange-400 hover:bg-gradient-to-bl
                focus:ring-4 focus:outline-none focus:ring-pink-200 dark:focus:ring-pink-800
                font-medium rounded-lg text-sm px-5 py-2.5 text-center me-2 mb-2"
                    onClick={() => handleClick(arr[2])}>
                    {arr[2]}
                </button>
            </div> */}
            <div className="flex justify-center items-center w-full">
                <form className="flex justify-center items-center mx-5">
                    <input type="text" placeholder="이름 입력"
                        ref={inRef}
                        className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5" />
                </form>
                {tagArr}
            </div>
            <div className="flex justify-center items-center
                            h-20 text-2xl m-5 p-5">
                {tagMsg}
            </div>
        </div>
    )
}

import style from './Like.module.css'
import { useState, useEffect } from 'react';

export default function Like() {
    //let cnt = 0;
    const [cnt, setCnt] = useState(0); //초기화

    const handleUp = () => {
        setCnt(cnt + 1);
        console.log("up", cnt)
    }
    const handleDown = () => {
        if (cnt > 0) { setCnt(cnt - 1); }
        console.log("down", cnt)
    }

    //맨 처음 컴포넌트 생성시 한번만 실행
    useEffect(() => {
        console.log("Like 생성")
    }, []);

    //state변수에 의해 컴포넌트가 갱신될때 실행
    useEffect(() => {
        console.log("Like 갱신", cnt)
    }, [cnt]);
    return (
        <div className={style.likediv}>
            <span onClick={handleUp}>💖</span>
            <span> {cnt} </span>
            <span onClick={() => handleDown()}>💔</span>
        </div>
    )
}


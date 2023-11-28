import style from './__Lotto.module.css'
import { useState } from 'react'
export default function Lotto() {
    const [tags, setTags] = useState();
    const handleClick = (e) => {
        e.preventDefault()
        let arr = [];
        while (arr.length < 7) { //로또 배열 생성
            let n = Math.floor(Math.random() * 45) + 1; //1~45
            if (!arr.includes(n)) arr.push(n);
        }
        let tempTags;
        tempTags = arr.map((item, idx) =>
            idx == 5 ?
                <>
                    <span className='sp' id={`sp${Math.floor(parseInt(item) / 10)}`}>
                        {item}
                    </span >
                    <span id='plus' className='sp' > + </span>
                </>
                : <span className='sp' id={`sp${Math.floor(parseInt(item) / 10)}`} >
                    {item}
                </span >

        )
        setTags(tempTags);
    }
    return (
        <main className={style.m}>
            <section className={style.sec}>
                <form className={style.fm}>
                    <div className={style.fdiv}>
                        <div className={style.div1} id='d1'>
                            {tags}
                        </div>
                    </div>
                    <div className={style.fdiv}>
                        <div className={style.div1} id='d2'>
                            <button className={style.bt} onClick={handleClick}>로또번호생성</button>
                        </div>
                    </div>
                </form >
            </section >
        </main>
    )
}

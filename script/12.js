document.addEventListener("DOMContentLoaded", () => {
    //입력버튼
    const bt12 = document.querySelectorAll(".bt12");
    //삭제버튼
    const bt13 = document.querySelectorAll(".bt13");
    //변경버튼
    const bt14 = document.querySelectorAll(".bt14");
    const txt1 = document.querySelector("#txt1");
    // let arr = new Array();
    //배열(array)
    let arr = [];
    //오브젝트(object)
    const emoji = {
        '사과': '🍎',
        '바나나': '🍌',
        '오렌지': '🍊',
        '수박': '🍉',
        '당근': '🥕',
        '오이': '🥒',
        '아보카도': '🥑',
        '브로콜리': '🥦',
    }
    //입력처리
    for (let bt of bt12) {
        // console.log(bt)
        bt.addEventListener("click", (event) => {
            event.preventDefault();

            // let emoji;          //앞뒤공백제거
            // switch (bt.innerHTML.trim()) {
            //     case '사과': emoji = '🍎'; break;
            //     case '바나나': emoji = '🍌'; break;
            //     case '오렌지': emoji = '🍊'; break;
            //     case '수박': emoji = '🍉'; break;
            // }

            //조건식이 아닌 오브젝트로 처리 (파이썬에서 딕셔너리)
            arr.push(emoji[bt.innerHTML.trim()]);
            // console.log(arr);
            txt1.value = arr.join(' ');
        });
    }
    //삭제처리
    for (let bt of bt13) {
        bt.addEventListener("click", (e) => {
            e.preventDefault();

            // arr = arr.filter((item) => {
            //     let key = bt.innerHTML.trim().slice(0, -3);
            //     return item != emoji[key];
            // });
            // 단축 (매개변수가 하나만 있을 때 괄호 생략 가능)
            // 단축 (바디 없이 리턴 하나만 있을 때 중괄호 생략 가능)
            arr = arr.filter(item => item != emoji[bt.innerHTML.trim().slice(0, -3)])
            txt1.value = arr.join(' ');
        })
    }
    //수정,변경
    for (let bt of bt14) {
        bt.addEventListener("click", (e) => {
            e.preventDefault();
            let key = bt.innerHTML.trim();
            key = key.split('→');
            // console.log(emoji[key[0]], emoji[key[1]]);

            arr = arr.map(item => item == emoji[key[0]] ? emoji[key[1]] : item);
            txt1.value = arr.join(' ');
        })
    }
});
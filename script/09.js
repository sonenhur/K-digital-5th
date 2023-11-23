//버튼처리
const handleBtClick = (comImg, playerImg, me, msg) => {
    //1.컴퓨터의 랜덤수 생성(1~6 사이의 정수)
    const com = Math.floor(Math.random() * 6) + 1;
    console.log("com=", com, "me=", me);

    //2.주사위 이미지 변경
    comImg.setAttribute("src", `./images/04_주사위/${com}.png`);
    playerImg.setAttribute("src", `./images/04_주사위/${me}.png`);

    //3.결과 메시지 출력
    if (com > me) {
        msg.innerHTML = '컴퓨터가 이겼습니다!';
    } else if (com < me) {
        msg.innerHTML = '당신이 이겼습니다!';
    } else {
        msg.innerHTML = '비겼습니다!';
    }
};

document.addEventListener("DOMContentLoaded", () => {
    // 1. 이미지 요소 가져오기
    const comImg = document.querySelector("#btDiv > img");
    const playerImg = document.querySelector("#btDiv2 > img");
    const msg = document.querySelector("#sec3 > h1");

    // 2. 각 버튼에 대해 이벤트 리스너 추가
    for (let n = 1; n <= 6; n++) {
        const bt = document.querySelector(`#bts > #bt${n}`);
        bt.addEventListener("click", () => {

            // 3. 클릭한 버튼에 해당하는 이미지 보여주기
            playerImg.setAttribute("src", `./images/04_주사위/${n}.png`);

            // 4. 결과 처리
            handleBtClick(comImg, playerImg, n, msg);
        });
    }
})

const bts = document.querySelectorAll("#msg1>button");

msg.innerHTML = "안녕하세요";
console.log(bts);
for (let n = 1; n <= 6; n++) {
    const bt = document.querySelector(`#bt${n}`);
    bt.addEventListener("click", () => {
        console.log(bt.innerHTML);
    });
}
for (let i = 0; i < bts.length; i++) {
    console.log(bts[i]);
}
// //for in : object
// for (let i in bts) { console.log(bts[i]) }
// bts.forEach((item, idx) => { console.log(item, idx) });

//for of
for (let bt of bts) {
    bt.addEventListener("click", () => {
        const me = parseInt(bt.getAttribute("id").slice(-1));
        handleBtClick(comImg, playerImg, n, msg);
        console.log(bt.getAttribute("id").slice(-1))
    });
}
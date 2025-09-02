// divShow 함수는 두 개의 div 요소와 불린 값을 인자로 받아서,
// 불린 값이 참이면 첫 번째 div를 숨기고 두 번째 div를 보여주며,
// 불린 값이 거짓이면 첫 번째 div를 보여주고 두 번째 div를 숨깁니다.
const divShow = (d1, d2, isRandom) => {
    if (isRandom) {
        d1.style.display = "none";
        d2.style.display = "flex";
    }
    else {
        d1.style.display = "flex";
        d2.style.display = "none";
    }
}

// DOMContentLoaded 이벤트는 HTML 문서와 모든 스크립트가 완전히 로드되었을 때 발생합니다.
document.addEventListener("DOMContentLoaded", () => {
    // 변수 선언
    let randomNumber;
    let userNumber

    // 이미지 요소 선택
    const updownImg = document.querySelector("#secDiv > img");

    // 랜덤 영역 요소 선택
    const btDiv1 = document.getElementById("btDiv1");
    const bt1 = document.getElementById("bt1");

    // 입력 영역 요소 선택
    const btDiv2 = document.querySelector("#btDiv2");
    const bt2 = document.querySelector("#bt2");
    const txt = document.getElementById('txt');

    // 메세지 영역 요소 선택
    const msg = document.querySelector("#sec3 > h1")

    // 랜덤 flag 설정
    divShow(btDiv1, btDiv2, false);

    // 입력 필드에 변화가 있을 때마다 입력 값을 정수로 변환하여 userNumber에 저장
    txt.addEventListener("change", (event) => {
        console.log(event.target.value);
        userNumber = parseInt(event.target.value);
    });

    // 랜덤 버튼 클릭 이벤트
    bt1.addEventListener("click", (event) => {
        event.preventDefault(); // 버튼의 기본 동작을 막습니다.
        randomNumber = Math.floor(Math.random() * 100) + 1; // 1부터 100까지의 랜덤한 숫자를 생성합니다.
        console.log(randomNumber);
        // 입력 영역을 보여줍니다.
        divShow(btDiv1, btDiv2, true);
    });

    // 확인 버튼 클릭 이벤트
    bt2.addEventListener("click", (event) => {
        event.preventDefault(); // 버튼의 기본 동작을 막습니다.
        console.log("bt2");
        // 사용자가 맞힌 경우
        if (userNumber == randomNumber) {
            msg.innerHTML = "축하합니다!"
            updownImg.setAttribute("src", "./images/04_updown/good.png") // 축하 이미지 URL
            divShow(btDiv1, btDiv2, false);
        }
        // 사용자의 숫자가 더 큰 경우
        else if (userNumber > randomNumber) {
            msg.innerHTML = "다운";
            updownImg.setAttribute("src", "./images/04_updown/down.png"); // 'down' 이미지 URL
        }
        // 사용자의 숫자가 더 작은 경우
        else {
            msg.innerHTML = "업";
            updownImg.setAttribute("src", "./images/04_updown/up.png"); // 'up' 이미지 URL
        }
    });
});

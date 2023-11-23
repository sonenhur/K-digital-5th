// 폭탄섞기
// 배열이용 => 배열에 1이 있는 위치가 폭탄의 위치
// 1의 위치를 shuffle로 구현
// 폭탄이 섞였는지 isShuffle flag변수를 활용

// 박스 클릭 처리
// 폭탄이 섞여야 박스가 클릭되지 않음(isShuffle==true)
// 이미 이미지가 있으면 더이상 이미지를 
// 폭탄 이미지가 나오면 더이상 클릭이 되지 않음
// 폭탄섞기 버튼이 활성화되면 전체 화면을 초기화
// 하트 이미지가 나오면 현재 몇개의 하트가
// 하트 개수가 8개가 되면 마지막 한 박스에

let arr = [0, 0, 0, 0, 0, 0, 0, 0, 1]
let isShuffle = false;
let cnt = 0; //하트 갯수

const init = (boxes, msg) => {
    msg.innerHTML = " ";
    boxes.forEach(element => {
        element.innerHTML = element.getAttribute("id").slice(-1);
    })
    cnt = 0;
}
document.addEventListener('DOMContentLoaded', () => {
    const bt = document.querySelector('#btdiv>button');
    const boxes = document.querySelectorAll(".box");
    const msg = document.querySelector("#msg");

    bt.addEventListener("click", () => {
        console.log("변경 전", arr);
        arr = arr.sort(() => Math.random() - 0.5); //배열 섞기
        /* 배열 정렬
        - sort() : 알파벳 정렬
        - sort((a,b)=>a-b): 숫자 오름차순
        - sort((a,b)=>b-a): 숫자 내림차순
        */
        console.log("변경 후", arr);
        isShuffle = true;
    });

    for (let box of boxes) {
        box.addEventListener("click", () => {
            if (!isShuffle) {
                init(boxes, msg)
                msg.innerHTML = "<h2>폭탄을 섞어주세요</h2>";
                return;
            }
            if (isShuffle) {
                msg.innerHTML = "<h2>행운을 빌어요</h2>";

            }
            if (isNaN(box.innerHTML)) {
                console.log("이미지가 있음");
                return;
            }
            //현재 박스를 기준으로 배열의 첨자를 구함
            let idx = box.getAttribute("id").slice(-1) - 1;

            //배열 내용확인
            if (arr[idx] === 0) {
                box.innerHTML = '<img src="./images/05_heart/heart.png">'
                cnt++;
                console.log(cnt, "cnt");
            }
            else {
                box.innerHTML = '<img src="./images/05_heart/boom.png">'
                isShuffle = false;
                msg.innerHTML = "<h2>실패</h2>";
            }
            //console.log(idx);
            if (cnt === 8) {
                for (let box of boxes) {
                    let idx1 = arr.indexOf(1) + 1;
                    console.log("idx1 = ", idx1);
                    document.querySelector(`#box${idx1}`).innerHTML = '<img src="./images/05_heart/heart.png">'
                    isShuffle = false;
                    msg.innerHTML = "<h2>축하합니다!</h2>"
                    // box.innerHTML = '<img src="./images/05_heart/heart.png">'
                    // msg.innerHTML = "<h2>축하합니다!</h2>"
                    // isShuffle = false;
                }
            }
        })
    }
});

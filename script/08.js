document.addEventListener("DOMContentLoaded", () => {

    // 1. 이미지 요소 가져오기
    const img = document.querySelector("#com");

    // 2. 각 버튼에 대해 이벤트 리스너 추가
    for (let n = 1; n <= 6; n++) {
        const bt = document.querySelector(`#bts > #bt${n}`);
        bt.addEventListener("click", () => {

            // 3. 클릭한 버튼에 해당하는 이미지 보여주기
            img.setAttribute("src", `./images/04_주사위/${n}.png`)
        })
    }
})

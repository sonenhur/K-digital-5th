document.addEventListener("DOMContentLoaded", () => {
    const txt1 = document.querySelector("#txt1");
    const txt2 = document.querySelector("#txt2");
    const bt1 = document.querySelector("#bt1");
    const bt2 = document.querySelector("#bt2");

    //회문 처리
    bt1.addEventListener("click", (event) => {
        event.preventDefault();
        // 버튼의 기본 동작 막음
        console.log();
        // 입력 영역을 보여줍니다.
        let result = "";

        for (let i = txt1.value.length - 1; i >= 0; i--) {
            result += txt1.value[i];
        }
        console.log(result);
        if (result == txt1.value) txt2.value = '회문입니다';
        else txt2.value = '회문이 아닙니다';
    });

    //숫자 합계
    bt2.addEventListener("click", () => { });
});
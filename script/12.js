document.addEventListener("DOMContentLoaded", () => {
    // HTML 요소를 선택합니다.
    const txt1 = document.querySelector("#txt1");
    const txt2 = document.querySelector("#txt2");
    const bt1 = document.querySelector("#bt1");
    const bt2 = document.querySelector("#bt2");

    // 회문 처리
    bt1.addEventListener("click", (event) => {
        event.preventDefault(); // 버튼의 기본 동작을 막습니다.
        let result = "";

        // 입력된 문자열을 거꾸로 뒤집습니다.
        for (let i = txt1.value.length - 1; i >= 0; i--) {
            result += txt1.value[i];
        }

        // 뒤집은 문자열과 원래 문자열이 같으면 회문입니다.
        if (result == txt1.value) txt2.value = '회문입니다';
        else txt2.value = '회문이 아닙니다';
    });

    // 숫자 합계
    bt2.addEventListener("click", (event) => {
        event.preventDefault(); // 버튼의 기본 동작을 막습니다.
        let sum = 0;

        // 문자열에서 숫자를 찾아 합계를 계산합니다.
        for (let c of txt1.value) {
            if (!isNaN(c)) sum = sum + parseInt(c);
        }

        // 합계를 출력 영역에 표시합니다.
        txt2.value = sum;
    })
})

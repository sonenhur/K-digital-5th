//select box 제어 함수
const handleSelChange = (sel1, sel2, unit1, unit2) => {
    // unit1.innerHTML = sel1.value;
    if (sel1.value == 'c') {
        sel2.value = 'f';
        unit1.innerHTML = '℃';
        unit2.innerHTML = "℉";
    }
    else {
        sel2.value = 'c';
        unit1.innerHTML = '℉';
        unit2.innerHTML = "℃";
    }
    //text 영역 초기화
    t1.value = '';
    t1.focus();
    t2.value = '';
}
document.addEventListener("DOMContentLoaded", () => {
    //제어 컴포넌트 가져오기
    const sel1 = document.querySelector("#sel1");
    const sel2 = document.querySelector("#sel2");

    const txt1 = document.querySelector("#txt1");
    const txt2 = document.querySelector("#txt2");

    const unit1 = document.querySelector("#unit1");
    const unit2 = document.querySelector("#unit2");

    //select box 제어
    sel1.addEventListener("change", () => {
        handleSelChange(sel1, sel2, unit1, unit2);
    });

    sel2.addEventListener("change", () => {
        handleSelChange(sel2, sel1, unit2, unit1);
    });

    //text box 제어
    txt1.addEventListener("change", () => {
        if (sel1.value == "c") {
            txt2.value = ((parseInt(txt1.value) * 9 / 5) + 32).toFixed(4);
        }
        else {
            txt2.value = ((parseInt(txt1.value) - 32) * 5 / 9).toFixed(4);
        }
    });
})
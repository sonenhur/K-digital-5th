document.addEventListener("DOMContentLoaded", () => {
    const bt = document.querySelectorAll("#d2>button");
    const d1 = document.querySelector("#d1");
    let arr = [];

    bt.forEach(button => {
        button.addEventListener("click", (e) => {
            e.preventDefault();

            arr.length = 0;  //배열초기화

            while (arr.length < 7) { //로또 배열 생성
                let n = Math.floor(Math.random() * 45) + 1; //1~45
                if (!arr.includes(n)) arr.push(n);
            }

            let tags;
            tags = arr.map((item, idx) =>
                idx == 5 ?
                    `<span class='sp' id='sp${Math.floor(parseInt(item) / 10)}'>
                ${item}
                </span>
                <span id='plus' class= 'sp' > + </span>`
                    : `<span class= 'sp' id = 'sp${Math.floor(parseInt(item) / 10)}' >
                         ${item}
                </span>`

            )

            d1.innerHTML = tags.join('');
        });
    });
});

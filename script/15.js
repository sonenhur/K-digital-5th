let arr = [0, 0, 0, 0, 0, 0, 0, 0, 1]
let isShuffle = false;
document.addEventListener('DOMContentLoaded', () => {
    const bt = document.querySelector('#btdiv>button');
    bt.addEventListener("click", () => {
        console.log("변경 전", arr);
        arr = arr.sort(() => Math.random() - 0.5); //배열 섞기
        console.log("변경 후", arr);
        isShuffle = true;

    })

});
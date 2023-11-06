document.addEventListener("DOMContentLoaded", () => {
    const txt = document.getElementById('txt');

    txt.addEventListener('change', (e) => {
        console.log(e.target.value);
    });
    function playGame() {
        var userNumber = document.getElementById('userInput').value;
        var randomNumber = Math.floor(Math.random() * 6) + 1;

        var resultDiv = document.getElementById('result');
        var resultImg = document.getElementById('resultImg');

        if (userNumber == randomNumber) {
            resultDiv.innerHTML = "축하합니다! 숫자를 맞췄습니다.";
            img.setAttribute("src", `./images/04_updown/OK.png`) // 축하 이미지 URL
        } else if (userNumber > randomNumber) {
            resultDiv.innerHTML = "입력한 숫자가 더 큽니다.";
            img.src = './images/04_updown/up.png'; // '높음' 이미지 URL
        } else {
            resultDiv.innerHTML = "입력한 숫자가 더 작습니다.";
            img.src = './images/04_updown/down.png'; // '낮음' 이미지 URL

        }
    }
});
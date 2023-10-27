// 함수 만들기 연습
const hello = (n) => {
    // alert("Hello! 버튼" + n);
    // document.getElementById('msg').innerHTML = "<h1>Hello! 버튼" + n + "</h1>";
    // document.querySelector('#msg').innerHTML = "<h1>Hello! 버튼" + n + "</h1>";
    // document.querySelector('#msg').innerHTML = "<h1>Hello! 버튼" + n + "</h1>";
    // document.querySelector('#msg2').innerHTML = "<h1>Hello! 버튼" + n + "</h1>";
    // switch (n) {
    //     case 1: document.querySelector('#msg1').innerHTML = "<h1>Hello! 버튼" + n + "</h1>";
    //         break;
    //     case 2: document.querySelector('#msg1').innerHTML = "<h1>Hello! 버튼" + n + "</h1>";
    //         break;
    //     case 3: document.querySelector('#msg2').innerHTML = "<h1>Hello! 버튼" + n + "</h1>";
    //         break;
    //     case 4: document.querySelector('#msg2').innerHTML = "<h1>Hello! 버튼" + n + "</h1>";
    //         break;
    // }
    // 백틱(`) 사용
    // 삼항연산
    // ` `으로 묶고 ${}안에 문자열
    let cnt = 0;
    n <= 2 ? cnt = 1 : cnt = 2;
    console.log("cnt", cnt);
    document.querySelector(`#msg${cnt}`).innerHTML = "<h1>Hello! 버튼" + n + "</h1>";
};

document.addEventListener("DOMContentLoaded", () => {
    document.getElementById("msg2").innerHTML = '안녕!!';
    const bt1 = document.createElement("button");
    const bt1Text = document.createTextNode("Push Button 3");

    bt1.appendChild(bt1Text);
    bt1.setAttribute("id", "bt3");

    const bt2 = document.createElement("button");
    const bt2Text = document.createTextNode("Push Button 4");

    bt2.appendChild(bt2Text);
    bt2.setAttribute("id", "bt4");
    document.getElementById('btDiv2').append(bt1);
    document.getElementById('btDiv2').append(bt2);

    // 버튼에 이벤트 부여
    document.getElementById('bt3').addEventListener("click", () => { hello(3); });
    bt2.addEventListener("click", () => { hello(4); });
});
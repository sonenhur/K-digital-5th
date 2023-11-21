// 일일 박스오피스 데이터 가져오기
const getBoxOffice = (dt, tbDiv, gubun) => {
    let apikey = "f5eef3421c602c6cb7ea224104795888";
    let url = `https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=${apikey}&targetDt=${dt}`;
    if (gubun == '2') url = url + `&multiMovieYn=Y`;
    else if (gubun == '3') url = url + `&multiMovieYn=N`;

    let boxList;
    tbDiv.innerHTML = '';
    let tags = `
    <table>
    <tr>
        <th>순위</th>
        <th>영화명</th>
        <th>개봉일</th>
        <th>매출액</th>
        <th>관객수</th>
    </tr>`;
    fetch(url)
        .then(resp => resp.json())
        .then((data) => {
            boxList = data.boxOfficeResult.dailyBoxOfficeList;
            let trs = boxList.map(item =>
                `<tr>
                <td class='sp1'>${item.rank}</td>
                <td class='sp2'>${item.movieNm}</td>
                <td class='sp1'>${item.openDt}</td>
                <td class='sp3'>${parseInt(item.salesAmt).toLocaleString('ko-KR')}</td>
                <td class='sp3'>${parseInt(item.audiCnt).toLocaleString('ko-KR')}</td>
                </tr>`
            );
            trs = trs.join('')
            tags = tags + trs + `</table>`;
            tbDiv.innerHTML = tags;
        })
}
//json은 자바스크립트에서 오브젝트 처리. key값

document.addEventListener("DOMContentLoaded", () => {
    const tbDiv = document.querySelector('#tbDiv');
    const bt = document.querySelector('#bt');

    bt.addEventListener("click", (event) => {
        event.preventDefault();
        const dt = inform.dt.value.replaceAll('-', '')
        const gubun = inform.gubun.value;
        if (dt === '' || dt === undefined) {
            alert('날짜를 선택하세요');
            return;
        }
        getBoxOffice(dt, tbDiv, gubun);
        console.log(dt)
    })

});

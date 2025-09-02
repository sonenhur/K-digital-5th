let s = 'Hello Javascript!!';
console.log('문자열 = ', s)
console.log('문자열 길이 = ', s.length)
console.log('첫번째 문자 = ', s[0])
console.log('5문자 추출 =', s.substring(0, 5))
console.log('5문자 추출 =', s.slice(0, 6))
console.log('마지막 문자 출력=', s.slice(-1))

let result = '';
for (let c of s) {
    if (c >= 'a' && c <= 'z')
        result = result + c.toUpperCase();
    else result = result + c.toLowerCase();
}
console.log('대소문자 변환', result);

// s = '12';
//isNaN(s) : 숫자로 이루어진 문자열은 false
console.log('숫자 확인 =', isNaN(s));
console.log("대문자 변환 =", s.toUpperCase())
console.log('소문자 변환 =', s.toLowerCase())

console.log('J의 위치 =', s.indexOf('J'))
console.log('x의 위치 = ', s.indexOf('x'))
console.log('J의 유무 =', s.includes('J'))
console.log('x의 유무 =', s.includes('x'))
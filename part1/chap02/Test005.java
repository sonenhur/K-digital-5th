package part1.chap02;

public class Test005 {
    public static void main(String[] args) {
        byte a = 0b00010001; // 2진수 표현은 0b로 시작함
        byte b = 0b00100010;
        System.out.println(a);
        System.out.println("Integer.toBinaryString(a) = " + Integer.toBinaryString(a));
        int c = a & b; // 각 비트를 비교해 둘 다 1이면 결과의 해당 위치에 1을, 그렇지 않으면 0을 반환
        System.out.println(c + " → " + Integer.toBinaryString(c));
        int d = a | b; // 각 비트를 비교해 적어도 하나가 1이면 결과의 해당 위치에 1을 반환
        System.out.println(d + " → " + Integer.toBinaryString(d));
        int e = a ^ b; // 각 비트를 비교해 두 비트가 다르면 결과의 해당 위치에 1을, 같으면 0을 반환
        System.out.println(e + " → " + Integer.toBinaryString(e));
        int f = 12;
        int g = ~f + 1; // ~ : 0을 1로, 1을 0으로 반전시키는 비트 NOT 연산자
        System.out.println(g);
        int h = f << 1; // 왼쪽으로 1비트 이동 = 2배 숫자
        // f = 12의 이진수 00001100을 왼쪽으로 1비트 시프트하면 00011000, 이는 십진수로 24.
        System.out.println(h);
    }
}

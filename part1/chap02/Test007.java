package part1.chap02;

public class Test007 {
    public static void main(String[] args) {
        byte a = 23;
        int b = (int) a; // type casting(형변환)
        // explicit 명시적 형변환 <-> implicit 묵시적 형변환(자동)
        System.out.println(b);
        int c = 23;
        byte d = (byte) c;
        System.out.println(d);
        // 작성자가 강제시킴. (숫자 커지면 결과 달라지니 남용하지 말 것)
    }
}

package part1.chap05;

public class Test40_2 {
    private static int sum(int a, int b) {
        return a + b;
    }

    private static int sum(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        int res = sum(10, 20);
        System.out.println("sum1: " + res);
        res = sum(10, 20, 30);
        // int 또 선언하면 에러뜸
        System.out.println("sum2: " + res);
    }
}
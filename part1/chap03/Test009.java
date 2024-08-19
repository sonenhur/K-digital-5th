package part1.chap03;

public class Test009 {
    public static void main(String[] args) {
        int a = 12;
        int b = 2;
        char op = '+';
        switch (op) {
            case '+':
                System.out.println(a + b);
                break;
            case '-':
                System.out.println(a - b);
                break;
            case '*':
                System.out.println(a * b);
                break;
            case '/':
                System.out.println(a / b);
                break;
            default:
                System.out.println("부적합 연산자");
        }
    }
}
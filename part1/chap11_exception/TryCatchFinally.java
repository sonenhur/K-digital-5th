package part1.chap11_exception;

public class TryCatchFinally {

    public static void main(String[] args) {
        try {
            System.out.println("1");
            String s = null;
            s.length(); // 이 시점에서 catch로 탈출
            System.out.println("2");
            System.out.println("3");
        } catch (Exception e) {
            System.out.println("오류 발생");
        } finally {
            System.out.println("OK");
        }
        System.out.println("4");
    }
}

package part1.chap11_exception;

public class NagativeNumberException extends Exception {

    public NagativeNumberException() {
        super("음수는 허용하지 않습니다");
    }
}

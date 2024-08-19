package part1.chap07_inheritance;

public class Test {
    public static void main(String[] args) {

//		Child c = new Child();
        Child c = new Child("여기에 문자를 입력하면 Parent쪽에 String name쪽을 반환합니다.");

        System.out.println(c.toString());
    }
}

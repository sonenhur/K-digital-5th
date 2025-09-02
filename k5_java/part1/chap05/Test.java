package part1.chap05;

public class Test {

    public static int f(int x) {
        int value;
        value = 2 * x * x + 4 * x + 5;
        return value;
    }

    public static void main(String[] args) {
        // 함수 f의 결과 출력
        int y = f(2);
        System.out.println("y = " + y);

        // Armor 객체 생성 및 사용
        Armor arm = new Armor();
        // arm.name = "아이언맨"; // 'name'은 private 접근 제한자이므로 직접 접근 불가
        arm.setName("아이언맨"); // Setter 메서드를 통해 'name' 필드 설정
        arm.weight = 10; // default 접근 제한자이므로 같은 패키지 내에서 접근 가능
        arm.color = "Red";
        arm.setFly(true); // Protected 필드는 같은 패키지나 서브클래스에서 접근 가능

        // Armor 객체의 메소드 호출
        arm.takeOff();
        arm.shootLaser();
        arm.launchMissile();
        arm.land();
    }
}

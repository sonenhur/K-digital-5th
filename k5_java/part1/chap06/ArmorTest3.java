package part1.chap06;

public class ArmorTest3 {
    public static void doWork() {
        Armor suit1 = new Armor();
        Armor suit2 = new Armor();
        Armor suit3 = new Armor();

        suit1.setName();
        suit1.setHeight();

        suit2.setName();
        suit2.setHeight();

        suit3.setName();
        suit3.setHeight();

        System.out.println(suit1.getName() + " : " + suit1.getHeight());
        System.out.println(suit2.getName() + " : " + suit2.getHeight());
        System.out.println(suit3.getName() + " : " + suit3.getHeight());
    }

    public static void main(String[] args) {

        doWork();

        // static을 위 필드에 달아서 처음부터 참조할 수 있게 하거나(Test3)
        // 이 클래스 자체를 객체로 만들어서 doWork가 참조할 수 있게 함(Test2)

        // ArmorTest3 at = new ArmorTest3();
        // at.doWork();

        // static : 정적 멤버 선언
        // 			해당 클래스로 생성한 모든 인스턴스가 공유
    }

}
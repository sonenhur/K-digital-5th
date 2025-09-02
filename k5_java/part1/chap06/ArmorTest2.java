package part1.chap06;

public class ArmorTest2 {
    public static void main(String[] args) {

        ArmorTest2 at = new ArmorTest2();
        at.doWork();
        // 왜 static 달아야 하는지 안보고 쓰면서 설명할 수 있도록 연습
        // 클래스 필드 = 프로그램 시작시
        // 스태틱은 인스턴스를 생성하지 않고도 사용할 수 있다
    }

    public void doWork() {
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

}
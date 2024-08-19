package part1.chap07_InheritTest;

public class Game {
    public static void main(String[] args) {
        Marine m = new Marine();
        Tank t = new Tank();
//		마린이라는 객체 m, 탱크라는 객체 t 선언
        m.attack();
        t.attack();
//		m과 t가 각각 공격하는 것을 시뮬레이션
//		public void attack() {
//			System.out.print("Attack: ");가 실행됨
        System.out.println();

        m.attack(t);
        m.attack(t);
        m.attack(t);
        m.attack(t);
//		m이 t를 공격하는 것을 4번 실행
    }
}

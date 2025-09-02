package part1.chap07_InheritTest;

public class Marine extends Unit {
    public Marine() {
        super(50L);
    }

    @Override
    public void attack() {
        super.attack();
        System.out.println("마린이 총을 쏩니다.");
    }

    public void attack(Tank t) {
        t.attacked(this);
    }
//	 여기 this는 Marine임.
}
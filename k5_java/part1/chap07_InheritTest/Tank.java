package part1.chap07_InheritTest;

public class Tank extends Unit {
    public Tank() {
        super(100L);
    }

    @Override
    public void attack() {
        super.attack();
        System.out.println("탱크가 포를 쏩니다.");
    }

    public void attacked(Marine AnyName) {
        super.setHealth(super.getHealth() - Unit.M2T);
    }
//	Marine.java 안에 있는 public void attack(Tank t)
//	{t.attacked(this);} 가 들어옴
}
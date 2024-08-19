package part1.chap07;

abstract class Employee1 {
    String name;
    int salary;

    public abstract void calcSalary();

    public abstract void calcBonus();
}

class Salesman extends Employee1 {
    public void calcSalary() {
        System.out.println("Salesman 급여 = 기본급 + 판매수당");
    }

    public void calcBonus() {
        System.out.println("Salesman 보너스 = 기본급 * 12 *4");
    }
}

class Consultant extends Employee1 {
    public void calcSalary() {
        System.out.println("Consultant 급여 = 기본급 + 컨설팅 특별 수당");
    }

    public void calcBonus() {
        System.out.println("Consultant 보너스 = 기본급 * 12 *2");
    }
}

abstract class Manager extends Employee1 {
    public void calcSalary() {
        System.out.println("Manager 급여 = 기본급 + 팀 성과");
    } // calcBonus 구현 안해서 인스턴스 못만듬.
}

class Director extends Manager {
    public void calcBonus() {
        System.out.println("Director 보너스 = 기본급 * 12 *6");
    } // 위에 Manager에서 calcSalary 상속받고, Bonus 구현했기에 인스턴스 생성됨.
}

public class HRSTest {
    public static void main(String[] args) {
        Salesman s = new Salesman();
        Consultant c = new Consultant();
        Director d = new Director();

        s.calcBonus();
        c.calcBonus();
        d.calcBonus();
    }
}
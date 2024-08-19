package part1.com.ruby.java.test2;

import part1.com.ruby.java.test1.Armor;

public class Exam01 {
    public static void main(String[] args) {
        Armor arm = new Armor();
//		arm.setHeight(100);
        arm.height = 99;
//		arm.setHeight(55);
        int result = arm.takeOff();
        System.out.println("Result = " + result);
        arm.speedUp(100);
        int speed = arm.getSpeed();
//		System.out.println(height);
        System.out.println(arm.height);
        arm.show();
        arm.speedUp(99);
        arm.test(1, 2);
        arm.test(1, 2, 3);
    }
}

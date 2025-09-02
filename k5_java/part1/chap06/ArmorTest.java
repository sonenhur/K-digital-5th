package part1.chap06;

public class ArmorTest {

    public static void main(String[] args) {
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

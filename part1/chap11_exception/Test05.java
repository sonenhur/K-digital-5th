package part1.chap11_exception;

public class Test05 {
    int battery = 0;

    public static void main(String[] args) {
        Test05 test = new Test05();
        test.charge(30);
        test.charge(10);
        test.charge(-20);
    }

    public void charge(int time) {

        if (time < 0) {
            time = 0;
            try {
                throw new NagativeNumberException();
            } catch (NagativeNumberException e) {
                e.printStackTrace();
            }
        }
        battery += time;
        System.out.println("현재 배터리 : " + battery);
    }
}

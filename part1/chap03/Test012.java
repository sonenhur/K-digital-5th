package part1.chap03;

public class Test012 {
    public static void main(String[] args) {
        int ix = 6;
        if (ix % 2 == 0) {
            if (ix % 3 == 0) System.out.println(ix + "은 2,3의 배수입니다.");
        }
        System.out.println();
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                System.out.print(i * j + " ");
            }
            System.out.println();
        }
    }
}
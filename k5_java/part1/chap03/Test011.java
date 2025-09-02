package part1.chap03;

public class Test011 {
    public static void main(String[] args) {
////	for 문으로 구구단 만들기
//        for (int i = 1; i < 10; i++) {
//            for (int j = 1; j < 10; j++) {
//                System.out.print(i + "*" + j + "=" + (i * j) + " ");
//            }
//            System.out.println();
//        }
////	while 문으로 구구단 만들기
//        System.out.println();
//        int x = 1;
//        int y = 1;
//        while (x < 10) {
//            while (y < 10) {
//                System.out.print(x + "*" + y + "=" + (x * y) + " ");
//                y++;
//            }
//            x++;
//            y = 1;
//            System.out.println("");
//        }
//	do-while 문으로 구구단 만들기
//        System.out.println();
//        int a = 1;
//        do {
//            int b = 1;
//            do {
//                if (b > 10)
//                    continue;
//                System.out.print(a + "*" + b + "=" + (a * b) + " ");
//                b++;
//            } while (b < 10);
//            System.out.println();
//            a++;
//        } while (a < 10);
//    }
//        for 문으로 구구단 만들기
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                System.out.print(i + "x" + j + " = " + i * j + " ");
            }
            System.out.println();
        }
        System.out.println();
//        while 문으로 구구단 만들기
        int x = 1, y = 1;
        while (x < 10) {
            while (y < 10) {
                System.out.print(x + "x" + y + " = " + x * y + " ");
                y++;
            }
            System.out.println();
            x++;
            y = 1;
        }
        System.out.println();
//        do-while 문으로 구구단 만들기
        int a = 1, b = 1;
        do {
            do {
                System.out.print(a + "x" + b + " = " + a * b + " ");
                b++;
            } while (b < 10);
            System.out.println();
            a++;
            b = 1; // b를 1로 초기화해서 다음 단 준비
        } while (a < 10);
    }
}
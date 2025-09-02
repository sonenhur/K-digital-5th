package part1.chap04;

import java.util.Scanner;

public class Test035 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 첫 번째 배열 (국어, 영어, 수학 점수)
        int[] arr = new int[3];
        System.out.print("국어 점수: ");
        arr[0] = sc.nextInt();
        System.out.print("영어 점수: ");
        arr[1] = sc.nextInt();
        System.out.print("수학 점수: ");
        arr[2] = sc.nextInt();

        for (int i = 0; i < 3; i++) {
            System.out.println(arr[i]);
        }

        int avg = (arr[0] + arr[1] + arr[2]) / 3;
        System.out.println("평균은 " + avg);
// -----------------------------------------------------------
        System.out.println("-".repeat(20));

        // 두 번째 배열 (10, 20, 30, 40, 50)
        int[] arr2 = new int[5];
        arr2[0] = 10;
        arr2[1] = 20;
        arr2[2] = 30;
        arr2[3] = 40;
        arr2[4] = 50;

        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i]);
        }
        // 확장된 for문 (향상된 for문)
        System.out.println();
        System.out.println("확장된 for문");
        for (int j : arr2) {
            System.out.print(j);
        }
    }
}

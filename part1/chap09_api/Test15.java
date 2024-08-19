package part1.chap09_api;

import java.util.Arrays;
import java.util.Random;

public class Test15 {
    public static void main(String[] args) {

        int[] data = new int[10];
        // 배열의 크기를 지정
        // 데이터는 힙영역에 확보, arr[공간]은 스택에 확보
        Random r2 = new Random();

        for (int i = 0; i < data.length; i++) {
            data[i] = r2.nextInt(10);
            // 0부터 10까지의 랜덤 정수를 생성
        }

        // 배열 출력
        for (int i : data)
            System.out.print(" " + i);

        System.out.println();

        Arrays.sort(data);
        // 오름차순 정렬

        for (int i : data)
            System.out.print(" " + i);

        System.out.println();

        System.out.println(Arrays.toString(data)); // 배열 모양으로 찍어줌
    }
}

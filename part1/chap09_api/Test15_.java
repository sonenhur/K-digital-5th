package part1.chap09_api;

import java.util.Arrays;
import java.util.Random;

public class Test15_ {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] data = new int[10];// []안에 배열 크기;
        Random training = new Random();

        for (int i = 0; i < data.length; i++) {
            data[i] = training.nextInt(10);
            // training.nextInt(10)은 0 이상 10 미만의 임의의 정수를 반환하는 Java 메소드입니다.
            // 따라서 data[i] = training.nextInt(10);는 data 배열의 i번째 요소에 0부터 9까지의 임의의 정수를 저장합니다.
            // 이것은 종종 데이터를 무작위로 초기화할 때 사용됩니다.
        }
        for (int i : data) // 향상된 for 루프(enhanced for loop)
            // 이 구문은 배열 data의 모든 요소를 순회하며, 각 요소를 i라는 변수에 할당합니다.
            // 이렇게 하면 배열의 각 요소에 대해 작업을 수행할 수 있습니다.
            System.out.println(" " + i);

        System.out.println();
        Arrays.sort(data);
        // 오름차순 정렬
        for (int i : data)
            System.out.println(" " + i);
        System.out.println();
    }

}

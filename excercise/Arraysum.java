package excercise;

import java.util.Arrays;
import java.util.Random;

public class Arraysum {
    private static void sortArray(int[] arr) {
        int temp;
        for (int i = 0; i < 24; i++) {
            for (int j = i + 1; j < 24; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        // 데이터 생성
        Random rd = new Random();
        int[] arr = new int[24];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(100); // 0~99 사이의 랜덤 값
        }
        System.out.println(Arrays.toString(arr));
        // 배열 정렬&출력
        sortArray(arr);
        System.out.println(Arrays.toString(arr));
        // 행렬 생성
        Matrix mA = new Matrix(arr, 0, 3, 4);
        mA.print();

        System.out.println("=".repeat(30));

        Matrix mB = new Matrix(arr, 12, 3, 4);
        mB.print();
        System.out.println("=".repeat(30));

        System.out.println("행렬 합 출력");
        Matrix mC = Matrix.sum(mA, mB);
        if (mC != null)
            mC.print();
        System.out.println("=".repeat(30));

        System.out.println("행렬 곱 출력");
        Matrix mD = Matrix.multiple(mA, mB);
        if (mD != null)
            mD.print();

    }
}

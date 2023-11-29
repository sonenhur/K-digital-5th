package chap2_dataStructure;

import java.util.Random;

public class 정수배열정렬 {
    // 랜덤한 정수를 배열에 채우는 메소드
    static void inputData(int[] data) {
        Random rand = new Random();
        for (int i = 0; i < data.length; i++) {
            data[i] = rand.nextInt(100); // 0~99 사이의 랜덤한 정수를 배열에 채움
        }
    }

    // 버블 정렬을 이용하여 데이터를 정렬하는 메소드
    static void sortData(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }

    // 배열의 두 요소의 위치를 바꾸는 메소드
    static void swap(int[] arr, int ind1, int ind2) {
        int temp = arr[ind1];
        arr[ind1] = arr[ind2];
        arr[ind2] = temp;
    }

    // 배열의 데이터를 역순으로 재배치하는 메소드
    static void reverse(int[] a) {
        for (int i = 0; i < a.length / 2; i++) {
            swap(a, i, a.length - i - 1);
        }
    }

    // 배열의 데이터를 역순으로 정렬하는 메소드
    static void reverseSort(int[] arr) {
        sortData(arr); // 먼저 배열을 정렬
        reverse(arr); // 그 다음 배열을 역순으로 재배치
    }

    public static void main(String[] args) {
        int[] data = new int[10];
        inputData(data); // 랜덤한 정수를 배열에 채움
        for (int num : data) {
            System.out.print(num + " ");
        }
        sortData(data); // 배열을 정렬
        System.out.println();
        for (int num : data) {
            System.out.print(num + " ");
        }
        reverse(data); // 역순으로 재배치 - 정렬 아님
        System.out.println();
        for (int num : data) {
            System.out.print(num + " ");
        }
        reverseSort(data); // 역순으로 재배치 - 정렬 아님
        System.out.println();
        for (int num : data) {
            System.out.print(num + " ");
        }
    }
}

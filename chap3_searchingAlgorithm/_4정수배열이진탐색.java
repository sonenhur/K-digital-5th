package chap3_searchingAlgorithm;

// 3장 - 1번 실습 과제 > 2번 실습: 스트링 객체의 정렬과 이진 탐색 > 3번 실습: 객체 정렬과 이진 탐색
// comparator 구현 실습

import java.util.Arrays;
import java.util.Random;

public class _4정수배열이진탐색 {

    // 무작위 정수를 배열에 입력하는 메소드
    private static void inputData(int[] data) {
        Random rand = new Random();
        for (int i = 0; i < data.length; i++)
            data[i] = rand.nextInt(50);
    }

    // 배열의 데이터를 출력하는 메소드
    private static void showData(int[] data) {
        for (int d : data) {
            System.out.print(d + " ");
        }
        System.out.println();
    }

    // 배열의 데이터를 정렬하는 메소드
    private static void sortData(int[] data) {
        for (int i = 0; i < data.length; i++)
            for (int j = i + 1; j < data.length; j++) {
                if (data[i] > data[j]) {
                    int temp;
                    temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                }
            }
    }

    // 이진 탐색 메소드
    private static int binarySearch(int[] data, int key) {
        int left = 0;
        int right = data.length - 1;
        do {
            int center = (left + right) / 2;
            if (data[center] == key)
                return center; // 키를 찾으면 인덱스 반환
            else if (data[center] < key)
                left = center + 1; // 키가 중앙값보다 크면 왼쪽 범위를 줄임
            else
                right = center - 1; // 키가 중앙값보다 작으면 오른쪽 범위를 줄임
        } while (left <= right);

        return -1; // 키를 찾지 못하면 -1 반환
    }

    // 선형 탐색 메소드
    private static int linearSearch(int[] data, int key) {
        for (int i = 0; i < data.length; i++)
            if (data[i] == key)
                return i; // 키를 찾으면 인덱스 반환
        return -1; // 키를 찾지 못하면 -1 반환
    }

    public static void main(String[] args) {
        int[] data = new int[10]; // 10개의 정수를 저장할 배열 생성
        inputData(data);
        showData(data);
        sortData(data);
        System.out.println();
        for (int num : data) { // 정렬된 배열 출력
            System.out.print(num + " ");
        }

        int key = 33; // 찾을 키 설정
        int linearResult = linearSearch(data, key); // 선형 탐색 실행
        System.out.println("\nlinearSearch(): result = " + linearResult); // 결과 출력

        key = 39; // 찾을 키 변경
        int binaryResult = binarySearch(data, key); // 이진 탐색 실행
        System.out.println("\nbinarySearch(): result = " + binaryResult); // 결과 출력

        int idx = Arrays.binarySearch(data, key); // Java의 내장 이진 탐색 메소드 사용
        System.out.println("\nArrays.binarySearch(): result = " + idx); // 결과 출력
    }
}
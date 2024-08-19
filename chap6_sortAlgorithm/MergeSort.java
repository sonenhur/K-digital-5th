package chap6_sortAlgorithm;

import static java.lang.System.arraycopy;

public class MergeSort {
    static int[] buff; // 작업용 배열 선언

    // 배열 a의 일부를 병합 정렬하는 merge 메소드
    static void merge(int[] a, int left1, int right1, int left2, int right2) {
        buff = new int[right2 - left1 + 1]; // 병합할 작업용 배열 buff 선언 및 크기 조정
        int i = left1, j = left2, k = 0; // 인덱스 변수 i, j, k 초기화

        // 두 개의 부분 배열을 합치면서 작은 순서대로 buff 배열에 저장
        while (i <= right1 && j <= right2) {
            buff[k++] = (a[i] <= a[j]) ? a[i++] : a[j++];
        }

        // 남은 부분 배열의 원소를 buff 배열에 복사
        while (i <= right1) {
            buff[k++] = a[i++];
        }

        while (j <= right2) {
            buff[k++] = a[j++];
        }

        // 병합된 결과를 원래 배열 a에 복사
        if (right2 + 1 - left1 >= 0) {
            arraycopy(buff, 0, a, left1, right2 + 1 - left1);
        }
    }

    // 배열 a의 일부를 병합 정렬하는 __mergeSort 메소드
    static void __mergeSort(int[] a, int left1, int right1) {
        if (left1 < right1) {
            int center = (left1 + right1) / 2; // 중간 지점 계산

            // 배열의 앞부분을 병합 정렬
            __mergeSort(a, left1, center);
            // 배열의 뒷부분을 병합 정렬
            __mergeSort(a, center + 1, right1);

            // 두 개의 부분 배열을 병합
            merge(a, left1, center, center + 1, right1);
        }
    }

    // 배열 a를 병합 정렬하는 mergeSort 메소드
    static void mergeSort(int[] a, int n) {
        buff = new int[n]; // 작업용 배열 생성

        // 배열 전체를 병합 정렬
        __mergeSort(a, 0, n - 1);

        buff = null; // 작업용 배열 해제
    }

    // 메인 메소드
    public static void main(String[] args) {
        // 정렬할 배열 선언 및 초기화
        int[] a = {2, 4, 6, 8, 11, 13, 1, 2, 3, 4, 9, 16, 21};

        // 배열을 병합 정렬
        mergeSort(a, a.length);

        // 정렬된 배열 출력
        System.out.println("배열 a 정렬 후:");
        for (int num : a) {
            System.out.print(num + " ");
        }
    }
}

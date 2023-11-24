package chap3_searchingAlgorithm;

import java.util.Arrays;

public class _6_0스트링배열이진탐색 {

	// 데이터를 출력하는 함수
	static void showData(String[] data) {
		for (String d : data) {
			System.out.print(d + "/");
		}
		System.out.println();
	}

	// 데이터를 정렬하는 함수
	static void sortData(String[] data) {
		for (int i = 0; i < data.length - 1; i++) {
			for (int j = i + 1; j < data.length; j++) {
				if (data[i].compareTo(data[j]) > 0) {
					swap(data, i, j);
				}
			}
		}
	}

	// 데이터의 위치를 바꾸는 함수
	private static void swap(String[] data, int i, int j) {
		String temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	// 선형 탐색을 수행하는 함수
	private static int linearSearch(String[] data, String key) {
		for (int i = 0; i < data.length; i++)
			if (data[i].equals(key))
				return i; // 키를 찾으면 인덱스 반환
		return -1; // 키를 찾지 못하면 -1 반환
	}

	// 이진 탐색을 수행하는 함수
	private static int binarySearch(String[] data, String key) {
		int left = 0;
		int right = data.length - 1;
		do {
			int center = (left + right) / 2;
			if (data[center].equals(key)) // 문자열 비교는 '==' 대신 'equals' 사용
				return center; // 키를 찾으면 인덱스 반환
			else if (data[center].compareTo(key) < 0)
				left = center + 1; // 키가 중앙값보다 크면 왼쪽 범위를 줄임
			else
				right = center - 1; // 키가 중앙값보다 작으면 오른쪽 범위를 줄임

		} while (left <= right);
		return -1; // 키를 찾지 못하면 -1 반환
	}

	public static void main(String[] args) {
		String[] data = { "apple", "grape", "persimmon", "감", "배", "사과", "포도", "pear", "blueberry", "strawberry", "melon", "oriental melon" };

		showData(data);
		sortData(data);
		showData(data);

		String key = "감";
		int result = linearSearch(data, key); // 선형 탐색 수행
		System.out.println("\nlinearSearch(): result = " + result);
		if (result < 0)
			System.out.println("그 값의 요소가 없습니다");
		else
			System.out.println("'" + key + "'은(는) " + result + "번에 있습니다.");

		key = "배";
		result = binarySearch(data, key); // 이진 탐색 수행
		System.out.println("\nbinarySearch(): result = " + result);
		if (result < 0)
			System.out.println("그 값의 요소가 없습니다");
		else
			System.out.println("'" + key + "'은(는) " + result + "번에 있습니다.");

		int idx = Arrays.binarySearch(data, key); // Java 라이브러리를 사용한 이진 탐색
		System.out.println("\nArrays.binarySearch(): result = " + idx); // 결과 출력
		if (idx < 0)
			System.out.println("그 값의 요소가 없습니다");
		else
			System.out.println("'" + key + "'은(는) " + idx + "번에 있습니다.");
	}
}

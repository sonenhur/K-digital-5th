package chap3_searchingAlgorithm;

import java.util.Arrays;

//5번 실습 - 2장 실습 2-14를 수정하여 객체 배열의 정렬 구현
class PhyscData implements Comparable<PhyscData> {
	String name;
	int height;
	double vision;

	PhyscData(String name, int height, double vision) {
		this.name = name;
		this.height = height;
		this.vision = vision;
	}

	@Override
	public int compareTo(PhyscData o) {
		int nameCompare = this.name.compareTo(o.name); // 이름으로 비교
		if (nameCompare != 0) {
			return nameCompare;
		}

		int heightCompare = Integer.compare(this.height, o.height); // 키로 비교
		if (heightCompare != 0) {

			return heightCompare;
		}
		return Double.compare(this.vision, o.vision); // 시력으로 비교
	}
}

public class _6_1객체배열이진탐색 {
	private static void showData(PhyscData[] data) {
		for (PhyscData d : data) {
			System.out.print(d.name + ":" + d.height + "," + d.vision + " / ");
		}
		System.out.println();
	}

	private static void sortData(PhyscData[] data) {
		for (int i = 0; i < data.length - 1; i++) {
			for (int j = i + 1; j < data.length; j++) {
				if (data[i].compareTo(data[j]) > 0) {
					swap(data, i, j); // 데이터의 위치를 바꾸는 함수 호출
				}
			}
		}
	}

	private static void swap(PhyscData[] data, int i, int j) {
		PhyscData temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	private static int linearSearch(PhyscData[] data, PhyscData key) {
		for (int i = 0; i < data.length; i++)
			if (data[i].compareTo(key) == 0)
				return i; // 키를 찾으면 인덱스 반환
		return -1; // 키를 찾지 못하면 -1 반환
	}

	private static int binarySearch(PhyscData[] data, PhyscData key) {
		int left = 0;
		int right = data.length - 1;
		do {
			int center = (left + right) / 2;
			if (data[center].compareTo(key) == 0)
				return center; // 키를 찾으면 인덱스 반환
			else if (data[center].compareTo(key) < 0)
				left = center + 1; // 키가 중앙값보다 크면 왼쪽 범위를 줄임
			else
				right = center - 1; // 키가 중앙값보다 작으면 오른쪽 범위를 줄임

		} while (left <= right);
		return -1; // 키를 찾지 못하면 -1 반환
	}

	public static void main(String[] args) {
		PhyscData[] data = {
				new PhyscData("홍길동", 162, 0.3),
				new PhyscData("홍동", 164, 1.3),
				new PhyscData("홍길", 152, 0.7),
				new PhyscData("김홍길동", 172, 0.3),
				new PhyscData("길동", 182, 0.6),
				new PhyscData("길동", 167, 0.2),
				new PhyscData("길동", 167, 0.5),
				};
		
		showData(data);
		sortData(data);
		showData(data);

		PhyscData key = new PhyscData("길동", 167, 0.2);
		int result = linearSearch(data, key); // 선형 탐색 수행
		System.out.println("\nlinearSearch(): result = " + result);
		if (result < 0)
			System.out.println("그 값의 요소가 없습니다");
		else
			System.out.println("'" + key.name + "'의 위치는 " + result + "(+1)번입니다.");

		key = new PhyscData("길동", 167, 0.5);
		result = binarySearch(data, key); // 이진 탐색 수행
		System.out.println("\nbinarySearch(): result = " + result);
		if (result < 0)
			System.out.println("그 값의 요소가 없습니다");
		else
			System.out.println("'" + key.name + "'의 위치는 " + result + "(+1)번입니다.");

		int idx = Arrays.binarySearch(data, key); // Java 라이브러리를 사용한 이진 탐색
		System.out.println("\nArrays.binarySearch(): result = " + idx); // 결과 출력
		if (idx < 0)
			System.out.println("그 값의 요소가 없습니다");
		else
			System.out.println("'" + key.name + "'의 위치는 " + result + "(+1)번입니다.");
	}
}

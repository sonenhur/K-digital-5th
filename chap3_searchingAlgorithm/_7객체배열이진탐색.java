package chap3_searchingAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

class Fruit3 {
	String name;
	int price;
	String expire;

	public Fruit3(String name, int price, String expire) {
		this.name = name;
		this.price = price;
		this.expire = expire;
	}

	@Override
	public String toString() {
		return "<" + name + ", " + price + ", " + expire + ">";
	}

	public int getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}
}

class FruitNameComparator implements Comparator<Fruit3> {
	public int compare(Fruit3 f1, Fruit3 f2) {
		return f1.getName().compareTo(f2.getName()); // 이름으로 비교
	}
}

public class _7객체배열이진탐색 {
	private static void sortData(Fruit3[] arr, Comparator<Fruit3> cc_price) {
		Arrays.sort(arr, cc_price); // 가격으로 정렬
	}

	static void swap(Fruit3[] arr, int ind1, int ind2) {
		Fruit3 temp = arr[ind1];
		arr[ind1] = arr[ind2];
		arr[ind2] = temp; // 위치 바꾸기
	}

	static void sortData(Fruit3[] arr, FruitNameComparator cc) {
		Arrays.sort(arr, cc); // 이름으로 정렬
	}

	static void showData(Fruit3[] arr) {
		System.out.println();
		for (Fruit3 fx : arr) {
			System.out.print(fx + " ");
		}
		System.out.println();
	}

	// 교재 111 페이지 참조하여 구현
	static int binarySearch(Fruit3[] a, Fruit3 f, Comparator<Fruit3> cc) {
		int left = 0;
		int right = a.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			int cmp = cc.compare(a[mid], f);
			if (cmp < 0) {
				left = mid + 1;
			} else if (cmp > 0) {
				right = mid - 1;
			} else {
				return mid; // 키를 찾으면 인덱스 반환
			}
		}
		return -1; // 키를 찾지 못하면 -1 반환
	}

	public static void main(String[] args) {

		Fruit3[] arr = {
				new Fruit3("사과", 200, "2023-5-8"),
				new Fruit3("키위", 500, "2023-6-8"),
				new Fruit3("오렌지", 200, "2023-7-8"),
				new Fruit3("바나나", 50, "2023-5-18"),
				new Fruit3("수박", 880, "2023-5-28"),
				new Fruit3("체리", 10, "2023-9-8")
				};
		
		System.out.println("\n정렬전 객체 배열: ");
		showData(arr); // 데이터 출력
		FruitNameComparator cc = new FruitNameComparator();
		Arrays.sort(arr, cc); // 이름으로 정렬
		sortData(arr, cc); // 이름으로 정렬
		showData(arr); // 정렬된 데이터 출력

		Arrays.sort(arr, (a, b) -> a.getPrice() - b.getPrice()); // 가격으로 정렬
		System.out.println("\n람다식 정렬(가격)후 객체 배열: ");
		showData(arr); // 정렬된 데이터 출력

		Arrays.sort(arr, new Comparator<Fruit3>() {
			@Override
			public int compare(Fruit3 a1, Fruit3 a2) {
				return a1.getName().compareTo(a2.getName()); // 이름으로 비교
			}
		});
		System.out.println("\ncomparator 정렬(이름)후 객체 배열: ");
		showData(arr); // 정렬된 데이터 출력

		Comparator<Fruit3> cc_name = new Comparator<Fruit3>() {// 익명클래스 사용
			@Override
			public int compare(Fruit3 a1, Fruit3 a2) {
				return a1.getName().compareTo(a2.getName()); // 이름으로 비교
			}
		};
		Comparator<Fruit3> cc_price = new Comparator<Fruit3>() {
			@Override
			public int compare(Fruit3 a1, Fruit3 a2) {
				return a1.getPrice() - a2.getPrice(); // 가격으로 비교
			}
		};

		Fruit3 newFruit3 = new Fruit3("체리", 500, "2023-5-18");
		int result3 = Arrays.binarySearch(arr, newFruit3, cc_name); // 이름으로 이진 탐색
		System.out.println("\nArrays.binarySearch() 조회결과: " + result3);
		result3 = binarySearch(arr, newFruit3, cc_name); // 이름으로 이진 탐색
		System.out.println("\nbinarySearch() 조회결과: " + result3);

		sortData(arr, cc_price); // 가격으로 정렬
		System.out.println("\ncomparator 정렬(가격)후 객체 배열: ");
		showData(arr); // 정렬된 데이터 출력
		result3 = Arrays.binarySearch(arr, newFruit3, cc_price); // 가격으로 이진 탐색
		System.out.println("\nArrays.binarySearch() 조회결과: " + result3);
		result3 = binarySearch(arr, newFruit3, cc_price); // 가격으로 이진 탐색
		System.out.println("\nbinarySearch() 조회결과: " + result3);
	}
}

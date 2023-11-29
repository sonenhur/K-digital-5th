package chap2_dataStructure;

public class 스트링배열정렬 {

	// 버블 정렬을 이용하여 데이터를 정렬하는 메소드
	static void sortData(String[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i].compareTo(arr[j]) > 0) {
					swap(arr, i, j);
				}
			}
		}
	}

	// 배열의 두 요소의 위치를 바꾸는 메소드
	static void swap(String[] arr, int ind1, int ind2) {
		String temp = arr[ind1];
		arr[ind1] = arr[ind2];
		arr[ind2] = temp;
	}

	// 배열의 데이터를 출력하는 메소드
	static void showData(String[] arr) {
		for (String str : arr) {
			System.out.print(str + " / ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		String[] data = { "apple", "grape", "persimmon", "pear", "blueberry", "strawberry", "melon", "oriental melon" };
		showData(data); // 데이터 출력
		sortData(data); // 데이터 정렬
		showData(data); // 정렬된 데이터 출력
	}
}

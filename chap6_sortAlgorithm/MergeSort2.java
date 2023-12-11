package chap6_sortAlgorithm;

public class MergeSort2 {
	static int[] buff; // 작업용 배열

	// a[left1]~a[right2]를 병합정렬
	static void merge(int[] a, int left1, int right1, int left2, int right2) {
		buff = new int[right1 - left1 + 1];
		int p = 0;
		for (int i = left1; i <= right1; i++) {
			buff[i - left1] = a[i];
		}
		int j = 0, k = left2;
		while (j <= right1 - left1 && k <= right2) {
			buff[j++] = (buff[j] <= a[k]) ? buff[j] : a[k];
		}

		while (k <= right2) {
			a[k++] = buff[j++];
		}

	}

	static void __mergeSort(int[] a, int left1, int right1) {
		if (left1 < right1) {
			int center = (left1 + right1) / 2;

			__mergeSort(a, left1, center); // 배열의 앞부분을 병합정렬
			__mergeSort(a, center + 1, right1); // 배열의 뒷부분을 병합정렬

			merge(a, left1, center, center + 1, right1);
		}
	}

	// 병합 정렬
	static void mergeSort(int[] a, int n) {
		buff = new int[n]; // 작업용 배열 생성

		__mergeSort(a, 0, n - 1); // 배열 전체를 병합정렬

		buff = null; // 작업용 배열을 해제
	}

	public static void main(String[] args) {
		int[] a = { 2, 4, 6, 8, 11, 13, 1, 2, 3, 4, 9, 16, 21 };

		System.out.println("두 개의 배열을 병합");

		mergeSort(a, a.length);

		System.out.println("배열 a 정렬 후:");
		for (int num : a) {
			System.out.print(num + " ");
		}
	}
}
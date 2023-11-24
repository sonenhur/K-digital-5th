package chap3_searchingAlgorithm;

//3장 - 1번 실습 과제 > 2번 실습: 스트링 객체의 정렬과 이진 탐색 > 3번 실습: 객체 정렬과 이진 탐색
//comparator 구현 실습
import java.util.Arrays;
import java.util.Random;
public class _4정수배열이진탐색 {

	public static void main(String[] args) {
		int []data = new int[10];
		inputData(data);
		showData(data);
		sortData(data);
		System.out.println();
		for (int num: data) {
			System.out.print(num+" ");
		}
		int key = 33;
		int result = linearSearch(data, key);
		System.out.println("\nlinearSearch(): result = " + result);

		key = 39;
		result = binarySearch(data, key);
		System.out.println("\nbinarySearch(): result = " + result);
		int idx = Arrays.binarySearch(data, key);
		System.out.println("\nArrays.binarySearch(): result = " + result);

	}


	private static void inputData(int[] data) {
		Random rand = new Random();
		for (int i=0; i<data.length;i++)
			data[i]=rand.nextInt(100);
		}
	private static void showData(int[] data) {
		for (int d : data) {
			System.out.print(d + " ");
		}
		System.out.println();
	}
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

	private static int binarySearch(int[] data, int key) {
		int left = 0;
		int right = data.length - 1;
		do {
			int center = (left + right) / 2;
			if (data[center] == key)
				return center;
			else if (data[center] < key)
				left = center + 1;
			else
				right = center - 1;

		} while (left <= right);

		return -1;
	}

	private static int linearSearch(int[] data, int key) {
		for (int i = 0; i < data.length; i++)
			if (data[i] == key)
				return i;
		return -1;	}

}

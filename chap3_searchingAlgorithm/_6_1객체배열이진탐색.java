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
	    int nameCompare = this.name.compareTo(o.name);
	    if (nameCompare != 0) {
	        return nameCompare;
	    }

	    int heightCompare = Integer.compare(this.height, o.height);
	    if (heightCompare != 0) {

	        return heightCompare;
	    }
	    return Double.compare(this.vision, o.vision);
	}
}
	
public class _6_1객체배열이진탐색 {

	public static void main(String[] args) {
		PhyscData[] data = {
				new PhyscData("홍길동", 162, 0.3),
				new PhyscData("홍동", 164, 1.3),
				new PhyscData("홍길", 152, 0.7),
				new PhyscData("김홍길동", 172, 0.3),
				new PhyscData("길동", 182, 0.6),
				new PhyscData("길동", 167, 0.2),
				new PhyscData("길동", 167, 0.5), };
		showData(data);
		sortData(data);
		showData(data);
		PhyscData key = new PhyscData("길동", 167, 0.2);
		int result = linearSearch(data, key);
		System.out.println("\nlinearSearch(): result = " + result);
		key = new PhyscData("길동", 167, 0.5);

		result = binarySearch(data, key);
		System.out.println("\nbinarySearch(): result = " + result);

		int idx = Arrays.binarySearch(data, key);
		System.out.println("\nArrays.binarySearch(): result = " + result);
	}

	private static int linearSearch(PhyscData[] data, PhyscData key) {
		for (int i = 0; i < data.length; i++)
			if (data[i].compareTo(key)==0)
				return i;
		return -1;
	}

	private static int binarySearch(PhyscData[] data, PhyscData key) {
		int left = 0;
		int right = data.length - 1;
		do {
			int center = (left + right) / 2;
			if (data[center].compareTo(key)==0)
				return center;
			else if (data[center].compareTo(key) < 0)
				left = center + 1;
			else
				right = center - 1;

		} while (left <= right);

		return -1;
	}

	private static void sortData(PhyscData[] data) {
		for (int i = 0; i < data.length - 1; i++) {
			for (int j = i + 1; j < data.length; j++) {
				if (data[i].compareTo(data[j]) > 0) {
					swap(data, i, j);
				}
			}
		}
	}

	private static void swap(PhyscData[] data, int i, int j) {
		PhyscData temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	private static void showData(PhyscData[] data) {
		for (PhyscData d : data) {
			System.out.print(d.name + ":" + d.height + "," + d.vision + " / ");
		}
		System.out.println();
	}
}
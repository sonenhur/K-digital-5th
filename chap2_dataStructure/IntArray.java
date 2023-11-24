package chap2_dataStructure;

import java.util.Random;
import java.util.Scanner;

public class IntArray {
	// 배열을 정렬하는 메소드
	static void sort(int[] a) {
		for (int i = 0; i < a.length; i++)
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] > a[j]) {
					int temp;
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
	}

	// 배열의 최대값을 찾는 메소드
	static int maxOf(int[] a) {
		int max = a[0];
		for (int i = 1; i < a.length; i++)
			if (a[i] > max)
				max = a[i];
		return max;
	}

	public static void main(String[] args) {
		Random rand = new Random(); // 랜덤 객체 생성
		Scanner stdIn = new Scanner(System.in); // 스캐너 객체 생성
		System.out.print("배열 수: ");
		int num = stdIn.nextInt(); // 사용자로부터 배열의 크기를 입력받음
		int[] a = new int[num]; // 입력받은 크기의 배열 생성
		for (int i = 0; i < num; i++) {
			a[i] = rand.nextInt(100); // 배열에 랜덤한 정수를 채움
		}
		sort(a); // 배열을 정렬
		for (int n : a)
			System.out.print(n + " "); // 정렬된 배열을 출력
	}
}

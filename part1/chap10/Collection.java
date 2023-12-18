package part1.chap10;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Collection {

	public static void main(String[] args) {

		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int sum = 0;
		int average = 0;

		// 정수형 값을 담을 리스트 참조변수 생성
		List<Integer> list = new ArrayList<Integer>();

		// 리스트에 100개의 정수를 랜덤으로 저장
		Random random = new Random();
		for (int i = 0; i < 100; i++) {
			list.add(random.nextInt(101));
		}
		// 100개의 정수값을 읽으면서 최대, 최소, 평균, 합계 계산

		for (int i = 0; i < list.size(); i++) {
			max = (max < list.get(i)) ? list.get(i) : max;
			min = (min > list.get(i)) ? list.get(i) : min;
//			if (max < list.get(i))
//				max = list.get(i);
//			if (min > list.get(i))
//				min = list.get(i);
			sum += list.get(1);
		}
		average = sum / list.size();
		// 계산한 값을 출력
		// 합계

		System.out.println("리스트: " + list);
		System.out.println("평균: " + average);
		System.out.println("합계: " + sum);
		System.out.println("최댓값: " + max);
		System.out.println("최솟값: " + min);
	}
}
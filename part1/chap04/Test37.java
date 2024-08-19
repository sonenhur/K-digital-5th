package part1.chap04;

public class Test37 {
//	public static void main(String[] args) {
//		int[] score = {90, 85, 78, 100, 98};
//		int sum = 0; // 총점
//		double avg = 0.0; // 평균
//		int max = 0; // 최댓값
//		int min = 999; // 최솟값
//
//		for (int i = 0; i < score.length; i++) {
//			sum += score[i];
//			if (max < score[i])
//				max = score[i];
//			if (min > score[i])
//				min = score[i];
//		}
//		avg = sum / score.length;
//		System.out.println("총 점 : " + sum);
//		System.out.println("평 균 : " + avg);
//		System.out.println("최댓값 : " + max);
//		System.out.println("최솟값 : " + min);
//	}
    public static void main(String[] args) {
        int[] score = {90, 85, 78, 100, 98};
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < score.length; i++) {
            sum += score[i];
            if (score[i] > max) max = score[i];
            if (score[i] < min) min = score[i];
        }
        double avg = sum / score.length;
        System.out.println("총 점 : " + sum);
        System.out.println("평 균 : " + avg);
        System.out.println("최댓값 : " + max);
        System.out.println("최솟값 : " + min);
    }
}

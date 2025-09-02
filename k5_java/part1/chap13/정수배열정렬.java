package part1.chap13;

import java.util.Arrays;
import java.util.Random;

public class 정수배열정렬 {
    public static void main(String[] args) {
        int[] data = new int[20]; // 20칸짜리 배열 생성
        Random rnd = new Random();// 난수 생성
        for (int i = 0; i < data.length; i++)
            data[i] = rnd.nextInt(100); // 내용물 i는 100까지의 정수
        Arrays.sort(data); // (괄호)안의 값을 정렬 (기본은 오름차순)
        for (int i = 0; i < data.length; i++)
            System.out.print(data[i] + " ");
    }
}
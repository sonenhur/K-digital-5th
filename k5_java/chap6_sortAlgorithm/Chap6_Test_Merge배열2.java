/*
 * package chap6_sortAlgorithm;
 *
 * //정렬을 완료한 배열의 병합 import java.util.Scanner;
 *
 * class Chap6_Test_Merge배열2 { //--- 배열 a에 정렬한 결과를 return ---// static void
 * merge(int[] a, int left1, int right1, int left2, int right2) {
 * //{2,4,6,8,11,13}과 {1,3,5,7,9,16,21}을 합병하여 정렬 결과를 만드는 코드를 작성 }
 *
 * static void showData(int[] d) { System.out.println(); for (int i = 0; i <
 * d.length; i++) System.out.print(d[i] + " "); System.out.println(); }
 *
 * public static void main(String[] args) { Scanner stdIn = new
 * Scanner(System.in); int[] a = { 2, 4, 6, 8, 11, 13, 1, 3, 5, 7, 9, 16, 21 };
 *
 * System.out.println("배열 a: "); showData(a); merge(a, 0, 5, 6, 12);
 *
 * System.out.println(); System.out.println("합병후: "); showData(a);
 *
 * } }
 */
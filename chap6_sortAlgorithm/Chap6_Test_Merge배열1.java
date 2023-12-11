/*
 * package chap6_sortAlgorithm;
 * 
 * class MergeSort { static int[] buff; // 작업용 배열
 * 
 * // a[left1]~a[right2]를 재귀적으로 병합정렬 static void __mergeSort(int[] a, int left1,
 * int right1, int left2, int right2) { if (left1 < right2) { int center =
 * (left1 + right2) / 2; int p = 0; int i = left1; int j = left2; int k = left1;
 * 
 * __mergeSort(a, left1, center, left2, right1); // 배열의 앞부분을 병합정렬 __mergeSort(a,
 * center + 1, right1, right1 + 1, right2); // 배열의 뒷부분을 병합정렬
 * 
 * while (i <= center && j <= right2) { buff[p++] = (a[i] <= a[j]) ? a[i++] :
 * a[j++]; }
 * 
 * while (i <= center) { buff[p++] = a[i++]; }
 * 
 * while (j <= right2) { buff[p++] = a[j++]; }
 * 
 * for (i = 0; i < p; i++) { a[k++] = buff[i]; } } }
 * 
 * // 병합 정렬 static void mergeSort(int[] a, int n) { buff = new int[n]; // 작업용 배열
 * 생성
 * 
 * __mergeSort(a, 0, n - 1, 0, n - 1); // 배열 전체를 병합정렬
 * 
 * buff = null; // 작업용 배열을 해제 }
 * 
 * public static class Chap6_Test_Merge배열1 { public static void main(String[]
 * args) { int[] a = {2, 4, 6, 8, 11, 13, 1, 2, 3, 4, 9, 16, 21};
 * 
 * System.out.println("두 개의 배열을 병합");
 * 
 * mergeSort(a, a.length);
 * 
 * System.out.println("배열 a 정렬 후:"); for (int num : a) { System.out.print(num +
 * " "); } } } }
 */
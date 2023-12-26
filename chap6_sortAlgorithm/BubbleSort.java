package chap6_sortAlgorithm;
<<<<<<< HEAD

import java.util.Scanner;

=======
>>>>>>> e3ddfa489db8c865c3c305805bdd3e85bac65d6e

import java.util.Scanner;

<<<<<<< HEAD
        static void bubbleSort(int[] a, int n) {
            for (int i = 0; i < n - 1; i++) {
                for (int j = n - 1; j > i; j--) {
                    if (a[j - 1] > a[j])
                        swap(a, j - 1, j);
                }
=======
class BubbleSort {
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void bubbleSort(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = n - 1; j > i; j--) {
                if (a[j - 1] > a[j])
                    swap(a, j - 1, j);
>>>>>>> e3ddfa489db8c865c3c305805bdd3e85bac65d6e
            }
        }
    }

<<<<<<< HEAD
        public static void main(String[] args) {
            try (Scanner stdIn = new Scanner(System.in)) {
				System.out.println("버블 정렬(버전1)");
				System.out.println("요솟수: ");
				int nx = stdIn.nextInt();
				int[] x = new int[nx];

				for (int i = 0; i < nx; i++) {
				    System.out.println("x[" + i + "]: ");
				    x[i] = stdIn.nextInt();
				}
=======
    public static void main(String[] args) {
        try (Scanner stdIn = new Scanner(System.in)) {
            System.out.println("버블 정렬(버전1)");
            System.out.println("요솟수: ");
            int nx = stdIn.nextInt();
            int[] x = new int[nx];
>>>>>>> e3ddfa489db8c865c3c305805bdd3e85bac65d6e

				bubbleSort(x, nx);

				System.out.println("오름차순 정렬");
				for (int i = 0; i < nx; i++) {
				    System.out.println("x[" + i + "]=" + x[i]);
				}
			}
        }
    }

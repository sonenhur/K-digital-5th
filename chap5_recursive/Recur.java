package chap5_recursive;

// 재귀에 대한 이해를 돕는 순수 재귀 메서드

import java.util.Scanner;

class Recur {
	// --- 순수 재귀 메서드 ---//
	static void recur(int n) {
		if (n > 0) {
			recur(n - 1);
			System.out.println(n);
			recur(n - 2);
		}
	}
// 								recur(3)			  sysout(4) 			recur(2)
// 						recur(2) sysout(3) recur(1) 	 ||			recur(1) sysout(2) recur(0)
// 			recur(1) sysout(2) recur(0)	(r0sys1r-1)	 	 ||	recur(0) sysout(1) recur(-1)
// recur(0) sysout(1) recur(-1)					
//												***recur(0)과 recur(-1)에서는 아무 일도 일어나지 않음***
	
	public static void main(String[] args) {
		try (Scanner stdIn = new Scanner(System.in)) {
			System.out.print("정수를 입력하세요 : ");
			int x = stdIn.nextInt();

			recur(x);
		}
	}
}

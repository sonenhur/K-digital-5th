package part1.chap02;

public class Test003 {

    public static void main(String[] args) {
//		int A1 = 10;
//		int A2 = -A1;
//		// A1++; // A1 = A1+1
//		A2 += 10; // A2 = A2 +10; 과 같음
//		int A3 = A1++ + A2++;
//		System.out.println(A3);
//		System.out.println("A1 = " + A1 + ", A2 = " + A2);
//		System.out.println(A1 == A2); // 논리연산자
//		char gender = 'M';
//		int balance = 100;
//		System.out.println(gender != 'F' & balance++ > 10);
//		System.out.println(gender != 'F' && balance++ > 10);
//		System.out.println(!(gender != 'F') || balance++ > 10);
        int A1 = 10;
        int A2 = -A1;
        A2 += 10;
        int A3 = A1++ + A2++;
        System.out.println(A3);
        System.out.println("A1 = " + A1 + ",A2 = " + A2);
        System.out.println(A1 == A2); // 논리연산자
        char gender = 'M';
        int balance = 100;
        System.out.println(gender != 'F' & balance++ > 10);
        System.out.println(gender != 'F' && balance++ > 10);
        System.out.println(!(gender != 'F') || balance++ >10);
        System.out.println(balance);
    }

}

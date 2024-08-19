package part1.chap09_api;

public class Test02 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String s1 = new String("java");
        String s2 = "java";
        String s3 = new String("java");
        String s4 = "java";
        String s5 = "JAVA";
        if (s1.equals(s4)) {
            System.out.println("동일 객체");
        } else {
            System.out.println("다른 객체");
        }
        if (s1.equals(s5)) {
            System.out.println("동일 객체");
        } else {
            System.out.println("다른 객체");
        }
//		if (s1 == s3) {
//			System.out.println("동일 객체");
//		} else {
//			System.out.println("다른 객체");
//		}
//		if (s2 == s4) {
//			System.out.println("동일 객체");
//		} else {
//			System.out.println("다른 객체");
//		}
//		if (s1 == s2) {
//			System.out.println("동일 객체");
//		} else {
//			System.out.println("다른 객체");
//		}
    }
}

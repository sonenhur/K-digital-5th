package part1.chap09_api;

public class Test12 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n1 = 10;
        Integer obj1 = n1;// (오토)박싱
        Integer obj2 = Integer.valueOf(20);
        int n2 = obj2; // (오토)언박싱
        Integer obj3 = 30;
        int n3 = obj3 + 40;
        System.out.println(n1 + ":" + obj1);
        System.out.println(obj2 + ":" + n2);
        System.out.println(n3);

        int i3 = Integer.parseInt("123");
        // 입력받은 문자(스트링) 숫자를 정수형으로
        String s1 = "9";
        int ns1 = Integer.parseInt(s1);
        String s2 = "21";
        int ns2 = Integer.parseInt(s2);
//		if (ns1.compareTo(ns2) < 0) {
//			System.out.println("9 < 21");
//		} else {
//			System.out.println("9 > 21");
//		}
    }
}

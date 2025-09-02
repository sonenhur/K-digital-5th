package part1.chap09_api;

import java.util.StringTokenizer;

public class Test14 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String msg = "Although the world is full of suffering, it is full also of the overcoming of it.";
        StringTokenizer st1 = new StringTokenizer(msg);
        System.out.println("단어 수 :" + st1.countTokens());
        while (st1.hasMoreTokens()) {
            System.out.println("남아있는 토큰 수 : " + st1.countTokens());
            System.out.println(st1.nextToken());
            System.out.println("========================");
//			String s = "id=guest&name=Amy&pwd=1004";
//			StringTokenizer st2 = new StringTokenizer(s, "&");
//			while (st2.hasMoreTokens()) {
//				System.out.println("남아있는 토큰 수 : " + st2.countTokens());
//				System.out.println(st2.nextToken());
//
//				System.out.println("========================");
//				StringTokenizer st3 = new StringTokenizer(s, "=&");
//				while (st3.hasMoreTokens()) {
//					System.out.println(st3.nextToken());
//				}
//			}
        }
    }
}
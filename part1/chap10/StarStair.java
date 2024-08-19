package part1.chap10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StarStair {

    public static void main(String[] args) {
        // Scanner 객체를 생성해서 반복값을 입력받음
        Scanner sc = new Scanner(System.in);
        System.out.print("반복 횟수: ");
        int repeat = sc.nextInt();

        // 배열 객체(ArrayList) 생성
        List<String> stars = new ArrayList();

        // 문자열 생성은 repeat 횟수만큼 반복 (for 루프)
        for (int i = 1; i <= repeat; i++) {
            // 저장될 문장을 생성해서 ArrayList에 저장
            stars.add("*".repeat(i));
        }

        // 깐지나는 방법
//		for (int i = 1; i <= repeat; i++) {
//			StringBuffer s = new StringBuffer();
//			for (int j = 0; j < i; j++) {
//				s.append("*");
//			}
//			stars.add(s.toString());
//		}

        // ArrayList에 저장된 문자열을 출력
        for (int j = 0; j < stars.size(); j++) {
            System.out.println(stars.get(j));
        }
    }
}

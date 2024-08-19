package part1.chap10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test01 {

    public static void main(String[] args) {
        // 배열 추가 : 수정이 안돼서 새로 만들어서 옮겨담음

        // 컬렉션 프레임워크
        // ArrayList
        // HashMap

        // List<String> list = new ArrayList<String>();
        // <> 안에 임의의 타입 지정(String, int 등)
        // 현 버전에서는 뒷쪽 <>는 생략 가능
        // 앞에 List가 부모클래스, 추상클래스, 인터페이스
        // 따라서 뒤에 ArrayList를 사용 가능
//		ArrayList<String> list = new ArrayList<String>();
        List<String> list = new ArrayList();

        list.add("서울");
        list.add("북경");
        list.add("상해");
        list.add("서울");
        list.add("도쿄");
        list.add("뉴욕");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
//		==============================================
        list.forEach(s -> System.out.println("fe:" + s));
//		==============================================
        list.add("런던");
        list.add("로마");
        list.add("방콕");
        list.add("북경");
        list.add("도쿄");
        list.add("서울");
        System.out.println("1 : " + list.toString());

        // void add(int index, E element)
        list.add(1, "LA");
        // 1(2번자리)에 LA 입력
        print(2, list);

        System.out.println("3 : " + list.indexOf("서울"));
        // "서울" 자리 0번
        System.out.println("4 : " + list.lastIndexOf("서울"));
        // 끝에 있는 "서울" 자리? 12번

        list.remove("LA");
        print(5, list);
        list.remove(2);// 2번 자리('상해') 제거
        print(6, list);
        System.out.println("7 : " + list.contains("LA"));

        Object obj[] = list.toArray();
        System.out.println("8 : " + Arrays.toString(obj));

        String cities[] = new String[0];
        cities = list.toArray(cities);
        System.out.println("9 : " + Arrays.toString(cities));
        list.clear();
        print(10, list);
        System.out.println("11: " + list.isEmpty());

        list.add("파리");
        list.add("방콕");
        list.add("LA");

        List<String> list2 = Arrays.asList("서울", "뉴욕", "상해");
        print(12, list2);

        list.addAll(list2);
        print(13, list);
        System.out.println("14: " + list.containsAll(list2));

        list.retainAll(list2);
        print(15, list);
        list.removeAll(list2);
        print(16, list);
    }

    public static void print(int n, List<String> list) {
        System.out.println(n + " : " + list);
    }

}

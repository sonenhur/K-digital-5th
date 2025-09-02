package part1.chap09_api;

public class Test01 {

    public static void main(String[] args) {

        String s = new String("Kim");
        String s1 = new String("Hong");

        Object obj1 = new Object();
        System.out.println(obj1.hashCode());
        System.out.println(Integer.toHexString(obj1.hashCode()));
        Object obj2 = new Object();
        if (obj1.equals(obj2))
            System.out.println("같다");
        else
            System.out.println("다르다");
        if (obj1 == obj2)
            System.out.println("같다");
        else
            System.out.println("다르다");
        System.out.println(obj2.hashCode());
        Object obj3 = new Object();
        System.out.println(obj3.hashCode());
        System.out.println(obj1.getClass());
        System.out.println(obj2.getClass());
        System.out.println(obj3.getClass());
        System.out.println(obj1.toString());

        System.out.println(obj1);
        // println 함수는 String 파라미터가 와야함.
        // 안쓰면 toString()을 자동호출해서 실행함

        MyObject obj4 = new MyObject();
        System.out.println(obj4.toString());
//		if (s.compareTo(s1) < 0)
//// 		if (s < s1) : 문자열에는 < 연산자가 정의되지 않아서 사용할 수 없음
    }
}
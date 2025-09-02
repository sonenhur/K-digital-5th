package part1.chap14;

import java.util.stream.IntStream;

interface MyInterface {
    public void print();
}

class MyClass1 implements MyInterface {
    @Override
    public void print() {
        System.out.println("MyClass1의 객체");
    }
}

class MyClass2 implements MyInterface {
    @Override
    public void print() {
        System.out.println("MyClass2의 객체");
    }
}

public class Test01 {
    // 방법4: 함수 매개변수로 익명클래스 사용
    // 함수 매개변수의 타입이 인터페이스
    static void test(MyInterface mi) {
        System.out.println("함수에서 메소드 호출");
        mi.print();
    }

    static MyInterface test2() {
        MyInterface mi = new MyInterface() {
            @Override
            public void print() {
                System.out.println("메소드의 리턴값이 인터페이스 객체");
            }
        };
        return mi;
    }

    static MyInterface test3() {
        return new MyInterface() {
            @Override
            public void print() {
                System.out.println("hello");
            }
        };
    }

    public static void main(String[] args) {
        // 방법1 : implements 키워드로 클래스 선언
        MyClass1 mc1 = new MyClass1();
        MyClass2 mc2 = new MyClass2();
        mc1.print();
        mc2.print();

        // 방법2 : 익명클래스 사용
        MyInterface mi = new MyInterface() {
            @Override
            public void print() {
                System.out.println("익명클래스 사용");
            }
        };
        mi.print();

        // 방법3: 클래스선언, 객체생성, 메서드호출을 한번에 처리
        (new MyInterface() {
            @Override
            public void print() {
                System.out.println("선언,생성,호출을 한번에 처리");
            }
        }).print();

        // 방법4: 매개변수
        test(mc1);
        test(mi);

        // 방법5: 리턴타입
        MyInterface mi2 = test2();
        mi2.print();
        //일반 인터페이스 구현
        MyInterface m = test3();
        m.print();

        MyInterface m2 = () -> System.out.println("hello");
        m2.print();

        IntStream.range(0, 10).forEach((int value) -> System.out.println(value));

    }
}

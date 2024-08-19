package chap10_hash;

import java.util.Comparator;
import java.util.Scanner;

class SimpleObject5 {
    static final int NO = 1;
    static final int NAME = 2;
    String no; // 회원번호
    String name; // 이름

    // 데이터를 읽어 들이는 메서드
    void scanData(String guide, int sw) {
        Scanner sc = new Scanner(System.in);
        System.out.println(guide + "할 데이터를 입력하세요.");

        if ((sw & NO) == NO) {
            System.out.print("회원번호: ");
            no = sc.next();
        }
        if ((sw & NAME) == NAME) {
            System.out.print("이름: ");
            name = sc.next();
        }
    }
}

class ChainHash5 {
    private int size; // 해시 테이블의 크기
    private Node2[] table; // 해시 테이블
    // 생성자(constructor)
    public ChainHash5(int capacity) {
        try {
            table = new Node2[capacity];
            this.size = capacity;
            for (int i = 0; i < capacity; i++)
                table[i] = null;
        } catch (OutOfMemoryError e) {
            this.size = 0;
        }
    }

    // 키값이 key인 요소를 검색(데이터를 반환)
    public SimpleObject5 search(SimpleObject5 st, Comparator<? super SimpleObject5> c) {
        int hash = hashValue(st.no);
        Node2 p = table[hash];

        while (p != null) {
            if (c.compare(p.data, st) == 0) // 같은 키를 찾았다면
                return p.data;
            p = p.next;
        }
        return null; // 검색 실패
    }

    // 키값이 key인 데이터를 data의 요소로 추가
    public int add(SimpleObject5 st, Comparator<? super SimpleObject5> c) {
        int hash = hashValue(st.no);
        Node2 p = table[hash];

        while (p != null) {
            if (c.compare(p.data, st) == 0) // 이미 등록된 키값이 있다면
                return 1;
            p = p.next;
        }

        Node2 temp = new Node2(st, table[hash]);
        table[hash] = temp; // 노드 추가
        return 0;
    }

    // 키값이 key인 요소를 삭제
    public int delete(SimpleObject5 st, Comparator<? super SimpleObject5> c) {
        int hash = hashValue(st.no);
        Node2 p = table[hash];
        Node2 pre = null;

        while (p != null) {
            if (c.compare(p.data, st) == 0) { // 같은 키를 찾았다면
                if (pre == null)
                    table[hash] = p.next; // 첫 번째 노드일 경우
                else
                    pre.next = p.next;
                return 0;
            }
            pre = p;
            p = p.next;
        }
        return 1; // 삭제 실패
    }

    // 해시 테이블을 덤프(dump)
    public void dump() {
        for (int i = 0; i < size; i++) {
            Node2 p = table[i];
            System.out.printf("%02d  ", i);
            while (p != null) {
                System.out.printf("-> %s (%s)  ", p.data.no, p.data.name);
                p = p.next;
            }
            System.out.println();
        }
    }

    // 해시 값 구하기
    private int hashValue(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++)
            hash += key.charAt(i);
        return hash % size;
    }

    //--- 해시를 구성하는 노드 ---//
    static class Node2 {
        private final SimpleObject5 data; // 키값
        private Node2 next; // 뒤쪽 포인터(뒤쪽 노드에 대한 참조)

        // 생성자(constructor)
        Node2(SimpleObject5 data, Node2 next) {
            this.data = data;
            this.next = next;
        }
    }
}

public class 실습10_2객체체인해시 {
    // --- 메뉴 선택 ---//
    static Menu SelectMenu() {
        Scanner sc = new Scanner(System.in);
        int key;
        do {
            for (Menu m : Menu.values()) {
                System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
                if (m.ordinal() % 3 == 2)
                    System.out.println();
            }
            System.out.print(" : ");
            key = sc.nextInt();
        } while (key < Menu.Add.ordinal() || key > Menu.Exit.ordinal());
        return Menu.MenuAt(key);
    }

    public static void main(String[] args) {
        Menu menu;
        Scanner stdIn = new Scanner(System.in);
        ChainHash5 hash = new ChainHash5(15);
        SimpleObject5 data;
        int select = 0, result = 0;
        do {
            switch (menu = SelectMenu()) {
                case Add:
                    data = new SimpleObject5();
                    data.scanData("삽입", SimpleObject5.NO | SimpleObject5.NAME);
                    result = hash.add(data, Comparator.comparing((SimpleObject5 s) -> s.no));
                    if (result == 1)
                        System.out.println(" 중복 데이터가 존재한다");
                    else
                        System.out.println(" 입력 처리됨");
                    break;
                case Delete:
                    data = new SimpleObject5();
                    data.scanData("삭제", SimpleObject5.NO);
                    result = hash.delete(data, Comparator.comparing((SimpleObject5 s) -> s.no));
                    if (result == 1)
                        System.out.println(" 삭제 처리");
                    else
                        System.out.println(" 삭제 데이터가 없음");
                    break;
                case Search:
                    data = new SimpleObject5();
                    data.scanData("검색", SimpleObject5.NO);
                    SimpleObject5 found = hash.search(data, Comparator.comparing((SimpleObject5 s) -> s.no));
                    if (found != null)
                        System.out.println(" 검색 데이터가 존재한다");
                    else
                        System.out.println(" 검색 데이터가 없음");
                    break;
                case Show:
                    hash.dump();
                    break;
            }
        } while (menu != Menu.Exit);
    }

    enum Menu {
        Add("삽입"), Delete("삭제"), Search("검색"), Show("출력"), Exit("종료");

        private final String message; // 표시할 문자열

        Menu(String string) { // 생성자(constructor)
            message = string;
        }

        static Menu MenuAt(int idx) { // 순서가 idx번째인 열거를 반환
            for (Menu m : Menu.values())
                if (m.ordinal() == idx)
                    return m;
            return null;
        }

        String getMessage() { // 표시할 문자열을 반환
            return message;
        }
    }
}

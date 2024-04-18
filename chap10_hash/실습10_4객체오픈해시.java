package chap10_hash;

import java.util.Scanner;

class SimpleObject2 {
    static final int NO = 1;
    static final int NAME = 2;
    String sno; // 회원번호
    String sname; // 이름

    // 데이터를 입력받는 메서드
    void scanData(String guide, int sw) {
        Scanner sc = new Scanner(System.in);
        System.out.println(guide + "할 데이터를 입력하세요.");

        if ((sw & NO) == NO) {
            System.out.print("회원번호: ");
            sno = sc.next();
        }
        if ((sw & NAME) == NAME) {
            System.out.print("이름: ");
            sname = sc.next();
        }
    }

    // 회원번호를 반환하는 메서드
    String getKey() {
        return sno;
    }

    // 문자열을 반환하는 메서드
    public String toString() {
        return sname;
    }
}

class OpenHash {
    // --- 버킷의 상태 ---//
    enum Status {
        OCCUPIED, EMPTY, DELETED
    } // {데이터 저장, 비어있음, 삭제 완료}

    // --- 버킷 ---//
    static class Bucket {
        private SimpleObject2 data; // 데이터
        private Status stat; // 상태

        // 생성자
        Bucket() {
            stat = Status.EMPTY; // 버킷을 비어있는 상태로 초기화
        }
    }

    // 열거형 Menu 추가
    public enum Menu {
        ADD("추가"),
        REMOVE("삭제"),
        SEARCH("검색"),
        DUMP("표시"),
        TERMINATE("종료");

        private final String message;

        Menu(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        // 인덱스에 해당하는 메뉴 반환
        public static Menu MenuAt(int idx) {
            for (Menu m : Menu.values()) {
                if (m.ordinal() == idx) {
                    return m;
                }
            }
            return null;
        }
    }

    private int size; // 해시 테이블의 크기
    private Bucket[] table; // 해시 테이블

    // 생성자
    public OpenHash(int size) {
        try {
            table = new Bucket[size];
            for (int i = 0; i < size; i++)
                table[i] = new Bucket();
            this.size = size;
        } catch (OutOfMemoryError e) {
            this.size = 0;
        }
    }

    // 해시값을 구함
    public int hashValue(SimpleObject2 key) {
        return Integer.parseInt(key.getKey()) % size;
    }

    // 재해시값을 구함
    public int rehashValue(int hash) {
        return (hash + 1) % size;
    }

    // 키값 key를 갖는 버킷 검색
    private Bucket searchNode(SimpleObject2 key) {
        int hash = hashValue(key); // 해시값 구함
        Bucket p = table[hash]; // 버킷을 참조

        for (int i = 0; p.stat != Status.EMPTY && i < size; i++) {
            if (p.stat == Status.OCCUPIED && key.getKey().equals(p.data.getKey()))
                return p; // 검색 성공
            hash = rehashValue(hash); // 재해시
            p = table[hash];
        }
        return null; // 검색 실패
    }

    // 키값이 key인 요소를 검색(데이터를 반환)
    public SimpleObject2 search(SimpleObject2 key) {
        Bucket p = searchNode(key);
        if (p != null)
            return p.data;
        else
            return null;
    }

    // 키값이 key인 데이터를 data의 요소로 추가
    public int add(SimpleObject2 key) {
        if (search(key) != null)
            return 1; // 이미 등록된 키값

        int hash = hashValue(key); // 해시값
        Bucket p = table[hash]; // 버킷을 참조

        for (int i = 0; i < size; i++) {
            if (p.stat == Status.EMPTY || p.stat == Status.DELETED) {
                p.data = key; // 버킷에 데이터를 저장
                p.stat = Status.OCCUPIED; // 버킷의 상태를 저장으로 변경
                return 0; // 추가 완료
            }
            hash = rehashValue(hash); // 재해시
            p = table[hash];
        }
        return 2; // 해시 테이블이 가득 참
    }

    // 키값이 key인 요소를 삭제
    public int remove(SimpleObject2 key) {
        Bucket p = searchNode(key); // 버킷을 찾음
        if (p == null)
            return 1; // 이 키값은 등록되어 있지 않음

        p.stat = Status.DELETED; // 삭제 완료
        return 0;
    }

    // 해시 테이블을 덤프(dump)
    public void dump() {
        for (int i = 0; i < size; i++) {
            System.out.printf("%02d  ", i);
            switch (table[i].stat) {
                case OCCUPIED:
                    System.out.printf("%s (%s)\n", table[i].data.sno, table[i].data.sname);
                    break;
                case EMPTY:
                    System.out.println("미등록");
                    break;
                case DELETED:
                    System.out.println("삭제 완료");
                    break;
            }
        }
    }
}

public class 실습10_4객체오픈해시 {
    static Scanner stdIn = new Scanner(System.in);

    //--- 메뉴 선택 ---//
    static OpenHash.Menu SelectMenu() {
        int key;
        do {
            for (OpenHash.Menu m : OpenHash.Menu.values())
                System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
            System.out.print(" : ");
            key = stdIn.nextInt();
        } while (key < OpenHash.Menu.ADD.ordinal() || key > OpenHash.Menu.TERMINATE.ordinal());

        return OpenHash.Menu.MenuAt(key);
    }

    public static void main(String[] args) {
        OpenHash.Menu menu; // 메뉴
        SimpleObject2 temp; // 읽어 들일 데이터
        int result;
        OpenHash hash = new OpenHash(13);
        do {
            switch (menu = SelectMenu()) {
                case ADD: // 추가
                    temp = new SimpleObject2();
                    temp.scanData("추가", SimpleObject2.NO | SimpleObject2.NAME);
                    int k = hash.add(temp);
                    switch (k) {
                        case 1:
                            System.out.println("그 키값은 이미 등록되어 있습니다.");
                            break;
                        case 2:
                            System.out.println("해시 테이블이 가득 찼습니다.");
                            break;
                        case 0:
                            break;
                    }
                    break;

                case REMOVE: // 삭제
                    temp = new SimpleObject2();
                    temp.scanData("삭제", SimpleObject2.NO);
                    result = hash.remove(temp);
                    if (result == 0)
                        System.out.println(" 삭제 처리");
                    else
                        System.out.println(" 삭제 데이터가 없음");
                    break;

                case SEARCH: // 검색
                    temp = new SimpleObject2();
                    temp.scanData("검색", SimpleObject2.NO);
                    SimpleObject2 t = hash.search(temp);
                    if (t != null)
                        System.out.println("그 키를 갖는 데이터는 " + t + "입니다.");
                    else
                        System.out.println("해당 데이터가 없습니다.");
                    break;

                case DUMP: // 표시
                    hash.dump();
                    break;
            }
        } while (menu != OpenHash.Menu.TERMINATE);
    }
}

package chap4_stackAndQueue;

/*
 * 교재에 있는 소스코드
 * 입력하여 실행 실습
 * 정수형 스택 소스 코드
 */
import java.util.Scanner;

//정수형 고정 길이 스택을 구현한 클래스
class IntStack2 {
    private int[] stk; // 스택용 배열
    private int capacity; // 스택의 크기 (최대 몇 개를 쌓을 수 있는가?)
    private int ptr; // 스택 포인터 (쌓여있는 데이터 수)

    // 스택이 비어있을 때 발생하는 예외
    public class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException() {
        }
    }

    // 스택이 가득 찼을 때 발생하는 예외
    public class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException() {
        }
    }

    // 생성자: 스택의 크기를 받아 초기화
    public IntStack2(int maxlen) {
        ptr = 0;
        capacity = maxlen;
        try {
            stk = new int[capacity]; // 스택 본체용 배열을 생성
        } catch (Exception e) { // 생성할 수 없음
            capacity = 0;
        }
    }

    // 스택에 데이터를 푸시
    public int push(int x) throws OverflowIntStackException {
        if (ptr >= capacity) // 스택이 가득 참
            throw new OverflowIntStackException();
        return stk[ptr++] = x;
    }

    // 스택에서 데이터를 팝 (정상에 있는 데이터를 꺼냄)
    public int pop() throws EmptyIntStackException {
        if (ptr <= 0) // 스택이 비어있음
            throw new EmptyIntStackException();
        return stk[--ptr];
    }

    // 스택에서 데이터를 피크 (정상에 있는 데이터를 들여다봄)
    public int peek() throws EmptyIntStackException {
        if (ptr <= 0) // 스택이 비어있음
            throw new EmptyIntStackException();
        return stk[ptr - 1];
    }

    // 스택을 비움
    public void clear() {
        ptr = 0;
    }

    // 스택에서 x를 찾아 인덱스를 반환 (없으면 -1)
    public int indexOf(int x) {
        for (int i = ptr - 1; i >= 0; i--) // 꼭대기쪽부터 선형 검색
            if (stk[i] == x)
                return i; // 검색 성공
        return -1; // 검색 실패
    }

    // 스택의 크기를 반환
    public int getCapacity() {
        return capacity;
    }

    // 스택에 쌓여있는 데이터 갯수를 반환
    public int size() {
        return ptr;
    }

    // 스택이 비어있는가?
    public boolean isEmpty() {
        return ptr <= 0;
    }

    // 스택이 가득 찼는가?
    public boolean isFull() {
        return ptr >= capacity;
    }

    // 스택 안의 모든 데이터를 바닥 → 꼭대기 순서로 표시
    public void dump() {
        if (ptr <= 0)
            System.out.println("스택이 비어있습니다");
        else {
            for (int i = 0; i < ptr; i++)
                System.out.println(stk[i] + " ");
            System.out.println();
        }
    }
}

// 메인 클래스: 정수형 스택을 테스트하는 프로그램
public class _4_2_정수스택 {

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        IntStack2 s = new IntStack2(4); // 최대 4 개를 푸시할 수 있는 스택

        while (true) {
            System.out.println(); // 메뉴 구분을 위한 빈 행 추가
            System.out.printf("현재 데이터 개수: %d / %d\n", s.size(), s.getCapacity());
            System.out.print("(1)push　(2)pop　(3)peek　(4)dump　(0)종료: ");

            int menu = stdIn.nextInt();
            if (menu == 0)
                break;

            int x;
            switch (menu) {

                case 1: // 푸시
                    System.out.print("데이터: ");
                    x = stdIn.nextInt();
                    try {
                        s.push(x);
                    } catch (IntStack2.OverflowIntStackException e) {
                        System.out.println("스택이 가득 찼습니다.");
                    }
                    break;

                case 2: // 팝
                    try {
                        x = s.pop();
                        System.out.println("팝한 데이터는 " + x + "입니다.");
                    } catch (IntStack2.EmptyIntStackException e) {
                        System.out.println("스택이 비어있습니다.");
                    }
                    break;

                case 3: // 피크
                    try {
                        x = s.peek();
                        System.out.println("피크한 데이터는 " + x + "입니다.");
                    } catch (IntStack2.EmptyIntStackException e) {
                        System.out.println("스택이 비어있습니다.");
                    }
                    break;

                case 4: // 덤프
                    s.dump();
                    break;
            }
        }
    }
}
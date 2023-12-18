package chap4_stackAndQueue;

//4장 소스코드의 Point2 버젼을 학습한 후에 Queue 버젼을 구현한다.

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

//Point2 클래스: 2차원 좌표를 나타내는 클래스
class Point2 {
    private int ix; // x 좌표
    private int iy; // y 좌표

    // 생성자: x, y 좌표를 받아서 초기화
    public Point2(int x, int y) {
        ix = x;
        iy = y;
    }

    // 객체를 문자열로 표현하는 메서드
    @Override
    public String toString() {
        return "<" + ix + ", " + iy + ">";
    }

    // x 좌표를 반환하는 메서드
    public int getX() {
        return ix;
    }

    // y 좌표를 반환하는 메서드
    public int getY() {
        return iy;
    }

    // x 좌표를 설정하는 메서드
    public void setX(int x) {
        ix = x;
    }

    // y 좌표를 설정하는 메서드
    public void setY(int y) {
        iy = y;
    }

    // 두 점이 같은지 확인하는 메서드
    @Override
    public boolean equals(Object p) {
        if ((this.ix == ((Point2) p).ix) && (this.iy == ((Point2) p).iy))
            return true;
        else
            return false;
    }
}

// objectStack 클래스: Point2 객체를 push, pop하는 스택 구현
class objectStack {
    // 실행시 예외: 스택이 비어있음
    public class EmptyGenericStackException extends Exception {
        private static final long serialVersionUID = 1L;

        public EmptyGenericStackException() {
            super();
        }
    }

    // 실행시 예외: 스택이 가득 참
    public class OverflowGenericStackException extends RuntimeException {
        public OverflowGenericStackException() {
        }
    }

    private List<Point2> data; // 스택용 배열
    private int capacity; // 스택의 크기
    private int top; // 스택 포인터

    // 생성자: 스택의 크기를 받아서 초기화
    public objectStack(int capacity) {
        this.capacity = capacity;
        this.top = 0;
        this.data = new ArrayList<Point2>(capacity);
    }

    // 푸시: 스택에 x를 추가
    // push 메서드를 boolean으로 정의한 이유는 주로 스택에 데이터를 추가할 때, 스택이 가득 차 있는지 여부를 알고자 할 때
    // 사용됩니다.
    // push 메서드가 boolean을 반환함으로써, 데이터 추가가 성공적으로 이루어졌는지 여부를 알 수 있습니다.
    public boolean push(Point2 x) throws OverflowGenericStackException {
        if (top >= capacity) // 스택이 가득 참
            throw new OverflowGenericStackException();
        data.add(x);
        top++;
        return true;
    }

    // 팝: 스택에서 데이터를 꺼냄
    public Point2 pop() throws EmptyGenericStackException {
        if (top <= 0) // 스택이 비어있음
            throw new EmptyGenericStackException();
        Point2 x = data.get(--top);
        data.remove(top);
        return x;
    }

    // 피크: 스택에서 데이터를 들여다봄
    public Point2 peek() throws EmptyGenericStackException {
        if (top <= 0) // 스택이 비어있음
            throw new EmptyGenericStackException();
        return data.get(top - 1);
    }

    // 스택을 비움
    public void clear() {
        top = 0;
    }

    // 스택에서 x를 찾아 인덱스를 반환(없으면 –1)
    public int indexOf(Point2 x) {
        for (int i = top - 1; i >= 0; i--) {
            if (data.get(i).equals(x)) {
                return i;
            }
        }
        return -1; // 찾지 못함
    }

    // 스택의 크기를 반환
    public int getCapacity() {
        return capacity;
    }

    // 스택에 쌓여있는 데이터 개수를 반환
    public int size() {
        return top;
    }

    // 스택이 비어있는가?
    public boolean isEmpty() {
        return top <= 0;
    }

    // 스택이 가득 찼는가?
    public boolean isFull() {
        return top >= capacity;
    }

    // 스택 안의 모든 데이터를 바닥 → 꼭대기 순서로 출력
    public void dump() {
        if (top <= 0)
            System.out.println("스택이 비어 있습니다.");
        else {
            for (int i = 0; i < top; i++)
                System.out.print(data.get(i) + " ");
            System.out.println();
        }
    }
}

// 메인 클래스: 스택을 테스트하는 프로그램
public class _4_2_1객체스택 {

    public static void main(String[] args) {
        try (Scanner stdIn = new Scanner(System.in)) {
            objectStack s = new objectStack(8); // 최대 8 개를 push할 수 있는 stack
            Random random = new Random();
            int rndx = 0, rndy = 0;
            Point2 p = null;
            while (true) {
                System.out.println(); // 메뉴 구분을 위한 빈 행 추가
                System.out.printf("현재 데이터 개수: %d / %d\n", s.size(), s.getCapacity());
                System.out.print("(1)push　(2)pop　(3)peek　(4)dump　(0)종료: ");

                int menu = stdIn.nextInt();
                if (menu == 0)
                    break;

                switch (menu) {
                    case 1: // 푸시
                        rndx = random.nextInt(20);
                        rndy = random.nextInt(20);
                        p = new Point2(rndx, rndy);
                        try {
                            s.push(p);
                            System.out.println("데이터: " + p + "를 push했습니다.");
                        } catch (objectStack.OverflowGenericStackException e) {
                            System.out.println("stack이 가득차있습니다.");
                        }
                        break;

                    case 2: // 팝
                        try {
                            p = s.pop();
                            System.out.println("pop한 데이터는 " + p + "입니다.");
                        } catch (objectStack.EmptyGenericStackException e) {
                            System.out.println("stack이 비어있습니다.");
                        }
                        break;

                    case 3: // 피크
                        try {
                            p = s.peek();
                            System.out.println("peek한 데이터는 " + p + "입니다.");
                        } catch (objectStack.EmptyGenericStackException e) {
                            System.out.println("stack이 비어있습니다.");
                        }
                        break;

                    case 4: // 덤프
                        s.dump();
                        break;
                }
            }
        }
    }
}
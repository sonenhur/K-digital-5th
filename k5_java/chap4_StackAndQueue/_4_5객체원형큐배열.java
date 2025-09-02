package chap4_stackAndQueue;

/*
 * 원형 큐로서 큐에 Point 객체를 저장 - 교재 소스코드를 원형 큐가 되도록 수정하는 연습
 */

import java.util.Random;
import java.util.Scanner;

//2차원 점을 나타내는 클래스
class Point4 {
    private int ix;
    private int iy;

    public Point4(int x, int y) {
        ix = x;
        iy = y;
    }

    @Override
    public String toString() {
        return "<" + ix + ", " + iy + ">";
    }

    public int getX() {
        return ix;
    }

    public void setX(int x) {
        ix = x;
    }

    public int getY() {
        return iy;
    }

    public void setY(int y) {
        iy = y;
    }

    // 두 점이 같은지 비교하기 위한 equals 오버라이드
    @Override
    public boolean equals(Object p) {
        if ((this.ix == ((Point4) p).ix) && (this.iy == ((Point4) p).iy))
            return true;
        else
            return false;
    }
}

// 객체를 원형 큐로 저장하는 클래스
public class _4_5객체원형큐배열 {

    static int QUEUE_SIZE = 0;
    static boolean isEmpty;
    Point4[] que;
    int front, rear; // 큐의 시작과 끝을 가리키는 포인터
    int num; // 큐 안의 요소 수를 추적하는 변수

    public _4_5객체원형큐배열(int count) {
        QUEUE_SIZE = count;
        que = new Point4[QUEUE_SIZE];
        front = rear = num = 0;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        _4_5객체원형큐배열 oq = new _4_5객체원형큐배열(4); // 최대 크기가 4인 큐 생성
        Random random = new Random();
        int rndx, rndy;
        Point4 p;
        while (true) {
            System.out.println(" ");
            System.out.printf("현재 데이터 개수: %d / %d\n", oq.size(), oq.getCapacity());
            System.out.print("(1)인큐　(2)디큐　(3)피크　(4)덤프　(0)종료: ");
            int menu = stdIn.nextInt();
            switch (menu) {
                case 1: // 인큐
                    rndx = random.nextInt(20);
                    rndy = random.nextInt(20);
                    System.out.print("입력데이터: (" + rndx + ", " + rndy + ")");
                    p = new Point4(rndx, rndy);
                    try {
                        oq.push(p);
                    } catch (_4_5객체원형큐배열.OverflowQueueException e) {
                        System.out.println("큐가 가득차있습니다.");
                    }
                    break;

                case 2: // 디큐
                    try {
                        p = oq.pop();
                        System.out.println("디큐한 데이터는 " + p + "입니다.");
                    } catch (_4_5객체원형큐배열.EmptyQueueException e) {
                        System.out.println("큐가 비어 있습니다.");
                    }
                    break;

                case 3: // 피크
                    try {
                        p = oq.peek();
                        System.out.println("피크한 데이터는 " + p + "입니다.");
                    } catch (_4_5객체원형큐배열.EmptyQueueException e) {
                        System.out.println("큐가 비어 있습니다.");
                    }
                    break;

                case 4: // 덤프
                    oq.dump();
                    break;

                case 0: // 종료
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }

    // Point4를 원형 큐에 넣는 메서드 (Enqueue)
    void push(Point4 item) {
        if (num >= QUEUE_SIZE)
            throw new OverflowQueueException(); // 큐가 가득 찼을 때 예외 발생
        num++;
        que[rear++] = item;
        if (rear == QUEUE_SIZE)
            rear = 0; // 끝에 도달하면 처음으로 돌아감
    }

    // 원형 큐에서 Point4를 빼는 메서드 (Dequeue)
    Point4 pop() {
        if (num <= 0)
            throw new EmptyQueueException(); // 큐가 비어있을 때 예외 발생
        num--;
        Point4 item = que[front++];
        if (front == QUEUE_SIZE)
            front = 0; // 끝에 도달하면 처음으로 돌아감
        return item;
    }

    // 원형 큐를 비우는 메서드
    void clear() {
        for (int i = 0; i < que.length; i++) {
            que[i] = null;
            front = rear = 0;
        }
        isEmpty = true;
        System.out.println("원형 큐가 비었습니다.");
    }

    // 큐의 크기를 반환하는 메서드
    public int getCapacity() {
        return QUEUE_SIZE;
    }

    // 큐에 들어있는 요소 수를 반환하는 메서드
    public int size() {
        return num;
    }

    // 큐의 요소를 출력하는 메서드
    void dump() {
        if (num <= 0)
            System.out.println("큐가 비어 있습니다.");
        else
            for (int i = 0; i < num; i++)
                System.out.print(que[(i + front) % QUEUE_SIZE] + " ");
        System.out.println();
    }

    // 큐의 맨 앞에 있는 요소를 확인하는 메서드
    Point4 peek() {
        if (num <= 0)
            throw new EmptyQueueException(); // 큐가 비어있을 때 예외 발생
        return que[front];
    }

    public class EmptyQueueException extends RuntimeException {
        public EmptyQueueException() {
        }
    }

    public class OverflowQueueException extends RuntimeException {
        public OverflowQueueException() {
        }
    }
}

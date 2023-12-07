package chap5_recursive;

//https://www.geeksforgeeks.org/n-queen-problem-backtracking-3/?ref=lbp
//모든 해가 나오는 버젼 만들기
// 필요한 클래스 가져오기
class Stack3 {
    private final Point[] array; // 포인트를 저장하는 배열
    private final int maxSize; // 스택의 최대 크기
    private int top; // 최상위 요소의 인덱스

    // 스택 생성자: 주어진 크기로 스택을 초기화함
    public Stack3(int size) {
        maxSize = size;
        array = new Point[maxSize];
        top = -1; // 빈 스택을 나타내기 위해 -1로 초기화
    }

    // 스택에 포인트를 추가
    public void push(Point p) {
        array[++top] = p; // top을 증가시키고 해당 위치에 포인트를 추가
    }

    // 스택에서 포인트를 제거하고 반환
    public Point pop() {
        return array[top--]; // 최상위 포인트를 반환하고 top을 감소시킴
    }

    // 스택이 비어있는지 여부 반환
    public boolean isEmpty() {
        return (top == -1);
    }

    // 최상위 요소의 인덱스 반환
    public int getTop() {
        return top;
    }

    // 스택의 배열 반환
    public Point[] getArray() {
        return array;
    }
}

// x 및 y 좌표를 가지는 포인트를 나타내는 클래스
class Point {
    int x, y;

    // 좌표를 초기화하는 생성자
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

// 백트래킹을 사용하여 8-퀸 문제를 해결하는 메인 클래스
public class Backtracking8Queens {
    // 8-퀸 문제를 해결하는 메서드
    public static void solveQueen(int[][] d) {
        int row = d.length; // 행의 수
        int col = d[0].length; // 열의 수

        int ix = 0, iy = 0; // 현재 행과 열
        Stack3 st = new Stack3(row * col); // 포인트를 저장하는 스택

        while (ix >= 0) { // 모든 가능성을 탐색할 때까지 계속
            while (iy < col) { // 현재 행에서 열을 탐색
                if (checkMove(d, ix, iy)) {
                    // 유효한 이동이 발견되면 퀸을 놓고 다음 행으로 이동
                    Point p = new Point(ix, iy);
                    d[ix][iy] = 1;
                    st.push(p);
                    ix++;
                    iy = 0; // 다음 행의 첫 열로 이동

                    if (ix == row) {
                        // 8개의 퀸이 성공적으로 놓였으면 해결책을 출력
                        showQueens(d);
                        // 스택에서 퀸을 제거하여 더 많은 해결책을 찾기 위해 되돌아감
                        Point prevPoint = st.pop();
                        ix--;
                        d[prevPoint.x][prevPoint.y] = 0;
                        iy = prevPoint.y + 1;
                    }
                } else {
                    iy++; // 다음 열로 이동
                }
            }

            // 모든 열을 탐색했으면 이전 행으로 되돌아감
            if (!st.isEmpty()) {
                Point prevPoint = st.pop();
                ix--;
                d[prevPoint.x][prevPoint.y] = 0;
                iy = prevPoint.y + 1;
            } else {
                break; // 스택이 비어있으면 루프를 종료
            }
        }
    }

    // 스택의 내용을 출력하는 메서드
    public static void dumpStack(Stack3 stack) {
        for (int i = 0; i <= stack.getTop(); i++) {
            System.out.println("[" + stack.getArray()[i].x + ", " + stack.getArray()[i].y + "]");
        }
        System.out.println();
    }

    // 주어진 행에 퀸을 놓을 수 있는지 확인하는 메서드
    public static boolean checkRow(int[][] d, int crow) {
        for (int i = 0; i < d.length; i++) {
            if (crow < 0 || crow >= d.length) {
                return false; // 행 인덱스가 배열 범위를 벗어나면 퀸을 놓을 수 없음
            }
            if (d[crow][i] == 1) {
                return false; // 해당 행에 이미 퀸이 놓여있으면 퀸을 놓을 수 없음
            }
        }
        return true; // 해당 행에 퀸이 놓여있지 않음
    }

    // 주어진 열에 퀸을 놓을 수 있는지 확인하는 메서드
    public static boolean checkCol(int[][] d, int ccol) {
        for (int i = 0; i < d.length; i++) {
            if (d[i][ccol] == 1) {
                return false; // 해당 열에 이미 퀸이 놓여있으면 퀸을 놓을 수 없음
            }
        }
        return true; // 해당 열에 퀸이 놓여있지 않음
    }

    // 주어진 위치에 남서 방향 대각선에 퀸을 놓을 수 있는지 확인하는 메서드
    public static boolean checkDiagSW(int[][] d, int cx, int cy) {
        int x = cx;
        int y = cy;

        // 북동 방향 대각선 확인
        while (x >= 0 && x < d.length && y >= 0 && y < d.length) {
            if (d[x][y] == 1) return false;
            x--;
            y++;
        }

        x = cx;
        y = cy;

        // 남서 방향 대각선 확인
        while (x >= 0 && x < d.length && y >= 0 && y < d.length) {
            if (d[x][y] == 1) return false;
            x++;
            y--;
        }
        return true; // 남서 방향 대각선에 퀸을 놓을 수 있음
    }

    // 주어진 위치에 남동 방향 대각선에 퀸을 놓을 수 있는지 확인하는 메서드
    public static boolean checkDiagSE(int[][] d, int cx, int cy) {
        int x = cx;
        int y = cy;

        // 북서 방향 대각선 확인
        while (x >= 0 && x < d.length && y >= 0 && y < d.length) {
            if (d[x][y] == 1) return false;
            x--;
            y--;
        }

        x = cx;
        y = cy;

        // 남동 방향 대각선 확인
        while (x >= 0 && y >= 0 && x < d.length && y < d.length) {
            if (d[x][y] == 1) return false;
            x++;
            y++;
        }
        return true; // 남동 방향 대각선에 퀸을 놓을 수 있음
    }

    // 주어진 위치에 퀸을 놓을 수 있는지 여부 확인
    public static boolean checkMove(int[][] d, int x, int y) {
        return checkRow(d, x) && checkCol(d, y) && checkDiagSW(d, x, y) && checkDiagSE(d, x, y);
    }

    // 다음 이동 가능한 열을 반환, 이동할 열이 없으면 -1 반환
    public static int nextMove(int[][] d, int row, int col) {
        for (int nextCol = col + 1; nextCol < d.length; nextCol++) {
            if (checkMove(d, row, nextCol)) {
                return nextCol; // 다음 열로 이동 가능한 경우 해당 열 반환
            }
        }
        return -1; // 이동할 열이 더 이상 없는 경우
    }

    // 현재 상태에서의 퀸 배치를 출력하는 메서드
    static void showQueens(int[][] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                if (data[i][j] == 1) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    // 프로그램을 실행하는 메인 메서드
    public static void main(String[] args) {
        int row = 8, col = 8; // 체스보드의 크기
        int[][] data = new int[row][col]; // 체스보드를 나타내는 2D 배열

        // 모든 원소를 0으로 초기화
        for (int i = 0; i < data.length; i++)
            for (int j = 0; j < data[0].length; j++)
                data[i][j] = 0;

        // 8-퀸 문제를 해결하고 해결책을 출력
        solveQueen(data);
    }
}

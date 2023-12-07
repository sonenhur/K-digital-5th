package chap5_recursive;

//https://www.geeksforgeeks.org/n-queen-problem-backtracking-3/?ref=lbp
//모든 해가 나오는 버젼 만들기
// 필요한 클래스 가져오기
class Stack3 {
    private final Point[] array; // 점을 저장하는 배열
    private final int maxSize; // 스택의 최대 크기
    private int top; // 최상위 요소의 인덱스

    // 스택을 초기화하는 생성자
    public Stack3(int size) {
        maxSize = size;
        array = new Point[maxSize];
        top = -1; // -1로 초기화하여 빈 스택을 나타냄
    }

    // 점을 스택에 추가
    public void push(Point p) {
        array[++top] = p; // top을 증가시키고 점을 스택에 추가
    }

    // 스택에서 점을 꺼내어 반환
    public Point pop() {
        return array[top--]; // 최상위 점을 반환하고 top을 감소시킴
    }

    // 스택이 비어있는지 확인
    public boolean isEmpty() {
        return (top == -1);
    }

    // 최상위 요소의 인덱스를 얻음
    public int getTop() {
        return top;
    }

    // 스택을 나타내는 배열을 얻음
    public Point[] getArray() {
        return array;
    }
}

// x 및 y 좌표를 가지는 점을 나타내는 클래스
class Point {
    int x, y;

    // 주어진 좌표로 점을 초기화하는 생성자
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

// 백트래킹을 사용하여 8-퀸 문제를 해결하는 메인 클래스
public class Backtracking8Queens {
    // 8-퀸 문제를 해결하는 메서드
    public static void solveQueen(int[][] d) {
        int row = d.length; // 행 수
        int col = d[0].length; // 열 수

        int ix = 0, iy = 0; // 현재 행 및 열
        Stack3 st = new Stack3(row * col); // 점을 저장하는 스택

        while (ix >= 0) { // 모든 가능성이 탐색될 때까지 계속
            while (iy < col) { // 현재 행에서 열을 탐색
                if (checkMove(d, ix, iy)) {
                    // 유효한 이동이 발견되면 퀸을 배치하고 다음 행으로 이동
                    Point p = new Point(ix, iy);
                    d[ix][iy] = 1;
                    st.push(p);
                    ix++;
                    iy = 0; // 다음 행의 첫 번째 열로 이동

                    if (ix == row) {
                        // 8개의 퀸이 성공적으로 배치된 경우 솔루션 표시
                        showQueens(d);
                        // 퀸을 스택에서 제거하여 더 많은 솔루션을 찾기 위해 되돌아감
                        Point prevPoint = st.pop();
                        ix--;
                        d[prevPoint.x][prevPoint.y] = 0;
                        iy = prevPoint.y + 1;
                    }
                } else {
                    iy++; // 다음 열로 이동
                }
            }

            // 모든 열이 탐색된 경우 이전 행으로 되돌아감
            if (!st.isEmpty()) {
                Point prevPoint = st.pop();
                ix--;
                d[prevPoint.x][prevPoint.y] = 0;
                iy = prevPoint.y + 1;
            } else {
                break; // 스택이 비어있으면 종료
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

    // 주어진 행에 퀸을 배치할 수 있는지 확인하는 메서드
    public static boolean checkRow(int[][] d, int crow) {
        for (int i = 0; i < d.length; i++) {
            if (crow < 0 || crow >= d.length) {
                return false; // 행 인덱스가 배열 범위를 벗어남
            }
            if (d[crow][i] == 1) {
                return false; // 행에 이미 퀸이 배치되어 있음
            }
        }
        return true; // 행에 퀸을 배치할 수 있음
    }

    // 주어진 열에 퀸을 배치할 수 있는지 확인하는 메서드
    public static boolean checkCol(int[][] d, int ccol) {
        for (int i = 0; i < d.length; i++) {
            if (d[i][ccol] == 1) {
                return false; // 열에 이미 퀸이 배치되어 있음
            }
        }
        return true; // 열에 퀸을 배치할 수 있음
    }

    // 주어진 행 및 열에 남서 대각선에 퀸을 배치할 수 있는지 확인하는 메서드
    public static boolean checkDiagSW(int[][] d, int cx, int cy) {
        int x = cx;
        int y = cy;

        // 북동 대각선 확인
        while (x >= 0 && x < d.length && y >= 0 && y < d.length) {
            if (d[x][y] == 1) return false;
            x--;
            y++;
        }

        x = cx;
        y = cy;

        // 남서 대각선 확인
        while (x >= 0 && x < d.length && y >= 0 && y < d.length) {
            if (d[x][y] == 1) return false;
            x++;
            y--;
        }
        return true; // 남서 대각선에 퀸을 배치할 수 있음
    }

    // 주어진 행 및 열에 남동 대각선에 퀸을 배치할 수 있는지 확인하는 메서드
    public static boolean checkDiagSE(int[][] d, int cx, int cy) {
        int x = cx;
        int y = cy;

        // 북서 대각선 확인
        while (x >= 0 && x < d.length && y >= 0 && y < d.length) {
            if (d[x][y] == 1) return false;
            x--;
            y--;
        }

        x = cx;
        y = cy;

        // 남동 대각선 확인
        while (x >= 0 && y >= 0 && x < d.length && y < d.length) {
            if (d[x][y] == 1) return false;
            x++;
            y++;
        }
        return true; // 남동 대각선에 퀸을 배치할 수 있음
    }

    // 주어진 위치에 퀸을 배치할 수 있는지 확인하는 메서드
    public static boolean checkMove(int[][] d, int x, int y) {
        return checkRow(d, x) && checkCol(d, y) && checkDiagSW(d, x, y) && checkDiagSE(d, x, y);
    }

    // 주어진 행과 열에서 다음으로 이동할 열을 반환, 이동이 불가능한 경우 -1 반환
    public static int nextMove(int[][] d, int row, int col) {
        for (int nextCol = col + 1; nextCol < d.length; nextCol++) {
            if (checkMove(d, row, nextCol)) {
                return nextCol; // 다음 열로 이동 가능한 경우 해당 열을 반환
            }
        }
        return -1; // 더 이상 이동할 열이 없는 경우
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

        // 0으로 초기화된 체스보드 초기화
        for (int i = 0; i < data.length; i++)
            for (int j = 0; j < data[0].length; j++)
                data[i][j] = 0;

        // 8-퀸 문제 해결 및 솔루션 표시
        solveQueen(data);
    }
}

package chap5_recursive;
//https://www.geeksforgeeks.org/n-queen-problem-backtracking-3/?ref=lbp

//모든 해가 나오는 버젼 만들기

class Stack3 {
    private final Point[] array;
    private final int maxSize;
    private int top;

    public Stack3(int size) {
        // 스택 생성자: 크기를 받아 스택을 초기화함
        maxSize = size;
        array = new Point[maxSize];
        top = -1; // -1로 초기화하여 빈 스택을 나타냄
    }

    public void push(Point p) {
        // 스택에 원소 추가
        array[++top] = p;
    }

    public Point pop() {
        // 스택에서 원소 제거하고 반환
        return array[top--];
    }

    public boolean isEmpty() {
        // 스택이 비어있는지 여부 반환
        return (top == -1);
    }

    // 스택의 top에 있는 값 반환
    public int getTop() {
        return top;
    }

    // 스택의 배열 반환
    public Point[] getArray() {
        return array;
    }
}

class Point {
    int x, y;

    Point(int x, int y) {
        // 좌표를 나타내는 Point 클래스 생성자
        this.x = x;
        this.y = y;
    }
}

public class Backtracking_Queen2023 {

    public static void solveQueen(int[][] d) {
        int count = 0; // 퀸 배치 갯수
        int ix = 0, iy = 0; // 현재 행 ix, 열 iy
        Stack3 st = new Stack3(100); // 100개를 저장할 수 있는 스택 생성
        Point p = new Point(ix, iy); // 현 위치를 객체로 만들고
        d[ix][iy] = 1; // 현 위치에 퀸을 넣었다는 표시를 하고
        count++;
        st.push(p); // 스택에 현 위치 객체를 push
        ix++;

        // Use a flag to indicate whether a solution is found
        boolean solutionFound = false;

        while (true) {
            if (st.isEmpty()) {
                // 스택이 비어있으면 모든 가능성을 탐색한 것이므로 종료
                break;
            }

            if (ix == 8) {
                // 8개의 퀸을 성공적으로 배치한 경우
                solutionFound = true;
                showQueens(d);
                Point prevPoint = st.pop();
                ix--; // 이전 행으로 이동
                count--; // 퀸 갯수 감소
                d[prevPoint.x][prevPoint.y] = 0; // 퀸을 제거
                iy = prevPoint.y + 1; // 이전 행의 다음 열로 이동
            } else if ((iy = nextMove(d, ix, iy)) == -1) {
                // 현재 행에서 더 이상 유효한 이동이 없을 경우
                Point prevPoint = st.pop();
                ix--; // 이전 행으로 이동
                count--; // 퀸 갯수 감소
                d[prevPoint.x][prevPoint.y] = 0; // 퀸을 제거
                iy = prevPoint.y + 1; // 이전 행의 다음 열로 이동
            } else {
                // 유효한 이동이 있으면 퀸을 배치
                p = new Point(ix, iy);
                d[ix][iy] = 1;
                count++;
                st.push(p);
                ix++;
                iy = 0; // 다음 행의 첫 열로 이동
            }
        }

        if (!solutionFound) {
            System.out.println("No solution found.");
        }
    }

    public static void dumpStack(Stack3 stack) {
        // 스택 내용을 출력하는 메서드
        for (int i = 0; i <= stack.getTop(); i++) {
            System.out.println("[" + stack.getArray()[i].x + ", " + stack.getArray()[i].y + "]");
        }
        System.out.println();
    }

    public static boolean checkRow(int[][] d, int crow) {
        // 배열 d에서 행 crow에 퀸을 배치할 수 있는지 확인
        for (int i = 0; i < d.length; i++) {
            if (crow < 0 || crow >= d.length) {
                // 행 인덱스가 배열 범위를 벗어나면 배치할 수 없음
                return false;
            }
            if (d[crow][i] == 1) {
                // 해당 행에 이미 퀸이 배치되어 있음
                return false;
            }
        }
        // 해당 행에 퀸이 배치되어 있지 않음
        return true;
    }

    public static boolean checkCol(int[][] d, int ccol) {
        // 배열 d에서 열 ccol에 퀸을 배치할 수 있는지 확인
        for (int i = 0; i < d.length; i++) {
            if (d[i][ccol] == 1) {
                // 해당 열에 이미 퀸이 배치되어 있음
                return false;
            }
        }
        // 해당 열에 퀸이 배치되어 있지 않음
        return true;
    }

    public static boolean checkDiagSW(int[][] d, int cx, int cy) {
        // 배열 d에서 행 cx, 열 cy에 퀸을 남서, 북동 대각선으로 배치할 수 있는지 확인
        int x = cx;
        int y = cy;

        // 북동
        while (x >= 0 && x < d.length && y >= 0 && y < d.length) {
            if (d[x][y] == 1) return false;
            x--;
            y++;
        }

        x = cx;
        y = cy;

        // 남서
        while (x >= 0 && x < d.length && y >= 0 && y < d.length) {
            if (d[x][y] == 1) return false;
            x++;
            y--;
        }
        return true;
    }

    public static boolean checkDiagSE(int[][] d, int cx, int cy) {
        // 배열 d에서 행 cx, 열 cy에 퀸을 남동, 북서 대각선으로 배치할 수 있는지 확인
        int x = cx;
        int y = cy;

        // 북서
        while (x >= 0 && x < d.length && y >= 0 && y < d.length) {
            if (d[x][y] == 1) return false;
            x--;
            y--;
        }

        x = cx;
        y = cy;

        // 남동
        while (x >= 0 && y >= 0 && x < d.length && y < d.length) {
            if (d[x][y] == 1) return false;
            x++;
            y++;
        }
        return true;
    }

    public static boolean checkMove(int[][] d, int x, int y) {
        // 특정 위치에 퀸을 배치할 수 있는지 여부 확인
        return checkRow(d, x) && checkCol(d, y) && checkDiagSW(d, x, y) && checkDiagSE(d, x, y);
    }

    public static int nextMove(int[][] d, int row, int col) {
        // 배열 d에서 현재 위치(row, col)에 대하여 다음에 이동할 위치 nextCol을 반환, 이동이 불가능하면 -1을 반환
        for (int nextCol = col + 1; nextCol < d.length; nextCol++) {
            if (checkMove(d, row, nextCol)) {
                return nextCol; // 다음 열로 이동 가능한 경우 해당 열을 반환
            }
        }
        return -1; // 더 이상 이동할 열이 없는 경우
    }

    static void showQueens(int[][] data) {
        // 현재 상태에서의 퀸 배치를 출력하는 메서드
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

    public static void main(String[] args) {
        int row = 8, col = 8;
        int[][] data = new int[row][col];
        for (int i = 0; i < data.length; i++)
            for (int j = 0; j < data[0].length; j++)
                data[i][j] = 0;

        solveQueen(data);
    }
}

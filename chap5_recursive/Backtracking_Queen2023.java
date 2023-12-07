package chap5_recursive;
//https://www.geeksforgeeks.org/n-queen-problem-backtracking-3/?ref=lbp

//모든 해가 나오는 버젼 만들기 

class Stack3 {
    private Point[] array;
    private int top;
    private int maxSize;

    public Stack3(int size) {
        maxSize = size;
        array = new Point[maxSize];
        top = -1; //-1로 하는 이유: 빈 스택을 나타내기 위해서
    }

    public void push(Point p) {
        array[++top] = p;
    }

    public Point pop() {
        return array[top--];
    }

    public boolean isEmpty() {
        return (top == -1);
    }
}

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Backtracking_Queen2023 {

    public static void solveQueen(int[][] d) {
        int count = 0;// 퀸 배치 갯수
        int ix = 0, iy = 0;// 행 ix, 열 iy
        Stack3 st = new Stack3(100); // 100개를 저장할 수 있는 스택을 생성
        Point p = new Point(ix, iy); // 현 위치를 객체로 만들고
        d[ix][iy] = 1; // 현 위치에 퀸을 넣었다는 표시를 하고
        count++;
        st.push(p);// 스택에 현 위치 객체를 push
        while (true) {
            if (st.isEmpty() && ix == 8)  // ix가 8이면 8개 배치 완료, stack이 empty가 아니면 다른 해를 구한다
                break;
            if ((iy = nextMove(d, ix, iy)) == -1) {// 다음 이동할 열을 iy로 주는데 -1이면 더이상 이동할 열이 없음을 나타냄
                if (st.isEmpty()) {
                    break;  // 스택이 비어 있고 nextMove가 -1을 반환하면 해결책이 없음
                } else {
                    Point prevPoint = st.pop(); // 스택에서 이전 위치 정보를 꺼냄
                    ix--; // 행을 하나 위로 이동
                    count--; // 퀸 배치 갯수 감소
                    d[prevPoint.x][prevPoint.y] = 0; // Backtrack: 이전에 퀸을 놓았던 위치를 0으로 되돌림
                }
            }

            p = new Point(ix, iy);
            d[ix][iy] = 1;
            count++;
            st.push(p);

        }

        if (count == 8) { // 8개를 모두 배치하면
            showQueens(d); // 현재 상태에서의 퀸 배치를 출력
            Point prevPoint = st.pop(); // 스택에서 이전 위치 정보를 꺼냄
            ix--; // 행을 하나 위로 이동
            count--; // 퀸 배치 갯수 감소
            d[prevPoint.x][prevPoint.y] = 0; // Backtrack: 이전에 퀸을 놓았던 위치를 0으로 되돌림
        } //현재 상태를 출력하고 이전 단계로 돌아가서 다른 방법도 추가로 탐색함. (가능한 모든 해를 찾아내기 위해)
    }


    public static boolean checkRow(int[][] d, int crow) {// 배열 d에서 행 crow에 퀸을 배치할 수 있는지 조사
        for (int i = 0; i < d.length; i++) {
            if (d[crow][i] == 1) {
                // 해당 행에 이미 퀸이 배치되어 있음
                return false;
            }
        }
        // 해당 행에 퀸이 배치되어 있지 않음
        return true;
    }

    public static boolean checkCol(int[][] d, int ccol) {// 배열 d에서 열 ccol에 퀸을 배치할 수 있는지 조사
        for (int i = 0; i < d.length; i++) {
            if (d[i][ccol] == 1) {
                // 해당 열에 이미 퀸이 배치되어 있음
                return false;
            }
        }
        // 해당 열에 퀸이 배치되어 있지 않음
        return true;
    }


    // 배열 d에서 행 cx, 열 cy에 퀸을 남서, 북동 대각선으로 배치할 수 있는지 조사
    public static boolean checkDiagSW(int[][] d, int cx, int cy) { // x++, y-- or x--, y++ where 0<= x,y <= 7
        int x = cx;
        int y = cy;

        //북동
        while (x >= 0 && x < d.length && y >= 0 && y < d.length) {
            if (d[x][y] == 1) return false;
            x--;
            y++;
        }

        x = cx;
        y = cy;

        //남서
        while (x >= 0 && x < d.length && y >= 0 && y < d.length) {
            if (d[x][y] == 1) return false;
            x++;
            y--;
        }
        return true;
    }

    // 배열 d에서 행 cx, 열 cy에 퀸을 남동, 북서 대각선으로 배치할 수 있는지 조사
    public static boolean checkDiagSE(int[][] d, int cx, int cy) {// x++, y++ or x--, y--
        int x = cx;
        int y = cy;

        //북서
        while (x >= 0 && x < d.length && y >= 0 && y < d.length) {
            if (d[x][y] == 1) return false;
            x--;
            y--;
        }

        x = cx;
        y = cy;

        //남동
        while (x >= 0 && y >= 0 && x < d.length && y < d.length) {
            if (d[x][y] == 1) return false;
            x++;
            y++;
        }
        return true;
    }

    // 배열 d에서 (x, y)에 퀸을 배치할 수 있는지 여부를 확인
    public static boolean checkMove(int[][] d, int x, int y) {
        // TODO: 특정 위치에 퀸을 배치할 수 있는지 여부를 확인하는 로직 작성
        // 행, 열, 그리고 양 대각선에 퀸이 없는지 확인
        return checkRow(d, x) && checkCol(d, y) && checkDiagSW(d, x, y) && checkDiagSE(d, x, y);
    }

    // 배열 d에서 현재 위치(row, col)에 대하여 다음에 이동할 위치 nextCol을 반환, 이동이 가능하지 않으면 -1를 리턴
    public static int nextMove(int[][] d, int row, int col) {
        for (int nextCol = col + 1; nextCol < d.length; nextCol++) {
            if (checkMove(d, row, nextCol)) {
                return nextCol; // 다음 열로 이동 가능한 경우 해당 열을 반환
            }
        }
        return -1; // 더 이상 이동할 열이 없는 경우
    }

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

    public static void main(String[] args) {
        int row = 8, col = 8;
        int[][] data = new int[row][col];
        for (int i = 0; i < data.length; i++)
            for (int j = 0; j < data[0].length; j++)
                data[i][j] = 0;

        solveQueen(data);
        showQueens(data);
    }
}
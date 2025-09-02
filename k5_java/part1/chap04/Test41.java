package part1.chap04;

public class Test41 {
    //    public static void main(String[] args) {
//        int[][] x = {{1, 2, 3}, {4, 5, 6}};
//        int[][] y = {{1, 2}, {3, 4}, {5, 6}};
//
//        for (int[] ints : x) {
//            for (int j = 0; j < y[0].length; j++) {
//                int sum = 0;
//                for (int k = 0; k < y.length; k++) {
//                    sum += (ints[k] * y[k][j]);
//                }
//                System.out.print(sum + "\t");
//            }
//            System.out.println("\n");
//        }
//    }
    public static void main(String[] args) {
        int[][] x = {{1, 2, 3}, {4, 5, 6}};
        int[][] y = {{1, 2}, {3, 4}, {5, 6}};
        // 행렬 곱셈 결과를 저장할 배열 선언
        int[][] result = new int[x.length][y[0].length];
        // 행렬 곱셈 수행
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < y[0].length; j++) {
                int sum = 0;
                for (int k = 0; k < y.length; k++) {
                    sum += x[i][k] * y[k][j];
                }
                result[i][j] = sum;
            }
        }
        // 결과 출력
        for (int[] row : result) {
            for (int value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }
}

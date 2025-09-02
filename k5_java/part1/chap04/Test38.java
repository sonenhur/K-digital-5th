package part1.chap04;

public class Test38 {

    //    public static void main(String[] args) {
//        int[][] arr = new int[5][5];
//        int num = 1;
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                arr[i][j] = num++;
//                System.out.print(arr[i][j]);
//                System.out.print("\t");
//            }
//        }
//        System.out.println("\n");
//    }
    public static void main(String[] args) {
        int[][] arr = new int[5][5];
        int num = 1;
        // 배열에 값을 채우고 출력
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = num++;
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println(); //각 행 출력 후 줄바꿈
        }
    }
}
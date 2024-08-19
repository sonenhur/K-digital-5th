package part1.chap04;

public class Test39 {
    public static void main(String[] args) {
        int[][] arr = new int[5][10];
        int num = 1;
        // 배열에 값 설정
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = num++;
            }
        }
        // 배열에 설정된 값을 화면 출력
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
                System.out.print("\t");
            }
            System.out.println("\n");
        }
        // 배열의 대각 합을 구해서 설정
        int sum = 0;
        for (int i = 0; i < arr.length && i < arr[0].length; i++)
            sum += arr[i][i];
        // 배열의 대각 합을 출력}
        System.out.println("합: " + sum);
    }
}
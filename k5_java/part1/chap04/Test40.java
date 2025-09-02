package part1.chap04;

class Sub {
    private String name;
    private int age;

    private int sum() {
        return 0;
    }

    public int average() {
        return 0;
    }
}

//클래스 내에 서브 클래스 만들 수 있음.
//그 경우 public은 하나만 있어야 함.
// private, (default), public의 보인다 안보인다 구분은 {}안이냐 밖이냐로
public class Test40 {
    //    public static void main(String[] args) {
//        int[][] arr = new int[5][10];
//        int num = 1;
//        // 배열에 값 설정
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                arr[i][j] = num++;
//            }
//        }
//        // 배열에 설정된 값을 화면 출력
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                System.out.print(arr[i][j]);
//                System.out.print("\t");
//            }
//            System.out.println("\n");
//        }
//        // 배열의 대각 합을 구해서 설정
//        int sum = 0;
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j <= i; j++) {
//                sum += arr[i][j];
////				i는 0부터 쭉 늘어남+
////				j는 0부터 i까지만 늘어남
////				(j= 0,1,2...,i)
//            }
//        }
//        // 배열의 대각 합을 출력}
//        System.out.println("합: " + sum);
//    }
    public static void main(String[] args) {
        int[][] arr = new int[5][10];
        int num = 1;

        // 배열에 값 설정 및 출력
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = num++;
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println(); //줄바꿈
        }

        // 배열의 삼각형 모양의 합 계산
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= i && j < arr[i].length; j++) {
                sum += arr[i][j];
            }
        }
        // 배열의 대각 합 출력
        System.out.println("합 : " + sum);
    }
}
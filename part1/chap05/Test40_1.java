package part1.chap05;

public class Test40_1 {
    private static int sum(int a, int b) {
        return a + b;
    }

    private static double avg(int... b) {
        double sum = 0.0;
        for (int j : b) {
            sum += j;
        }
        return sum / b.length;
    }

    private static int min(int... c) {
        int min = c[0];
        for (int j : c) {
//		가변길이 인수를 저장한 c의 길이만큼 반복
            if (j < c[0]) {
                min = j;
//			↑c[0]값이랑 이후 값들을 비교해보고 더 작으면 바꿔라	
            }
        }
        return min;
    }

    private static int max(int... d) {
        int max = d[0];
        for (int j : d) {
            if (j > d[0]) {
                max = j;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int s = sum(10, 20);
        System.out.println("sum: " + s);
        System.out.println("avg: " + avg(1, 2, 3, 4, 5));
        System.out.println("min: " + min(6, 4, 7, 8, 3, 2));
        System.out.println("max: " + max(1, 2, 3, 4, 5, 99));
    }
}

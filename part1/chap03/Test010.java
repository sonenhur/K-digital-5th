package part1.chap03;

public class Test010 {
    public static void main(String[] args) { // JAVA 반복문
        // for 문 : 반복 횟수가 명확할 때 사용
        // 초기화, 조건, 증감이 한 줄에 모여 있어 구조가 명확함
        int a = 0;
        int d = 5;
        for (int i = 0; i < 5; i++) {
            System.out.println("i = " + i + ", a = " + a);
            a += d;
        }
        System.out.println();
        // while 문 : 조건에 따라 반복 여부가 결정됨
        // 조건이 false인 경우 처음부터 실행되지 않을 수 있음
        int j = 0;
        while (j < 5) {
            System.out.println("j = " + j + ", a = " + a);
            a += d;
            j++;
        }
        System.out.println();
        // do-while 문 : 조건과 상관없이 블록이 최소 한 번은 실행됨
        // 조건이 false라도 처음 한 번은 실행하고 나서 조건을 검사
        // while 문과의 가장 큰 차이점
        int k = 0;
        do {
            System.out.println("k = " + k + ", a = " + a);
            a += d;
            k++;
        } while (k < 5);
    }
}

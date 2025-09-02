package part1.chap04;

public class Test035_1 {
    public static void main(String[] args) {
//      일반 for 문은 인덱스를 사용해 배열이나 리스트의 요소에 접근
        int[] numbers = {1, 2, 3, 4, 5};

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
//      확장된 for 문은 배열이나 컬렉션의 각 요소를 직접 순회함
//      인덱스를 사용할 필요가 없다:
        int[] numbers1 = {1, 2, 3, 4, 5};

        for (int number : numbers1) {
            System.out.println(number);
        }
    }
}

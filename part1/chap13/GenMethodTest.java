package part1.chap13;

import java.util.Objects;

public class GenMethodTest {
    static <T extends Number, V extends T> boolean isIncluded(T num, V[] array) {
        for (int i = 0; i < array.length; i++) {
            if (Objects.equals(array[i], num))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        GenMethodTest g = new GenMethodTest();
        g.sort();

        Integer[] inum = {1, 2, 3, 4, 5};
        Double[] dnum = {1.1, 2.2, 3.3, 4.4, 5.5};
        String[] snum = {"one", "two", "Three", "four", "five"};

        boolean b1 = isIncluded(3, inum);
        System.out.println("결과 : " + b1);

        boolean b2 = isIncluded(5.5, dnum);
        System.out.println("결과 : " + b2);

//		//extends Number로 제한했기 때문에 문자열은 에러
//		isInclude("one",snum);

        GenMethodTest.isIncluded(3, inum);
        GenMethodTest.isIncluded(5.5, dnum);
    }

    void sort() {

    }
}

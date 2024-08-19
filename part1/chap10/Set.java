package part1.chap10;

import java.util.*;

public class Set {

    public static void main(String[] args) {
        lotto_generator(5); // 몇 줄 만들지를 결정
    }

    public static void lotto_generator(int n) {
        // 랜덤 숫자 생성하기
        Random number = new Random();
        HashSet<Integer> lotto = null;

        // i는 lotto_generator('숫자')에 해당하는 횟수만큼 반복
        for (int i = 0; i < n; i++) {
            lotto = new HashSet<Integer>();

            // j는 의미가 없어서 빼도 됨.
            // 그 경우 while 조건문으로 써도 똑같다
            // for (; lotto.size() <= 6;)
            while (lotto.size() <= 6) {
                lotto.add(number.nextInt(1, 46));
            }
            List<Integer> L = new ArrayList(lotto);
            Collections.sort(L);
            System.out.println(L);
        }
//		List<Integer> L = new ArrayList(lotto);
//		Collections.sort(L);
//		System.out.println(L);
    }
}

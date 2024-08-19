package part1.chap04;

public class Test036 {

    //    public static void main(String[] args) {
//        char letter = 'A';
//        char[] alphabet = new char[26];
//
//        for (int i = 0; i < alphabet.length; i++) {
//            alphabet[i] = (char) (letter + i);
//        letter 변수의 값을 유지하면서, 매 반복마다 letter에 i를 더한 결과를 계산
//        }
//        for (char c : alphabet) {
//            System.out.print(c);
//        }
//    }
    public static void main(String[] args) {
        char letter = 'A';
        char[] alphabet = new char[26];

        for (int i = 0; i < alphabet.length; i++) {
            alphabet[i] = letter++;
//          letter 변수를 직접 1씩 증가시키면서 alphabet 배열에 저장
        }
        for (char ch : alphabet) {
            System.out.print(ch);
        }
    }
}

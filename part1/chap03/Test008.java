package part1.chap03;

public class Test008 {
    //    public static void main(String[] args) {
//        int score = 970;
//        int bonus;
//        if (score < 100) {
//            bonus = 10;
//        } else if (score < 200) {
//            bonus = 20;
//        } else bonus = 30;
//        System.out.println(score + bonus);
//    }
    public static void main(String[] args) {
        int score = 970;
        int bonus;
        if (score < 100) {
            bonus = 10;
        } else if (score >= 100 && score < 200) {
            bonus = 20;
        } else bonus = 30;
        score += bonus;
        System.out.println("score = " + score);
    }
}

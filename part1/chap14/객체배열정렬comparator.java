package part1.chap14;

//public interface Comparator<T> {
//	int compare(T 01, T 02);
//}
//
//public interface Comparable<T> {
//	public int compareTo(T o);
//}

import java.util.Arrays;
import java.util.Comparator;

class Student {
    String sno; //학생 번호
    String sname; //학생 이름

    public Student(String sno, String sname) {
        this.sno = sno;
        this.sname = sname;
    } //생성자를 통해 두 값을 초기화

    public String toString() {
        return "[" + sno + ", " + sname + "]";
    } //toString() 메소드를 통해 문자열로 반환
}

public class 객체배열정렬comparator {
    //sortStudent 메소드		인자						인자
    static void sortStudent(Student[] data, Comparator<Student> comp) {
        Arrays.sort(data, comp);
    } //Arrays.sort() 메소드를 사용해 배열을 정렬
    //두 번째 매개변수로 Comparator 객체를 받아서, 이 Comparator의 compare() 메소드를 사용해 배열의 요소들을 비교하고 정렬

    public static void main(String[] args) {
//		Comparator<Student> compNo = new Comparator<Student>(){
//			@Override
//			public int compare(Student s1, Student s2) {};
        // 람다식 변환
//		Comparator<Student> compNo = (s1, s2) -> s1.sno.compareTo(s2.sno);
        // 인트 변환
//		Comparator<Student> compNo = (s1, s2) -> Integer.compare(Integer.parseInt(s1.sno), Integer.parseInt(s2.sno));
        Comparator<Student> compNo = (s1, s2) -> Integer.parseInt(s1.sno) - Integer.parseInt(s2.sno);
        // 더 간단하게

//		Comparator<Student> compName = new Comparator<Student>(){
//			@Override
//			public int compare(Student s1, Student s2) {};
        // 람다식 변환

        Comparator<Student> compName = (s1, s2) -> s1.sname.compareTo(s2.sname);
        //main 메소드에서 두 가지 Comparator<Student> 객체를 생성

        Student[] data = {
                new Student("9", "홍라동"),
                new Student("12", "홍다동"),
                new Student("121", "홍가동"),
                new Student("213", "홍나동")
        };
        //Student 객체 배열 data를 생성

        sortStudent(data, compNo);
        for (Student stno : data)
            System.out.print(" " + stno);
        //sortStudent 메소드를 통해 번호 순으로 정렬된 학생 정보 출력
        System.out.println();

        sortStudent(data, compName);
        for (Student stname : data)
            System.out.print(" " + stname);
        //sortStudent 메소드를 통해 이름 순으로 정렬된 학생 정보 출력
    }
}

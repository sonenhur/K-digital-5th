package part1.chap14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Student3 {
    String sno;
    String sname;

    // 생성자 추가
    Student3(String sno, String sname) {
        this.sno = sno;
        this.sname = sname;
    }
}

public class 객체리스트정렬comparator {
    public static void main(String[] args) {
        Comparator<Student3> compSno = new Comparator<Student3>() {
            @Override
            public int compare(Student3 s1, Student3 s2) {
                return s1.sno.compareTo(s2.sno);
            }
        };
        Comparator<Student3> compName = new Comparator<Student3>() {
            @Override
            public int compare(Student3 s1, Student3 s2) {
                return s1.sname.compareTo(s2.sname);
            }
        };
        ArrayList<Student3> al = new ArrayList<>();

        // Student3 객체를 생성하고 리스트에 추가
        al.add(new Student3("20210001", "홍길동"));
        al.add(new Student3("20210002", "이순신"));
        al.add(new Student3("20210003", "김유신"));

        // 학번(sno)으로 정렬
        Collections.sort(al, compSno);
        for (Student3 st : al)
            System.out.print(" " + st.sno);

        System.out.println();

        // 이름(sname)으로 정렬
        Collections.sort(al, compName);
        for (Student3 st : al)
            System.out.print(" " + st.sname);
    }
}

package part1.chap14;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Student2 {
    String sno;
    String sname;

    public Student2(String sno, String sname) {
        this.sno = sno;
        this.sname = sname;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                '}';
    }
}

class Test_객체리스트정렬Comparator {
    static void sortStudent(List<Student2> data, Comparator<Student2> comp) {
        Student2 temp;
        for (int i = 0; i < data.size(); i++)
            for (int j = i + 1; j < data.size(); j++) {
                if (comp.compare(data.get(i), data.get(j)) > 0) {
                    temp = data.get(i);
                    data.set(i, data.get(j));
                    data.set(j, temp);
                }
            }
    }

    public static void main(String[] args) {
        Comparator<Student2> compSno = new Comparator<>() {
            @Override
            public int compare(Student2 s1, Student2 s2) {
                // Compare students by sno (student number)
                return s1.sno.compareTo(s2.sno);
            }
        };

        Comparator<Student2> compName = new Comparator<>() {
            @Override
            public int compare(Student2 s1, Student2 s2) {
                // Compare students by sname (student name)
                return s1.sname.compareTo(s2.sname);
            }
        };

        ArrayList<Student2> al = new ArrayList<>();
        al.add(new Student2("20210001", "Alice"));
        al.add(new Student2("20210003", "Bob"));
        al.add(new Student2("20210002", "Charlie"));

        // Sorting by student number (sno)
        sortStudent(al, compSno);
        System.out.println("Sorted by sno:");
        for (Student2 st : al)
            System.out.println(st);

        System.out.println();

        // Sorting by student name (sname)
        sortStudent(al, compName);
        System.out.println("Sorted by sname:");
        for (Student2 st : al)
            System.out.println(st);
    }
}

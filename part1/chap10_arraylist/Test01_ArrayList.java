package part1.chap10_arraylist;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test01_ArrayList {

    public static void main(String[] args) {

        Random rd = new Random();
        List<Person> list = new ArrayList();
        // name, age, subject
        Professor p1 = new Professor("교수1", 40, "자바");
        list.add(p1);

        Professor p2 = new Professor("교수2", 50, "파이썬");
        list.add(p2);

        for (int i = 1; i <= 10; i++) {
            Student s = new Student("name", i, "major");
            s.setName("학생" + i);
            s.setAge(rd.nextInt(20, 30));
            s.setMajor("컴공");
            list.add(s);
        }
//		System.out.println(list);
        list.forEach(p -> System.out.println(p));
    }

}
